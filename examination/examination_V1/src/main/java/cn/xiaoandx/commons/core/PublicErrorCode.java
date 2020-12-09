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
package cn.xiaoandx.commons.core;

/**  
 * <p> 
 *	公共的错误码
 * </p> 
 * @ClassName:PublicErrorCode   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:37
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
public enum PublicErrorCode {

	QUERY_EXCEPTION(48001000),//查询异常
	SAVE_EXCEPTION(48002000),//保存异常
	DELETE_EXCEPTION(48003000),//删除异常
	PARAM_EXCEPTION(48004000),//参数异常
	AUTH_EXCEPTION(48005000);//权限异常

	private Integer intValue;
	private String strValue;

	PublicErrorCode(Integer stateCode) {
		this.intValue = stateCode;
		switch(stateCode) {
		case 48001000:
			this.strValue = "查询异常";
			break;
		case 48002000:
			this.strValue = "保存异常";
			break;
		case 48003000:
			this.strValue = "删除异常";
			break;
		case 48004000:
			this.strValue = "参数异常";
			break;
		case 48005000:
			this.strValue = "权限异常";
			break;
		default:
			this.strValue = "未知异常";
		}
	}
	public Integer getIntValue() {
		return intValue;
	}
	public String getStrValue() {
		return strValue;
	}
}
