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
package cn.xiaoandx.commons.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**  
 * <p> 
 *	公共工具
 * </p> 
 * @ClassName:IdAndTimeUtil   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:30
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
public class IdAndTimeUtil {
	
	/**
	 *<p>生成试题编号（ID）</p> 
	 * @Title: getQuestionId    
	 * @version:V2.0     
	 * @return:String	随机id
	 */
	public static String getQuestionId() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 *<p>获取当前时间</p> 
	 * @Title: getNewDate    
	 * @version:V2.0     
	 * @return:Timestamp 当前日期
	 */
	public static Timestamp getNewDate(){
		return new Timestamp( System.currentTimeMillis());
	}
	
	/**
	 *<p>获取当前事件格式为（yyyy-mm-dd）</p> 
	 * @Title: getDate    
	 * @version:V2.0     
	 * @return:String  日期字符串
	 */
	public static String getDate () {
		Date day = new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		return df.format(day);
	}
	
	/**
	 *<p>随机生成题号（1980-15726）</p> 
	 * @Title: getQuestion    
	 * @version:V2.0     
	 * @return:String	试题id
	 */
	public static String getQuestion() {
		Integer number =  (int)(Math.random()*(13747)+1980);
		return String.valueOf(number);
	}
	
}
