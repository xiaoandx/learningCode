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
import lombok.EqualsAndHashCode;

/**  
 * <p> 
 *	答题记录分页查询VO
 * </p> 
 * @ClassName:QueryQuestionStatisticVO   
 * @author: WEI.ZHOU
 * @date: 2020-12-07 20:18
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@ApiModel(description="答题记录查询")
@Data
@EqualsAndHashCode(callSuper=false)
public class QueryQuestionStatisticVO {
	
	@ApiModelProperty(value = "第几页", required = false,name = "pageNumber")
	private Integer pageNumber;
	
	@ApiModelProperty(value = "每页数据的数目", required = false,name = "pageSize")
	private Integer pageSize;
	
	@ApiModelProperty(value = "xx类型的答题记录（默认全部查询 0  ，正确记录传1，错误记录传2）", required = false,name = "IsCorrect")
	private Integer IsCorrect;
	
	
}
