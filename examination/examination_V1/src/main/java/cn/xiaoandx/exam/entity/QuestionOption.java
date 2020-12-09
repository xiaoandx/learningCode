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
 *	试题选项
 * </p> 
 * @ClassName:QuestionOption   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:25
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@ApiModel("选项实体")
@Data
public class QuestionOption {
	@ApiModelProperty(dataType = "Integer",name = "id",value = "选项id")
	private Integer id;
	@ApiModelProperty(dataType = "String",name = "optionContent",value = "选项内容")
	private String optionContent;
	@ApiModelProperty(dataType = "String",name = "option",value = "选项")
	private String option;
	@ApiModelProperty(dataType = "String",name = "questionId",value = "题目id")
	private String questionId;
	@ApiModelProperty(dataType = "Date",name = "createdDate",value = "创建时间")
	private Date createdDate;
}
