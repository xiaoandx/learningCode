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
 *	数据库操作部分定义常量
 * </p> 
 * @ClassName:DaoCode   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:35
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
public interface DaoCode {
	
	/*
	 * 数据库操作成功
	 */
	Integer ADD_OK = 1;
	/*
	 * 数据库操作失败
	 */
	Integer ADD_ERROR = 0;
	/*
	 * 判断用户总成绩
	 */
	Integer SROCE_NUMBER = 0;
	/*
	 * 用户id为0
	 */
	Integer ZEROUSERID = 0;
	/*
	 * 选项数至少为2
	 */
	Integer QUESTIONOPTIONCOUNT = 2;
	/*
	 * 入参为0
	 */
	Integer AFFERENT_PARAMETERS_NUMBER = 0;
	/*
	 * 入参为0
	 */
	String AFFERENT_PARAMETERS_STRING = "";
	/*
	 * 成功200200
	 */
	Integer SUCCESS = 200200;
	/*
	 * 失败 400400
	 */
	Integer ERROR = 400400;
}
