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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.xiaoandx.commons.utils.IdAndTimeUtil;
import cn.xiaoandx.exam.entity.Question;
import cn.xiaoandx.exam.entity.TotalCollcetSubject;
import cn.xiaoandx.exam.service.IndexAnswerService;
import cn.xiaoandx.exam.vo.AboutMe;
import cn.xiaoandx.exam.vo.AnswerRanking;
import cn.xiaoandx.exam.vo.AnswerRankingVo;
import cn.xiaoandx.exam.vo.AnswerUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**  
 * <p> 
 *	用户答题，统计相关API操作
 * </p> 
 * @ClassName:IndexAnswerController   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:28
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@RequestMapping("/v1/open/exam")
@RestController
@Api(tags = "用户答题操作相关API")
public class IndexAnswerController {
	
	@Autowired
	private IndexAnswerService indexAnswerService;
	
	/**
	 *<p>查询总成绩</p> 
	 * @Title: findSrcoeByOpenId    
	 * @version:V1.0     
	 * @param USERID	用户id	
	 * @return:TotalCollcetSubject	汇总数据对象（包含总成绩）
	 */
	@GetMapping(value = "/findResult/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "GET",value = "查询XX用户的总成绩",notes = "根据XX用户userId查询<br><br><b>@author xiaox.周巍</b>")
	@ApiResponses({
		@ApiResponse(code = 400,message = "未传入指定参数"),
		@ApiResponse(code = 404,message = "未找到指定页面")
	})
	public TotalCollcetSubject findSrcoeByOpenId(@ApiParam(value = "用户Id*必填",required = true) @PathVariable int userId) {
		return indexAnswerService.findSrcoeByOpenId(userId);
	}
	
	/**
	 *<p>查询排名（前50）APi</p> 
	 * @Title: findAllRanking    
	 * @version:V1.0     
	 * @return:List<AnswerRanking>	排名集合
	 */
	@GetMapping(value = "/findRanking",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "GET",value = "查询排名",notes = "<br><br><b>@author xiaox.周巍</b>")
	@ApiResponses({
		@ApiResponse(code = 400,message = "未传入指定参数"),
		@ApiResponse(code = 404,message = "未找到指定页面")
	})
	public List<AnswerRanking> findAllRanking() {
		return indexAnswerService.findRanking();
	}
	
	/**
	 *<p>查询排名（前50）APi</p> 
	 * @Title: findRankingList    
	 * @version:V1.0     
	 * @return:List<AnswerRankingVo.java>	排名集合
	 */
	@GetMapping(value = "/findRankingList",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "GET",value = "查询排名",notes = "<br><br><b>@author xiaox.周巍</b>")
	@ApiResponses({
		@ApiResponse(code = 400,message = "未传入指定参数"),
		@ApiResponse(code = 404,message = "未找到指定页面")
	})
	public List<AnswerRankingVo> findRankingList() {
		return indexAnswerService.findRankingList();
	}
	
	/**
	 *<p>随机抽出一道题（包括选项）</p> 
	 * @Title: findById    
	 * @version:V1.0     
	 * @param id		随机id
	 * @return:Question	返回试题试题对象
	 */
	@GetMapping(value = "/findOneQuestion",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "GET", value = "随机抽出一道题(包括选项)", notes = "随机抽出一道题(包括选项)<br><br><b>@author xiaox.周巍</b>")
	@ApiResponses({
		@ApiResponse(code = 400,message = "未传入指定参数"),
		@ApiResponse(code = 404,message = "未找到指定页面")
	})
	public Question findById() {
		return indexAnswerService.findById(IdAndTimeUtil.getQuestion());
	}
	
	/**
	 *<p>提交答案（判断正确更新答题记录数据）</p> 
	 * @Title: answer    
	 * @version:V1.0     
	 * @param answerUser			传入的答题数据
	 * @return:TotalCollcetSubject	一个当前XX的答题情况
	 */
	@PostMapping(value = "/submitAnswers",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "POST",value = "XX用户提交答案（判断正确更新答题记录数据）",notes = "需要传入questionId，userId，correctAnswer<br><br><b>@author xiaox.周巍</b>")
	@ApiResponses({
		@ApiResponse(code = 400,message = "未传入指定参数"),
		@ApiResponse(code = 404,message = "未找到指定页面")
	})
	public TotalCollcetSubject answer(@ApiParam(value = "提交答案的对象（用户id+试题id+选择的答案ABCD..）*必填",required = true) @RequestBody AnswerUser answerUser) {
			return indexAnswerService.answer(answerUser);
	}
	
	/**
	 *<p>获取xx用户的数据</p> 
	 * @Title: findAllById    
	 * @version:V1.0     
	 * @param userId	用户id
	 * @return:AboutMe	XX用户的数据对象
	 */
	@GetMapping(value = "/findMeById/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "GET",value = "获取关于XX用户的详细数据",notes = "也可以作为排行榜详细用户的数据的api<br><br><b>@author xiaox.周巍</b>")
	@ApiResponses({
		@ApiResponse(code = 400,message = "未传入指定参数"),
		@ApiResponse(code = 404,message = "未找到指定页面")
	})
	public AboutMe findAllById(@ApiParam(value = "用户id*必填",required = true) @PathVariable("userId") Integer userId) {
		return indexAnswerService.findAllById(userId);
	}
}
