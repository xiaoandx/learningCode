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
package cn.xiaoandx.exam.vo;

import java.util.List;

import cn.xiaoandx.exam.entity.AnswerRecord;
import cn.xiaoandx.exam.entity.TotalCollcetSubject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**  
 * <p> 
 *	个人中心答题统计VO
 * </p> 
 * @ClassName:AboutMe   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:22
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@ApiModel(value = "关于我的数据实体视图")
@Data
public class AboutMe {
	@ApiModelProperty(value = "总分排名",name = "answerRanking")
	private AnswerRanking answerRanking;
	@ApiModelProperty(value = "答题汇总记录",name = "totalCollcetSubject")
	private TotalCollcetSubject totalCollcetSubject;
	@ApiModelProperty(value = "知识领域",name = "answerRecord")
	private List<AnswerRecord> answerRecord;
	@ApiModelProperty(value = "每日答题统计",name = "userDayAnswer")
	private List<UserDayAnswer> userDayAnswer;
}
