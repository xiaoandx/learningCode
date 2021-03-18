/*
 * Copyright 2019-2021 the original WEI.ZHOU.
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
package club.xiaoandx.experiment1.test1.strategy.commons.core;

/**  
 * <p> 
 *	游戏人物划分常量
 * </p> 
 * @ClassName:RoleType   
 * @author: WEI.ZHOU
 * @date: 2021-03-18 17:27
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
public interface RoleType {
	
	/**
	 * 游戏人物类型-国王
	 */
	public static final String GAME_USER_TYPE_KIND = "国王";
	
	/**
	 * 游戏人物类型-皇后
	 */
	public static final String GAME_USER_TYPE_QUEEN = "皇后";
	
	/**
	 * 游戏人物类型-骑士
	 */
	public static final String GAME_USER_TYPE_KNIGHT = "骑士";
	
	/**
	 * 游戏人物类型-士兵
	 */
	public static final String GAME_USER_TYPE_PAWN = "士兵";
}
