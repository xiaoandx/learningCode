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
package cn.xiaoandx.exam.entity;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**  
 * <p> 
 *	答题记录实体
 * </p> 
 * @ClassName:AnswerRecord   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:23
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@ApiModel(value = "答题记录实体类")
@Data
public class AnswerRecord {
	@ApiModelProperty(value = "答题记录id",name = "answerRecordId")
	private Integer answerRecordId;
	@ApiModelProperty(value = "题目id",name = "topicId")
	private Integer topicId;
	@ApiModelProperty(value = "提交选项",name = "submitOption")
	private String 	submitOption;
	@ApiModelProperty(value = "答题是否正确(正确为0，错误为1)",name = "trueOrFlase")
	private Integer trueOrFlase;
	@ApiModelProperty(value = "用户id",name = "userId")
	private Integer userId;
	@ApiModelProperty(value = "本题正确答案",name = "correctAnswer")
	private String 	correctAnswer;
	@ApiModelProperty(value = "答题时间",name = "answerTime")
	private Date answerTime;
	@ApiModelProperty(value = "本题知识领域",name = "knowledgeDomain")
	private String  knowledgeDomain;
	@ApiModelProperty(value = "本题得分",name = "score")
	private Integer score;
	@ApiModelProperty(value = "知识领域数量",name = "number")
	private Integer number;
}
