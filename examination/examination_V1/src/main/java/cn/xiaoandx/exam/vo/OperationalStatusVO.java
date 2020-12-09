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
 *	api请求状态VO
 * </p> 
 * @ClassName:OperationalStatusVO   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:19
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@ApiModel(description="操作状态")
@Data
public class OperationalStatusVO {
	@ApiModelProperty(dataType = "Integer",name = "statusCode",value="操作状态码")
	private Integer statusCode;
	@ApiModelProperty(dataType = "String",name = "statusMassgerstatusMassger",value="操作结果")
	private String statusMassger;
	
	/**   
	 * @Title:OperationalStatusVO   
	 * @date:2019年6月13日上午9:33:45
	 * @param statusCode
	 * @param statusMassger
	 */
	public OperationalStatusVO(Integer statusCode, String statusMassger) {
		this.statusCode = statusCode;
		this.statusMassger = statusMassger;
	}
}
