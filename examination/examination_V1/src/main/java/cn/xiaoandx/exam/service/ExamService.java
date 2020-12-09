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
package cn.xiaoandx.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xiaoandx.commons.core.DaoCode;
import cn.xiaoandx.commons.core.PublicErrorCode;
import cn.xiaoandx.commons.exception.CommonException;
import cn.xiaoandx.commons.utils.IdAndTimeUtil;
import cn.xiaoandx.exam.dao.AnswerRecordDao;
import cn.xiaoandx.exam.dao.QuestionDao;
import cn.xiaoandx.exam.dao.QuestionOptionDao;
import cn.xiaoandx.exam.entity.Question;
import cn.xiaoandx.exam.entity.QuestionOption;
import cn.xiaoandx.exam.vo.KnowledgeNumberVO;
import cn.xiaoandx.exam.vo.OperationalStatusVO;
import cn.xiaoandx.exam.vo.PageData;
import cn.xiaoandx.exam.vo.QueryQuestionDomain;
import cn.xiaoandx.exam.vo.QueryQuestionStatisticVO;
import cn.xiaoandx.exam.vo.QuestionKnoVO;
import cn.xiaoandx.exam.vo.StatisticsAnswerRecordVO;

/**  
 * <p> 
 *	题库操作Service
 * </p> 
 * @ClassName:ExamService   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:23
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@Service
@Transactional
public class ExamService implements DaoCode{
	
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private QuestionOptionDao questionOptionDao;
	@Autowired
	private AnswerRecordDao answerRecordDao;

	/**  
	 *<p>添加试题</p> 
	 * @Title: addQuestion    
	 * @version:V1.0     
	 * @param question	试题对象
	 * @return:void
	 */
	public Question addQuestion(Question question) {
		if(null != question && question.getContent().length() != 0) {
			question.setId(IdAndTimeUtil.getQuestionId());
			question.setCreatedDate(IdAndTimeUtil.getNewDate());
			int number = questionDao.addQuestion(question);
			if(ADD_ERROR != number) {
				List<QuestionOption> queop = question.getQuestionOptions();
				for(QuestionOption qo : queop) {
					qo.setQuestionId(question.getId());
					qo.setCreatedDate(IdAndTimeUtil.getNewDate());
					questionOptionDao.addOption(qo);
				}
				return question;
			}
			throw new CommonException(PublicErrorCode.SAVE_EXCEPTION.getIntValue(), "save question error");
		}
		throw new CommonException(PublicErrorCode.SAVE_EXCEPTION.getIntValue(), "inpout question  error");
	}

	/**  
	 *<p>修改试题</p> 
	 * @Title: updateQuestion    
	 * @version:V1.0     
	 * @param id		试题id
	 * @param question	试题对象
	 * @return 
	 * @return:void
	 */
	public OperationalStatusVO updateQuestion(String id, Question question) {
		if(null != question) {
			question.setId(id);
			int number = questionDao.updateQuestion(question);
			if(ADD_ERROR != number) {
				List<QuestionOption> queop = question.getQuestionOptions();
				for(QuestionOption qo : queop) {
					qo.setQuestionId(id);
					int numberT = questionOptionDao.updateQuestion(qo);
					if(ADD_ERROR == numberT) {
						return new OperationalStatusVO(ERROR, "error");
					}
				}
			}
			return new OperationalStatusVO(ERROR, "error");
		}
		return new OperationalStatusVO(ERROR, "error");
	}

	/**  
	 *<p>删除试题</p> 
	 * @Title: deleteQuestion    
	 * @version:V1.0     
	 * @param id    
	 * @return:void
	 */
	public OperationalStatusVO deleteQuestion(String id) {
		int number = questionDao.deleteQuestion(id);
		if(ADD_ERROR == number) {
			return new OperationalStatusVO(400400, "delete question eroor");
		}
		int number2 = questionOptionDao.deleteQuestion(id);
		if(ADD_ERROR == number2) {
			return new OperationalStatusVO(ERROR, "delete questionOption eroor");
		}
		return new OperationalStatusVO(SUCCESS, "delete questionOption success"); 
	}

	/**  
	 *<p>分页查询试题</p> 
	 * @Title: getTestPage    
	 * @version:V1.0     
	 * @param domain 	分页查询信息对象
	 * @return:PageData<Question>	试题列表信息
	 */
	@Transactional(readOnly = true)
	public PageData<Question> getTestPage(QueryQuestionDomain domain) {
		PageData<Question> qu = questionDao.getTestPage(domain);
		//获得所有的试题
		List<Question> listqu = qu.getData();
		//将选项添加到试题中
		for(Question quf : listqu) {
			quf.setQuestionOptions(questionOptionDao.findById(quf.getId()));
		}
		//重新给PageData的Data属性赋值
		qu.setData(listqu);
		return qu;
	}

	/**  
	 *<p>查询所有的知识领域</p> 
	 * @Title: findAllknowledgeArea    
	 * @version:V1.0     
	 * @return:List<QuestionKnoVO>
	 */
	@Transactional(readOnly = true)
	public List<QuestionKnoVO> findAllknowledgeArea() {
		// TODO Auto-generated method stub
		return questionDao.findAllknowledgeArea();
	}

	/**
	 *<p>查询xx用户知识领域答对比例</p> 
	 * @Title: findKnoByUserId    
	 * @version:V1.0     
	 * @param id	用户id
	 * @return:List<KnowledgeNumberVO>	数据集合
	 */
	public List<KnowledgeNumberVO> findKnoByUserId(Integer userId) {
		return answerRecordDao.findKnoByUserId(userId);
	}

	/**
	 *<p>查询xx用户的答题记录（全部，正确，错误）分页查询</p> 
	 * @Title: findAnswerRByUserId    
	 * @version:V1.0     
	 * @param domain	页码信息对象
	 * @param userId	用户id
	 * @param IsCorrect	答题类型（正确0，错误1）
	 * @return:PageData<StatisticsAnswerRecordVO>	分页数据集合
	 */
	public PageData<StatisticsAnswerRecordVO> findAnswerRByUserId(QueryQuestionStatisticVO domain, Integer userId,
			Integer isCorrect) {
		// TODO Auto-generated method stub
		PageData<StatisticsAnswerRecordVO> pageSA = questionDao.getTestPageSta(domain , userId, isCorrect);
		//获得所有的试题
		List<StatisticsAnswerRecordVO> listqu = pageSA.getData();
		//将选项添加到试题中
		for(StatisticsAnswerRecordVO quf : listqu) {
			quf.setQuestionOptions(questionOptionDao.findById(quf.getTopic_id()));
		}
		//重新给PageData的Data属性赋值
		pageSA.setData(listqu);
		return pageSA;
	}
}
