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
import cn.xiaoandx.exam.entity.AnswerRecord;
import cn.xiaoandx.exam.entity.Question;
import cn.xiaoandx.exam.vo.AnswerUser;
import cn.xiaoandx.exam.vo.KnowledgeNumberVO;

/**  
 * <p> 
 *	答题记录数据操作DAO
 * </p> 
 * @ClassName:AnswerRecordDao   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:26
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@Component
public class AnswerRecordDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	/**  
	 *<p>答题后更新答题记录表</p> 
	 * @Title: addQuestion    
	 * @version:V1.0     
	 * @param question	随机试题对象
	 * @param answerUser	选择答案的对象
	 * @return:int	操作结果
	 */
	public int addQuestion(Question question, AnswerUser answerUser) {
		String sql = "INSERT INTO  `answer_record` "
				+ "(`topic_id`,`submit_option`,`true_or_flase`,`user_id`,`correct_answer`,`answer_time`,`knowledge_domain`,`score`) "
				+ "VALUES (?,?,?,?,?,?,?,?)";
		int number = jdbcTemplate.update(sql,answerUser.getQuestionId(),
				answerUser.getCorrectAnswer(),(question.getAnswer().equalsIgnoreCase(answerUser.getCorrectAnswer()) ? 0 : 1),
				answerUser.getUserId(),question.getAnswer(),IdAndTimeUtil.getNewDate(),question.getKnowledgeArea(),
				(question.getAnswer().equalsIgnoreCase(answerUser.getCorrectAnswer()) ? 10 : 0));
		return number;
	}

	/**  
	 *<p>查询xx'用户最擅长的三个知识领域</p> 
	 * @Title: findKDByUserId    
	 * @version:V1.0     
	 * @param userId	用户id
	 * @return:List<AnswerRecord>	该用户最擅长的三个知识领域集合
	 */
	public List<AnswerRecord> findKDByUserId(Integer userId) {
		RowMapper<AnswerRecord> rowMapper=new BeanPropertyRowMapper<AnswerRecord>(AnswerRecord.class);
		String optionSql = "SELECT user_id,`knowledge_domain` ,COUNT(knowledge_domain) AS number "
				+ "FROM  `answer_record`  "
				+ "WHERE user_id = ?  AND true_or_flase = 0  "
				+ "GROUP BY knowledge_domain DESC "
				+ "ORDER BY number DESC LIMIT 0,3";
		return jdbcTemplate.query(optionSql, rowMapper,userId);
	}

	/**  
	 *<p>查询xx用户知识领域答对比例</p> 
	 * @Title: findKnoByUserId    
	 * @version:V1.0     
	 * @param userId
	 * @return:List<KnowledgeNumberVO>
	 */
	public List<KnowledgeNumberVO> findKnoByUserId(Integer userId) {
		RowMapper<KnowledgeNumberVO> rowMapper=new BeanPropertyRowMapper<KnowledgeNumberVO>(KnowledgeNumberVO.class);
		String sql = "SELECT t1.user_id, t1.knowledge_domain, CONCAT( SUBSTRING((t1.n1 / t2.n2) * 100, 1, 5),'%') percentage "
				+ "FROM (SELECT user_id, knowledge_domain, COUNT(*) n1 "
				+ "FROM answer_record WHERE user_id =? AND true_or_flase = 0 GROUP BY knowledge_domain) AS t1 "
				+ "JOIN ( SELECT user_id, knowledge_domain, COUNT(*) n2 "
				+ "FROM answer_record WHERE user_id = ? GROUP BY knowledge_domain ) AS t2 ON t1.user_id = t2.user_id "
				+ "WHERE t1.knowledge_domain = t2.knowledge_domain "
				+ "ORDER BY percentage DESC "
				+ "LIMIT 0,5";
		
		return jdbcTemplate.query(sql, rowMapper, userId, userId);
	}
}
