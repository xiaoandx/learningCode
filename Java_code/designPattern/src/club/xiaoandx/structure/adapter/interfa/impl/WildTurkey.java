/*
 * Copyright (c) 2021 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and 
 * commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems
 * and consequences.
 * In case of code problems, feedback can be made through the following email address.
 * 
 *                        <xiaoandx@gmail.com>
 */
package club.xiaoandx.structure.adapter.interfa.impl;

import club.xiaoandx.structure.adapter.interfa.Turkey;

/**  
 * <p> 火鸡 </p> 
 * @ClassName:WildTurkey   
 * @author: WEI.ZHOU
 * @date: 2021-04-14 17:17
 * @since: JDK1.8
 * @version V1.0.0
 */
public class WildTurkey implements Turkey{

	/**   
	 * <p> 火鸡叫 </p></br>
	 * <p>Title: gobble</p> 
	 * @date: 2021-04-14 17:18       
	 * @see club.xiaoandx.structure.adapter.interfa.Turkey#gobble()   
	 */
	@Override
	public void gobble() {
		System.out.println("gobble！.................");
	}

}
