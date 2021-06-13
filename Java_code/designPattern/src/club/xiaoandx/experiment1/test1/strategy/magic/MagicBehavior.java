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
package club.xiaoandx.experiment1.test1.strategy.magic;

/**  
 * <p> 
 *	魔法攻击技能接口
 * </p> 
 * @ClassName:MagicBehavior   
 * @author: WEI.ZHOU
 * @date: 2021-03-18 17:14
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
public interface MagicBehavior {
	/**
	 * @Title: play  
	 * @Description: 发出技能
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	String play();
}
