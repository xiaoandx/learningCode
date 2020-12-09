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

import cn.xiaoandx.commons.core.PublicErrorCode;
import cn.xiaoandx.commons.exception.CommonException;
import cn.xiaoandx.exam.entity.Question;
import cn.xiaoandx.exam.entity.TotalCollcetSubject;
import cn.xiaoandx.exam.vo.AnswerRanking;
import cn.xiaoandx.exam.vo.AnswerRankingVo;
import cn.xiaoandx.exam.vo.AnswerUser;
import cn.xiaoandx.user.vo.OneValueVO;

/**  
 * <p> 
 *	答题汇总数据库操作DAO
 * </p> 
 * @ClassName:TotalCollcetDao   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:27
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@Component
public class TotalCollcetDao {

	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	/**  
	 *<p>根据用户userId查询成绩</p> 
	 * @Title: findSrcoeByOpenId    
	 * @version:V1.0     
	 * @param userId 	用户id
	 * @return:TotalCollcetSubject	汇总数据对象（含总成绩）
	 */
	public TotalCollcetSubject findSrcoeByOpenId(int userId) {
		RowMapper<TotalCollcetSubject> totalRowMapper = new BeanPropertyRowMapper<TotalCollcetSubject>(TotalCollcetSubject.class);
		String questionSql = "SELECT t.total_fraction,t.user_id "
				+ "FROM `user` AS u RIGHT JOIN total_collcet_subject as t ON u.id = t.user_id "
				+ "WHERE u.id = ?";
		try {
			return jdbcTemplate.queryForObject(questionSql, totalRowMapper, userId);
		} catch (Exception e) {
			throw new CommonException(PublicErrorCode.PARAM_EXCEPTION.getIntValue(), "查询失败，检测传参");
		}
	}

	/**  
	 *<p>查询排名</p> 
	 * @Title: findRanking    
	 * @version:V1.0     
	 * @return:List<TotalCollcetSubject>	排名信息集合
	 */
	public List<AnswerRanking> findRanking() {
		RowMapper<AnswerRanking> rowMapper = new BeanPropertyRowMapper<AnswerRanking>(AnswerRanking.class);
		String optionSql = "SELECT u.`id`,b.total_fraction,b.rownum,u.`nickname`,u.`head_portrait` ,u.`city` "
				+ "FROM (SELECT  t.*, @rownum := @rownum + 1 AS rownum  FROM  (SELECT @rownum := 0) r, total_collcet_subject AS t "
				+ "ORDER BY total_fraction DESC ) as b  LEFT JOIN `user` AS u ON b.user_id = u.id "
				+ "LIMIT 0,50";
		return jdbcTemplate.query(optionSql, rowMapper);
	}

	/**  
	 *<p>查询有无xx用户的汇总数据</p> 
	 * @Title: findByUserId    
	 * @version:V1.0     
	 * @param answerUser	答题对象
	 * @return:List<TotalCollcetSubject>	该xx用户的答题汇总数据(又无)
	 */
	public List<TotalCollcetSubject> findByUserId(int userId) {
		RowMapper<TotalCollcetSubject> rowMapper = new BeanPropertyRowMapper<TotalCollcetSubject>(TotalCollcetSubject.class);
		String optionSql = "SELECT `id`, `user_id`, `total_fraction`, `sum_correct_subject_number`, `sum_wrong_subject_number`, `sum_subject_namber` "
				+ "FROM `total_collcet_subject` "
				+ "WHERE `user_id` = ?";
		return jdbcTemplate.query(optionSql, rowMapper,userId);
	}


	/**  
	 *<p>插入新的汇总表数据</p> 
	 * @Title: addTotaUser    
	 * @version:V1.0     
	 * @param question	试题对象
	 * @param answerUser	用户选择答案试题
	 * @return:int	操作结果
	 */
	public int addTotaUser(Question question, AnswerUser answerUser) {
		String sql = "INSERT INTO `total_collcet_subject` "
				+ "(`user_id`,`total_fraction`,`sum_correct_subject_number`,`sum_wrong_subject_number`,`sum_subject_namber`) "
				+ "VALUES (?,?,?,?,?)";
		int number = jdbcTemplate.update(sql,answerUser.getUserId(),
				(question.getAnswer().equalsIgnoreCase(answerUser.getCorrectAnswer()) ? 10 : 0),
				(question.getAnswer().equalsIgnoreCase(answerUser.getCorrectAnswer()) ? 1 : 0),
				(question.getAnswer().equalsIgnoreCase(answerUser.getCorrectAnswer()) ? 0 : 1),1);
		return number;
	}

	/**  
	 *<p>更具用户id查询表</p> 
	 * @Title: findByUserID    
	 * @version:V1.0     
	 * @param answerUser	用户选择答案对象
	 * @return:TotalCollcetSubject	xx用户的汇总
	 */
	public TotalCollcetSubject findByUserID(Integer userId) {
		RowMapper<TotalCollcetSubject> rowMapper = new BeanPropertyRowMapper<TotalCollcetSubject>(TotalCollcetSubject.class);
		String sql = "SELECT `id`, `user_id`, `total_fraction`, `sum_correct_subject_number`, `sum_wrong_subject_number`, `sum_subject_namber` "
				+ "FROM `total_collcet_subject` "
				+ "WHERE `user_id` = ?";
		return jdbcTemplate.queryForObject(sql, rowMapper,userId);
	}

	/**  
	 *<p>获取xx用户的排名即总分</p> 
	 * @Title: findUserRanking    
	 * @version:V1.0     
	 * @param userId	用户id
	 * @return:AnswerRanking	xx用户的总分及排名vo对象
	 */
	public AnswerRanking findUserRanking(Integer userId){
		RowMapper<AnswerRanking> rowMapper = new BeanPropertyRowMapper<AnswerRanking>(AnswerRanking.class);
		String optionSql = "SELECT u.`id`,b.total_fraction,b.rownum,u.`nickname`,u.`head_portrait` ,u.`city` "
				+ "FROM (SELECT  t.*, @rownum := @rownum + 1 AS rownum  FROM  (SELECT @rownum := 0) r, total_collcet_subject AS t "
				+ "ORDER BY total_fraction DESC ) as b  LEFT JOIN `user` AS u ON b.user_id = u.id "
				+ "WHERE b.user_id = ? ";
		return jdbcTemplate.queryForObject(optionSql, rowMapper,userId);
	}

	/**  
	 *<p>初始化数据</p> 
	 * @Title: addDefulent    
	 * @version:V1.0     
	 * @param oneValueVO	注册人脸token及用户id对象
	 * @return:int	操作结果
	 */
	public int addDefulent(OneValueVO oneValueVO) {
		String sql = "INSERT INTO `total_collcet_subject` "
				+ "(`user_id`,`total_fraction`,`sum_correct_subject_number`,`sum_wrong_subject_number`,`sum_subject_namber`) "
				+ "VALUES (?,?,?,?,?)";
		int number = jdbcTemplate.update(sql,oneValueVO.getUserId(),0,0,0,0);
		return number;
	}
	
	/////////////////更新数据///////////////

	/**  
	 *<p>回答正确</p> 
	 * @Title: updateUserok    
	 * @version:V1.0     
	 * @param question	试题对象
	 * @param answerUser	用户选择答案对象
	 * @return:int	操作结果
	 */
	public int updateUserok(Question question, AnswerUser answerUser) {
		String sql = "UPDATE `total_collcet_subject` SET "
				+ "`sum_correct_subject_number` = `sum_correct_subject_number`+?, "
				+ "`sum_wrong_subject_number` =  `sum_wrong_subject_number`+?, "
				+ "`sum_subject_namber` = `sum_subject_namber`+?, "
				+ "`total_fraction` = `total_fraction`+? "
				+ "WHERE `user_id` = ?;";
		int number = jdbcTemplate.update(sql,1,0,1,10,answerUser.getUserId());
		return number;
	}
	
	/**  
	 *<p>回答错误</p> 
	 * @Title: updateUserok    
	 * @version:V1.0     
	 * @param question	试题对象
	 * @param answerUser	用户选择答案对象
	 * @return:int	操作结果
	 */
	public int updateUserError(Question question, AnswerUser answerUser) {
		String sql = "UPDATE `total_collcet_subject` SET "
				+ "`sum_correct_subject_number` = `sum_correct_subject_number`+?, "
				+ "`sum_wrong_subject_number` =  `sum_wrong_subject_number`+?, "
				+ "`sum_subject_namber` = `sum_subject_namber`+?, "
				+ "`total_fraction` = `total_fraction`-? "
				+ "WHERE `user_id` = ?;";
		int number = jdbcTemplate.update(sql,0,1,1,5,answerUser.getUserId());
		return number;
	}

	/**  
	 *<p>第二次回答错误</p> 
	 * @Title: updateUserErrorTo    
	 * @version:V1.0     
	 * @param question	试题对象
	 * @param answerUser	用户选择答案对象
	 * @return:int	操作结果
	 */
	public int updateUserErrorTo(Question question, AnswerUser answerUser) {
		String sql = "UPDATE `total_collcet_subject` SET "
				+ "`sum_correct_subject_number` = `sum_correct_subject_number`+?, "
				+ "`sum_wrong_subject_number` =  `sum_wrong_subject_number`+?, "
				+ "`sum_subject_namber` = `sum_subject_namber`+?, "
				+ "`total_fraction` = `total_fraction`-? "
				+ "WHERE `user_id` = ?;";
		int number = jdbcTemplate.update(sql,0,1,1,0,answerUser.getUserId());
		return number;
	}

	/**  
	 *<p>查询TOP50排行榜 无自定义排名</p> 
	 * @Title: findRankingList    
	 * @version:V1.0     
	 * @return:List<AnswerRankingVo>
	 */
	public List<AnswerRankingVo> findRankingList() {
		RowMapper<AnswerRankingVo> rowMapper = new BeanPropertyRowMapper<AnswerRankingVo>(AnswerRankingVo.class);
		String optionSql = "SELECT t.user_id,t.total_fraction,u.head_portrait,u.nickname,u.city "
				+ "FROM total_collcet_subject as t,`user` as u  "
				+ "WHERE t.user_id = u.id "
				+ "ORDER BY t.total_fraction DESC "
				+ "LIMIT 0,50";
		return jdbcTemplate.query(optionSql, rowMapper);
	}

}
