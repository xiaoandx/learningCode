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

import cn.xiaoandx.exam.entity.QuestionOption;
import lombok.extern.slf4j.Slf4j;

/**  
 * <p> 
 *	试题选项操作DAO
 * </p> 
 * @ClassName:QuestionOptionDao   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:27
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@Component
@Slf4j
public class QuestionOptionDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	/**
	 *<p>根据试题id查询其选项</p> 
	 * @Title: findById    
	 * @version:V1.0     
	 * @param id
	 * @return:List<QuestionOption> 返回所有选项的list集合
	 */
	public List<QuestionOption> findById(String id) {
		RowMapper<QuestionOption> rowMapper=new BeanPropertyRowMapper<QuestionOption>(QuestionOption.class);
		String optionSql = "SELECT ID,`OPTION`,OPTION_CONTENT,QUESTION_ID,CREATED_DATE "
				+ "FROM t_question_option WHERE QUESTION_ID = ?";
		return jdbcTemplate.query(optionSql, rowMapper,id);
	}

	/**  
	 *<p>添加选项</p> 
	 * @Title: addOption    
	 * @version:V1.0     
	 * @param questionOption    
	 * @return:void
	 */
	public void addOption(QuestionOption questionOption) {
		String addOptionSql = "INSERT INTO  `t_question_option` (`OPTION`,`OPTION_CONTENT`,`QUESTION_ID`,`CREATED_DATE`) VALUES (?,?,?,?)";
		int number = jdbcTemplate.update(addOptionSql,questionOption.getOption(),questionOption.getOptionContent(),questionOption.getQuestionId(),questionOption.getCreatedDate());
		log.info("==========选项========="+String.valueOf(number));
	}

	/**  
	 *<p>修改xx试题的选项</p> 
	 * @Title: updateQuestion    
	 * @version:V1.0     
	 * @param qo    
	 * @return:void
	 */
	public int updateQuestion(QuestionOption qo) {
		String sql = "UPDATE  `t_question_option` SET `OPTION_CONTENT` = ? WHERE `QUESTION_ID` = ? AND `OPTION` = ?";
		int number = jdbcTemplate.update(sql,qo.getOptionContent(),qo.getQuestionId(),qo.getOption());
		log.info("==========修改选项========="+String.valueOf(number));
		return number;
	}

	/**  
	 *<p>删除xx试题的选项</p> 
	 * @Title: deleteQuestion    
	 * @version:V1.0     
	 * @param id    
	 * @return:void
	 */
	public int deleteQuestion(String id) {
		String sql = "DELETE FROM `t_question_option` WHERE `QUESTION_ID` = ?";
		int number = jdbcTemplate.update(sql,id);
		log.info("==========删除"+id+"的答题选项========="+String.valueOf(number));
		return number;
	}
}
