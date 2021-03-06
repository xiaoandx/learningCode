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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**  
 * <p> 
 *	用户擅长知识领域统计VO
 * </p> 
 * @ClassName:QuestionKnoVO   
 * @author: WEI.ZHOU
 * @date: 2020-12-07 20:17
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@ApiModel("试题实体")
@Data
public class QuestionKnoVO {
	@ApiModelProperty(dataType = "String",name = "knowledfeArea",value = "知识领域")
	private String knowledgeArea;
	@ApiModelProperty(dataType = "Integer",name = "number",value = "数量")
	private Integer number;
	
}
