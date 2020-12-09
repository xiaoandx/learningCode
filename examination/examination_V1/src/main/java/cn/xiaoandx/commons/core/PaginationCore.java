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
 *	分页数据定义
 * </p> 
 * @ClassName:PaginationCore   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:36
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
public class PaginationCore {

	//默认当前页数：第1页 
    public static final int DEFAULT_OFFSET = 1;

    public static final int MIN_OFFSET = 1;
    //默认每页记录数: 10条
    public static final int DEFAULT_LIMIT = 10;

    public static final int MAX_LIMIT = 100;
    
}
