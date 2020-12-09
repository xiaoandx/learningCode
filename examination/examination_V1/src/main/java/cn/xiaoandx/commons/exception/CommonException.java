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

import lombok.Getter;

/**  
 * <p> 
 *	通用非检查异常，主要用来传递错误码和错误原因
 * </p> 
 * @ClassName:CommonException   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:32
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
public class CommonException extends RuntimeException {
	private static final long serialVersionUID = -1760130004947794055L;
	@Getter
    protected Integer code;
	@Getter
    protected Object errors;
	
	public CommonException(Integer code, String message) {
		super(message);
		this.code = code;
	}
}
