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
 *	擅长的知识领域VO
 * </p> 
 * @ClassName:KnowledgeNumberVO   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:20
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@ApiModel(value = "擅长的知识领域视图")
@Data
public class KnowledgeNumberVO {
	@ApiModelProperty(dataType = "Long",name = "userId",value="用户id")
	private Long userId;
	@ApiModelProperty(dataType = "String",name = "knowledgeDomain",value="知识领域名称")
	private String knowledgeDomain;
	@ApiModelProperty(dataType = "String",name = "percentage",value="正确率")
	private String percentage;
	
}
