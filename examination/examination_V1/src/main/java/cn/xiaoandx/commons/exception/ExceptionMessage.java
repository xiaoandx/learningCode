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
package cn.xiaoandx.commons.exception;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**  
 * <p> 
 *	自定义错误输出实体
 * </p> 
 * @ClassName:ExceptionMessage   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:33
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@ApiModel(description="微信用户信息")
@NoArgsConstructor
@ToString
public class ExceptionMessage {
	@ApiModelProperty(value = "错误编码")
	@Getter
    @Setter
    private Integer code;
	@ApiModelProperty(value = "错误详细信息")
	@Getter
    @Setter
    private String message;

public ExceptionMessage(Integer code, String message) {
	this.code = code;
	this.message = message;
}
}
