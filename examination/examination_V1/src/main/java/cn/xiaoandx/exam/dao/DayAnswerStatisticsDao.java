/*
 * Copyright 2019-2020 the original WEI.ZHOU.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.xiaoandx.exam.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import cn.xiaoandx.commons.utils.IdAndTimeUtil;
import cn.xiaoandx.exam.entity.DayAnswerStatistics;
import cn.xiaoandx.exam.entity.Question;
import cn.xiaoandx.exam.vo.AnswerUser;
import cn.xiaoandx.exam.vo.UserDayAnswer;

/**  
 * <p> 
 *	每日答题记录操作DAO
 * </p> 
 * @ClassName:DayAnswerStatisticsDao   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:26
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@Component
public class DayAnswerStatisticsDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	/**  
	 *<p>查询当天用户是否情况</p> 
	 * @Title: findBy    
	 * @version:V1.0     
	 * @param answerUser	用户提交答案的对象
	 * @return:List<DayAnswerStatistics>	用户当天的答题结果
	 */
	public List<DayAnswerStatistics> findBy(AnswerUser answerUser) {
		RowMapper<DayAnswerStatistics> rowMapper=new BeanPropertyRowMapper<DayAnswerStatistics>(DayAnswerStatistics.class);
		String optionSql = "SELECT `id`, `user_id`, `answer_correct_subject_number`, `answers_error_subject_number`, "
				+ "`answer_subject_total`, `current_score`, `same_day_score`, `answer_time` "
				+ "FROM `day_answer_statistics` "
				+ "WHERE `user_id` = ? AND DATE(`answer_time`) = ?;";
		return jdbcTemplate.query(optionSql, rowMapper,answerUser.getUserId(),IdAndTimeUtil.getDate());
	}

	/**  
	 *<p>添加每日答题记录（用户当天没有答题才情况下）</p> 
	 * @Title: add    
	 * @version:V1.0     
	 * @param question	试题对象
	 * @param answerUser	用户提交答案对象
	 * @return:int	操作结果
	 */
	public int add(Question question, AnswerUser answerUser) {
		String sql = "INSERT INTO `day_answer_statistics` "
				+ "(`user_id`,`answer_correct_subject_number`,`answers_error_subject_number`,`answer_subject_total`,`current_score`,`same_day_score`,`answer_time`) "
				+ "VALUES (?,?,?,?,?,?,?)";
		int number = jdbcTemplate.update(sql,answerUser.getUserId(),
				(question.getAnswer().equalsIgnoreCase(answerUser.getCorrectAnswer()) ? 1 : 0),
				(question.getAnswer().equalsIgnoreCase(answerUser.getCorrectAnswer()) ? 0 : 1),
				1,(question.getAnswer().equalsIgnoreCase(answerUser.getCorrectAnswer()) ? 10 : 0),
				(question.getAnswer().equalsIgnoreCase(answerUser.getCorrectAnswer()) ? 10 : 0),IdAndTimeUtil.getDate()
				);
		return number;
	}

	/**  
	 *<p>查询xx用户每日的答题记录</p> 
	 * @Title: findDayAnswer    
	 * @version:V1.0     
	 * @param userId	用户id
	 * @return:List<UserDayAnswer>	xx用户的每日答题汇总集合
	 */
	public List<UserDayAnswer> findDayAnswer(Integer userId) {
		RowMapper<UserDayAnswer> rowMapper=new BeanPropertyRowMapper<UserDayAnswer>(UserDayAnswer.class);
		String sql = "SELECT DATE(d.answer_time) as answerTime, "
				+ "SUM(d.answer_subject_total) AS subTotal,"
				+ "SUM(d.answer_correct_subject_number) AS correctNumber, "
				+ "SUM(d.answers_error_subject_number) AS errorNUmber ,"
				+ "SUM(d.same_day_score) AS dayScore FROM day_answer_statistics AS d "
				+ "WHERE user_id = ? "
				+ "GROUP BY DATE(d.answer_time) "
				+ "ORDER BY DATE(d.answer_time) DESC";
		return jdbcTemplate.query(sql, rowMapper,userId);
	}

	/**  
	 *<p>回答正确时就进行更新（条件：当天已经答题了）</p> 
	 * @Title: updateok    
	 * @version:V1.0     
	 * @param question	试题对象
	 * @param answerUser	用户选择答案对象
	 * @return:int	操作结果
	 */
	public int updateok(Question question, AnswerUser answerUser) {
		String sql = "UPDATE `day_answer_statistics` "
				+ "SET `answer_correct_subject_number` = `answer_correct_subject_number`+?, "
				+ "`answers_error_subject_number` =`answers_error_subject_number`+?, "
				+ "`answer_subject_total` = `answer_subject_total`+?, "
				+ "`current_score` = `current_score`+?, "
				+ "`same_day_score` = `same_day_score`+? "
				+ "WHERE `user_id` = ? AND DATE(`answer_time`) = ?";
		int number = jdbcTemplate.update(sql, 1,0,1,10,10,answerUser.getUserId(),IdAndTimeUtil.getDate());
		return number;
	}
	
	/**
	 *<p>回答错误（条件：当天已经答题了）</p> 
	 * @Title: updateError    
	 * @version:V1.0     
	 * @param question	试题对象
	 * @param answerUser	用户选择答案对象
	 * @return:int	操作结果
	 */
	public int updateError(Question question, AnswerUser answerUser,int score) {
		String sql = "UPDATE `day_answer_statistics` "
				+ "SET `answer_correct_subject_number` = `answer_correct_subject_number`+?, "
				+ "`answers_error_subject_number` =`answers_error_subject_number`+?, "
				+ "`answer_subject_total` = `answer_subject_total`+?, "
				+ "`current_score` = `current_score`-?, "
				+ "`same_day_score` = `same_day_score`-? "
				+ "WHERE `user_id` = ? AND DATE(`answer_time`) = ?";
		int number = jdbcTemplate.update(sql, 0,1,1,score,score,answerUser.getUserId(),IdAndTimeUtil.getDate());
		return number;
	}

	/**  
	 *<p>第一次回答错误（用户第一次操作就错的时候）</p> 
	 * @Title: addError    
	 * @version:V1.0     
	 * @param question	试题对象
	 * @param answerUser	用户选择答案对象
	 * @return:int	操作结果
	 */
	public int addError(Question question, AnswerUser answerUser) {
		String sql = "INSERT INTO `day_answer_statistics` "
				+ "(`user_id`,`answer_correct_subject_number`,`answers_error_subject_number`,`answer_subject_total`,`current_score`,`same_day_score`,`answer_time`) "
				+ "VALUES (?,?,?,?,?,?,?)";
		int number = jdbcTemplate.update(sql,answerUser.getUserId(),0,1,1,0,0,IdAndTimeUtil.getDate()
				);
		return number;
	}

	/**  
	 *<p>第一次为零后又错题</p> -----
	 * @Title: updateErrorTo    
	 * @version:V1.0     
	 * @param question	试题对象
	 * @param answerUser	用户选择答案对象
	 * @return:int	操作结果
	 */
	public int updateErrorTo(Question question, AnswerUser answerUser) {
		String sql = "UPDATE `day_answer_statistics` "
				+ "SET `answer_correct_subject_number` = `answer_correct_subject_number`+?, "
				+ "`answers_error_subject_number` =`answers_error_subject_number`+?, "
				+ "`answer_subject_total` = `answer_subject_total`+?, "
				+ "`current_score` = `current_score`-?, "
				+ "`same_day_score` = `same_day_score`-? "
				+ "WHERE `user_id` = ? AND DATE(`answer_time`) = ?";
		int number = jdbcTemplate.update(sql, 0,1,1,0,0,answerUser.getUserId(),IdAndTimeUtil.getDate());
		return number;
	}

	
	/**  
	 *<p>判断当天的汇总成绩</p> 
	 * @Title: findByIdAndTime    
	 * @version:V1.0     
	 * @param answerUser
	 * @return    
	 * @return:DayAnswerStatistics
	 */
	public DayAnswerStatistics findByIdAndTime(AnswerUser answerUser) {
		RowMapper<DayAnswerStatistics> rowMapper=new BeanPropertyRowMapper<DayAnswerStatistics>(DayAnswerStatistics.class);
		String optionSql = "SELECT `id`, `user_id`, `answer_correct_subject_number`, `answers_error_subject_number`, "
				+ "`answer_subject_total`, `current_score`, `same_day_score`, `answer_time` "
				+ "FROM `day_answer_statistics` "
				+ "WHERE user_id = ? AND DATE(answer_time) = CURDATE()";
		return jdbcTemplate.queryForObject(optionSql, rowMapper, answerUser.getUserId());	
	}
}
