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
package cn.xiaoandx.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.xiaoandx.commons.core.DaoCode;
import cn.xiaoandx.commons.core.PublicErrorCode;
import cn.xiaoandx.commons.exception.CommonException;
import cn.xiaoandx.exam.entity.Question;
import cn.xiaoandx.exam.service.ExamService;
import cn.xiaoandx.exam.service.IndexAnswerService;
import cn.xiaoandx.exam.vo.KnowledgeNumberVO;
import cn.xiaoandx.exam.vo.OperationalStatusVO;
import cn.xiaoandx.exam.vo.PageData;
import cn.xiaoandx.exam.vo.QueryQuestionDomain;
import cn.xiaoandx.exam.vo.QueryQuestionStatisticVO;
import cn.xiaoandx.exam.vo.QuestionKnoVO;
import cn.xiaoandx.exam.vo.StatisticsAnswerRecordVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**  
 * <p> 
 *	试题操作API接口
 * </p> 
 * @ClassName:ExamController   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:28
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@RequestMapping("/v1/open/examPo")
@Api(tags = "试题操作相关API")
@RestController
public class ExamController implements DaoCode{
	
	@Autowired
	private ExamService examService;
	@Autowired
	private IndexAnswerService indexAnswerService;
	
	/**
	 *<p>查询xxx某一道试题（包括选项）</p> 
	 * @Title: findById    
	 * @version:V1.0    
	 * @param id		试题id
	 * @return:Question	返回试题试题对象
	 */
	@GetMapping(value = "/findById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "GET", value = "根据ID查询试题(包括选项)", notes = "根据ID查询试题(包括选项)<br><br><b>@author xiaox.周巍</b>")
	@ApiResponses({
		@ApiResponse(code = 400,message = "未传入指定参数"),
		@ApiResponse(code = 404,message = "未找到指定页面")
	})
	public Question findById(@ApiParam(value = "试题id*必填",required = true)@PathVariable String id) {
		if(null != id && AFFERENT_PARAMETERS_STRING != id) {
			return indexAnswerService.findById(id);
		}
		throw new CommonException(PublicErrorCode.PARAM_EXCEPTION.getIntValue(), "question ID is null");
	}
	
	/**
	 *<p>添加试题</p> 
	 * @Title: addQuestion    
	 * @version:V1.0     
	 * @param question	试题对象
	 * @return:Question	返回添加试题的对象
	 */
	@PostMapping(value = "/addQuestion", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "POST",value = "添加试题",notes = "添加试题（包括选项）<br><br><b>@author xiaox.周巍</b>")
	@ApiResponses({
		@ApiResponse(code = 400,message = "未传入指定参数"),
		@ApiResponse(code = 404,message = "未找到指定页面")
	})
	public Question addQuestion(@ApiParam(value = "试题内容对象*必填",required = true) @RequestBody Question question) {
		if(null != question && null != question.getContent()) {
			if(null != question.getAnswer() && null != question.getKnowledgeArea()) {
				if(QUESTIONOPTIONCOUNT <= question.getQuestionOptions().size()) {
					return examService.addQuestion(question);
				}
				throw new CommonException(PublicErrorCode.PARAM_EXCEPTION.getIntValue(), "is QuestionOptions number >= 2");
			}
			throw new CommonException(PublicErrorCode.PARAM_EXCEPTION.getIntValue(), "answer or knowledgArea is null");
		}
		throw new CommonException(PublicErrorCode.PARAM_EXCEPTION.getIntValue(), "question or content is null");
	}
	
	/**
	 *<p>修改试题</p> 
	 * @Title: updateQuestion    
	 * @version:V1.0     
	 * @param question	修改内容
	 * @param id		需要修改试题的id
	 * @return:Question	修改后新试题对象
	 */
	@PutMapping(value = "/updateQuestion/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "PUT",value = "修改试题",notes = "修改试题（根据试题id）<br><br><b>@author xiaox.周巍</b>")
	@ApiResponses({
		@ApiResponse(code = 400,message = "未传入指定参数"),
		@ApiResponse(code = 404,message = "未找到指定页面")
	})
	public OperationalStatusVO updateQuestion(@ApiParam(value = "试题新内容对象*必填",required = true) @RequestBody Question question,
			@ApiParam(value = "要修改的试题id*必填",required = true)@PathVariable("id") String id) {
		if(null != id && AFFERENT_PARAMETERS_STRING != id) {
			if(null != question && null != question.getContent()) {
				if(null != question.getAnswer() && null != question.getKnowledgeArea()) {
					if(QUESTIONOPTIONCOUNT <= question.getQuestionOptions().size()) {
						examService.updateQuestion(id,question);
						return new OperationalStatusVO(SUCCESS, "success");
					}
					throw new CommonException(PublicErrorCode.PARAM_EXCEPTION.getIntValue(), "is QuestionOptions number >= 2");
				}
				throw new CommonException(PublicErrorCode.PARAM_EXCEPTION.getIntValue(), "answer or knowledgArea is null");
			}
			throw new CommonException(PublicErrorCode.PARAM_EXCEPTION.getIntValue(), "question or content is null");
		}
		throw new CommonException(PublicErrorCode.PARAM_EXCEPTION.getIntValue(), "question ID is null");
	}
	
	/**
	 *<p>删除试题</p> 
	 * @Title: deleteQuestion    
	 * @version:V1.0     
	 * @param id    	需要删除试题的id
	 * @return:void
	 */
	@DeleteMapping(value = "/deleteQuestion/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "DELETE",value = "删除试题",notes = "删除试题（根据试题id）<br><br><b>@author xiaox.周巍</b>")
	@ApiResponses({
		@ApiResponse(code = 400,message = "未传入指定参数"),
		@ApiResponse(code = 404,message = "未找到指定页面")
	})
	public OperationalStatusVO deleteQuestion(@ApiParam(value = "要删除的试题id*必填",required = true)@PathVariable("id") String id) {
		if(null != id && AFFERENT_PARAMETERS_STRING != id) {
			return examService.deleteQuestion(id);
		}
		throw new CommonException(PublicErrorCode.PARAM_EXCEPTION.getIntValue(), "id is null");
	}
	
	/**
	 *<p>分页查询（关键字查询*选择）题目信息</p> 
	 * @Title: page    
	 * @version:V1.0     
	 * @param domain	分页要求
	 * @return:PageData<Question>	查询的所有试题内容
	 */
	@RequestMapping(value = "/getQuestionByKeyPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "POST", value = "分页查询（关键字查询*选择）题目信息", response = Void.class, notes = "分页查询题目信息<br><br><b>@author xiaox.周巍</b>")
	@ApiResponses({
		@ApiResponse(code = 400,message = "未传入指定参数"),
		@ApiResponse(code = 404,message = "未找到指定页面")
	})
	public PageData<Question> getQuestionByKeyPage(
			@ApiParam(value = "<b>选填:</b><br>keyWords:查询关键字<b>必填:</b><br>pageNumber:第几页<br>pageSize:每页数据的数目<br>") 
			@RequestBody QueryQuestionDomain domain) {
		if(null != domain) {
			if(AFFERENT_PARAMETERS_NUMBER != domain.getPageNumber() && AFFERENT_PARAMETERS_NUMBER != domain.getPageSize()) {
				return examService.getTestPage(domain);
			}
			throw new CommonException(PublicErrorCode.PARAM_EXCEPTION.getIntValue(), "pageNumber or PageSize is null");
		}
		throw new CommonException(PublicErrorCode.PARAM_EXCEPTION.getIntValue(), "domain is null");
	}
	
	/**
	 *<p>查询所有的知识领域列表</p> 
	 * @Title: findAllknowledgeArea    
	 * @version:V1.0     
	 * @return:List<QuestionKnoVO>	知识领域的集合
	 */
	@PutMapping(value = "/findAllknowledgeArea", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "PUT",value = "查询所有的知识领域",notes = "查询所有的知识领域<br><br><b>@author xiaox.周巍</b>")
	public List<QuestionKnoVO> findAllknowledgeArea(){
		return examService.findAllknowledgeArea();
	}
	
	/**
	 *<p>查询xx用户知识领域答对比例</p> 
	 * @Title: findKnoByUserId    
	 * @version:V1.0     
	 * @param id	用户id
	 * @return:List<KnowledgeNumberVO>	数据集合
	 */
	@GetMapping(value = "/findKnoByUserId/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "GET",value = "查询xx用户知识领域答对比例",notes = "输入用户id，返回数据集合<br><br><b>@author xiaox.周巍</b>")
	@ApiResponses({
		@ApiResponse(code = 400,message = "未传入指定参数"),
		@ApiResponse(code = 404,message = "未找到指定页面")
	})
	public List<KnowledgeNumberVO> findKnoByUserId(
			@ApiParam(value = "用户id*必填",required = true)@PathVariable("userId") Integer userId){
		if(ZEROUSERID != userId) {
			return examService.findKnoByUserId(userId);
		}
		throw new CommonException(PublicErrorCode.PARAM_EXCEPTION.getIntValue(), "userId is 0");
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
	@PutMapping(value = "/findAnswerRByUserId/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "PUT",value = "查询xx用户的答题记录（全部，正确，错误）",notes = "分页查询 <br><br><b>@author xiaox.周巍</b>")
	@ApiResponses({
		@ApiResponse(code = 400,message = "未传入指定参数"),
		@ApiResponse(code = 404,message = "未找到指定页面")
	})
	public PageData<StatisticsAnswerRecordVO> findAnswerRByUserId(
			@ApiParam(value = "<b>选填(默认全部答题记录):</b><br>IsCorrect:查询xx的答题记录<b>必填:</b><br>pageNumber:第几页<br>pageSize:每页数据的数目<br>") 
			@RequestBody QueryQuestionStatisticVO domain, 
			@ApiParam(value = "要查询的某个用户的userId*必填",required = true)@PathVariable("userId") Integer userId
			){
		if(ZEROUSERID != userId) {
			if(AFFERENT_PARAMETERS_NUMBER != domain.getPageNumber() && AFFERENT_PARAMETERS_NUMBER != domain.getPageSize()) {
				return examService.findAnswerRByUserId(domain, userId, domain.getIsCorrect());
			}
			throw new CommonException(PublicErrorCode.PARAM_EXCEPTION.getIntValue(), "pageNumber or PageSize is null");
		}
		throw new CommonException(PublicErrorCode.PARAM_EXCEPTION.getIntValue(), "userId is 0 or null");
	}
}
