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
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**  
 * <p> 
 *	题库试题数据库实体
 * </p> 
 * @ClassName:Question   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:24
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@ApiModel("试题实体")
@Data
public class Question {
	@ApiModelProperty(dataType = "String",name = "id",value = "试题id")
	private String id;
	@ApiModelProperty(dataType = "String",name = "content",value = "试题题目")
	private String content;
	@ApiModelProperty(dataType = "String",name = "answer",value = "试题的正确答案")
	private String answer;
	@ApiModelProperty(dataType = "String",name = "knowledfeArea",value = "知识领域")
	private String knowledgeArea;
	@ApiModelProperty(dataType = "Date",name = "createdDate",value = "试题创建时间")
	private Date createdDate;
	@ApiModelProperty(name = "questionOptions",value = "试题选项")
	private List<QuestionOption> questionOptions;
	
}
