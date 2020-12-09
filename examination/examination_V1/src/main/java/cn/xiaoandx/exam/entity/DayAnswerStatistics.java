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
 *	每日答题记录数据库实体
 * </p> 
 * @ClassName:DayAnswerStatistics   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:24
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@ApiModel(value = "每日记录实体表")
@Data
public class DayAnswerStatistics {
	@ApiModelProperty(value = "每日答题记录id",name = "id")
	private Integer id;
	@ApiModelProperty(value = "用户id",name = "userId")
	private Integer userId;
	@ApiModelProperty(value = "答对题目总数",name = "answerCorrectSubjectNumber")
	private Integer answerCorrectSubjectNumber;
	@ApiModelProperty(value = "答错题目总数",name = "answersErrorSubjectNumber")
	private Integer answersErrorSubjectNumber;
	@ApiModelProperty(value = "答题总数",name = "answerSubjectTotal")
	private Integer answerSubjectTotal;
	@ApiModelProperty(value = "当前累计总分",name = "currentScore")
	private Integer currentScore;
	@ApiModelProperty(value = "当天累计总分",name = "sameDayScore")
	private Integer sameDayScore;
	@ApiModelProperty(value = "答题日期",name = "answerTime")
	private Date answerTime;
}
