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
package cn.xiaoandx.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**  
 * <p> 
 *	注册人脸返回唯一编号VO视图
 * </p> 
 * @ClassName:OneValueVO   
 * @author: WEI.ZHOU
 * @date: 2020-12-07 20:11
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@ApiModel(description="单值视图对象")
@Data
@NoArgsConstructor
public class OneValueVO {
    @ApiModelProperty(value = "userId", name = "用户id")
    private int userId;
    @ApiModelProperty(value = "token", name = "用户注册人脸编号")
    private String token;

	/**   
	 * @Title:OneValueVO   
	 * @date:2019年5月18日下午4:50:35
	 * @param openid
	 * @param token
	 */
	public OneValueVO(int userId, String token) {
		this.userId = userId;
		this.token = token;
	}
    
   
}
