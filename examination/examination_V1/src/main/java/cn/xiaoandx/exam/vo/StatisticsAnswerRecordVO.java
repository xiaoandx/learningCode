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

import cn.xiaoandx.exam.entity.QuestionOption;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**  
 * <p> 
 *	用户答题记录VO
 * </p> 
 * @ClassName:StatisticsAnswerRecordVO   
 * @author: WEI.ZHOU
 * @date: 2020-12-07 20:16
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@ApiModel(value = "答题记录视图")
@Data
public class StatisticsAnswerRecordVO {
	
	@ApiModelProperty(dataType = "Integer",name = "user_id",value="用户id")
	private Integer user_id;
	@ApiModelProperty(dataType = "String",name = "topic_id",value="试题id")
	private String topic_id;
	@ApiModelProperty(dataType = "String",name = "submit_option",value="你选择的答案")
	private String submit_option;
	@ApiModelProperty(dataType = "String",name = "correct_answer",value="该题的正确答案")
	private String correct_answer;
	@ApiModelProperty(dataType = "String",name = "answer_time",value="答题时间")
	private String answer_time;
	@ApiModelProperty(dataType = "String",name = "content",value="题干内容")
	private String content;
	@ApiModelProperty(dataType = "String",name = "knowledge_area",value="该题的知识领域")
	private String knowledge_area;
	@ApiModelProperty(name = "questionOptions",value = "试题选项")
	private List<QuestionOption> questionOptions;
}
