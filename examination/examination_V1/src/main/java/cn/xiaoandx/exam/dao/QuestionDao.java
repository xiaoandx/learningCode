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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import cn.xiaoandx.commons.core.Parameter;
import cn.xiaoandx.commons.core.PublicErrorCode;
import cn.xiaoandx.commons.exception.CommonException;
import cn.xiaoandx.commons.utils.PageJdbcUtil;
import cn.xiaoandx.exam.entity.Question;
import cn.xiaoandx.exam.vo.PageData;
import cn.xiaoandx.exam.vo.QueryQuestionDomain;
import cn.xiaoandx.exam.vo.QueryQuestionStatisticVO;
import cn.xiaoandx.exam.vo.QuestionKnoVO;
import cn.xiaoandx.exam.vo.StatisticsAnswerRecordVO;
import lombok.extern.slf4j.Slf4j;

/**  
 * <p> 
 *	试题操作DAO
 * </p> 
 * @ClassName:QuestionDao   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:26
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@Component
@Slf4j
public class QuestionDao implements Parameter{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Autowired
	private PageJdbcUtil pageJdbcUtil;
	
	/**
	 *<p>根据试题id查询试题</p> 
	 * @Title: findById    
	 * @version:V1.0     
	 * @param id	试题id
	 * @return:Question	返回试题内容对象
	 */
	public Question findById(String id) {
		try {
			RowMapper<Question> questionRowMapper=new BeanPropertyRowMapper<Question>(Question.class);
			String questionSql = "SELECT ID,CONTENT,ANSWER,KNOWLEDGE_AREA,CREATED_DATE "
					+ "FROM t_question WHERE ID=?";
			return jdbcTemplate.queryForObject(questionSql, questionRowMapper, id);
		} catch (DataAccessException e) {
			throw new CommonException(PublicErrorCode.QUERY_EXCEPTION.getIntValue(), "id is Non-existent");
		}
	}

	/**  
	 *<p>添加试题</p> 
	 * @Title: addQuestion    
	 * @version:V1.0     
	 * @param question    试题对象
	 * @return:number	添加试题成功返回1，失败返回0
	 */
	public int addQuestion(Question question) {
		String addSql = "INSERT INTO `t_question` (`ID`,`CONTENT`,`ANSWER`,`KNOWLEDGE_AREA`,`CREATED_DATE`) VALUES (?,?,?,?,?)";
		int number = jdbcTemplate.update(addSql,question.getId(),question.getContent(),question.getAnswer(),question.getKnowledgeArea(),question.getCreatedDate());
		log.info("=========添加试题=========="+String.valueOf(number));
		return number;
	}

	/**  
	 *<p>修改试题</p> 
	 * @Title: updateQuestion    
	 * @version:V1.0     
	 * @param question    包含修改后的新试题对象
	 * @return:number	修改试题成功返回1，失败返回0
	 */
	public int updateQuestion(Question question) {
		String content = " `CONTENT` = ?  ", answer = " `ANSWER` = ? ", know = " `KNOWLEDGE_AREA` = ?  ";
		String newSql, front = "UPDATE  `t_question` SET " , tail = "WHERE `ID` = ?";
		if(null != question.getContent()) {
			if(null != question.getAnswer()) {
				if(null != question.getKnowledgeArea()) {
					newSql = front + content + ", " + answer + ", " + know + tail;
					int number = jdbcTemplate.update(newSql, question.getContent(), question.getAnswer(), question.getKnowledgeArea(), question.getId());
					log.info("========修改试题==========="+String.valueOf(number));
					return number;
				}
				newSql = front + content + ", " + answer  + tail;
				int number = jdbcTemplate.update(newSql, question.getContent(), question.getAnswer(), question.getId());
				log.info("========修改试题==========="+String.valueOf(number));
				return number;
			}
			newSql = front + content  + tail;
			int number = jdbcTemplate.update(newSql, question.getContent(), question.getId());
			log.info("========修改试题==========="+String.valueOf(number));
			return number;
		}
		throw new CommonException(PublicErrorCode.PARAM_EXCEPTION.getIntValue(), "update question is null");
	}

	/**  
	 *<p>删除试题</p> 
	 * @Title: deleteQuestion    
	 * @version:V1.0     
	 * @param id    试题id
	 * @return:number	删除试题成功返回1，失败返回0
	 */
	public int deleteQuestion(String id) {
		String sql = "DELETE FROM `t_question` WHERE `ID` = ?";
		int number = jdbcTemplate.update(sql,id);
		log.info("========删除试题==========="+String.valueOf(number));
		return number;
	}
	
	/**  
	 *<p>分查询试题</p> 
	 * @Title: getTestPage    
	 * @version:V1.0     
	 * @param domain	分页查询信息对象
	 * @return:PageData<Question>
	 */
	public PageData<Question> getTestPage(QueryQuestionDomain domain) {
		String newSql, countSql = "SELECT count(1) FROM `t_question` " ;
		if(null != domain.getKeyWords()) {
			newSql = "SELECT ID, CONTENT, ANSWER,KNOWLEDGE_AREA  FROM  `t_question` where CONTENT LIKE '%" + domain.getKeyWords() + "%'";
			log.info(newSql);
		}else {
			newSql = "SELECT ID, CONTENT, ANSWER,KNOWLEDGE_AREA  FROM  `t_question` ";	
		}
		return pageJdbcUtil.getPageData(domain.getPageSize(),
				domain.getPageNumber(), testRM, newSql, countSql);
	}
	
	/**
	 * 生成一个试题RowMapper
	 */
	RowMapper<Question> testRM = new RowMapper<Question>() {
		public Question mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			Question test = new Question();
			test.setId(rs.getString("ID"));
        	test.setContent(rs.getString("CONTENT"));
        	test.setAnswer(rs.getString("ANSWER"));
        	test.setKnowledgeArea(rs.getString("KNOWLEDGE_AREA"));
			return test;
		}
	};

	/**  
	 *<p>查询所有的知识领域</p> 
	 * @Title: findAllknowledgeArea    
	 * @version:V1.0     
	 * @return    
	 * @return:List<QuestionKnoVO>
	 */
	public List<QuestionKnoVO> findAllknowledgeArea() {
		// TODO Auto-generated method stub
		RowMapper<QuestionKnoVO> rowMaper = new BeanPropertyRowMapper<QuestionKnoVO>(QuestionKnoVO.class);
		String sql = "SELECT t.KNOWLEDGE_AREA,COUNT(*) AS number FROM t_question AS t "
				+ "GROUP BY t.KNOWLEDGE_AREA "
				+ "ORDER BY number DESC";
		return jdbcTemplate.query(sql, rowMaper);
	}

	/**
	 *<p>查询xx用户的答题记录（全部，正确，错误）分页查询</p> 
	 * @Title: getTestPageSta    
	 * @version:V1.0     
	 * @param domain	页码信息对象
	 * @param userId	用户id
	 * @param IsCorrect	答题类型（正确0，错误1）
	 * @return:PageData<StatisticsAnswerRecordVO>	分页数据集合
	 */
	public PageData<StatisticsAnswerRecordVO> getTestPageSta(QueryQuestionStatisticVO domain, Integer userId,
			Integer isCorrect) {
		RowMapper<StatisticsAnswerRecordVO> rowMapper = new BeanPropertyRowMapper<StatisticsAnswerRecordVO>(StatisticsAnswerRecordVO.class);
		String newSql = "";
		String newCountSql = "";
		String countNumber = "SELECT COUNT(*) FROM answer_record AS a WHERE a.user_id = " + userId;
		String frontSql = "SELECT a.user_id, a.topic_id, a.submit_option, a.correct_answer, a.answer_time,t.content,t.knowledge_area "
				+ "FROM answer_record AS a LEFT JOIN t_question AS t ON a.topic_id = t.id "
				+ "WHERE a.user_id = "+ userId;
		String staok = " AND a.true_or_flase = 0 ", staerror = " AND a.true_or_flase = 1 ";
		String afterSql = " ORDER BY a.answer_time DESC";
		newSql = frontSql + afterSql;
		newCountSql = countNumber;
		if (null != isCorrect) {
			if (ENTER_ONE == isCorrect) {
				newSql = frontSql + staok + afterSql;
				newCountSql = countNumber + staok;
			}
			if (ENTER_TWO == isCorrect) {
				newSql = frontSql + staerror + afterSql;
				newCountSql = countNumber + staerror;
			}
		}
		log.info(newSql +"===================="+newCountSql);
		return pageJdbcUtil.getPageData(domain.getPageSize(),
				domain.getPageNumber(), rowMapper, newSql, newCountSql);
	}
}
