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
package club.xiaoandx.experiment3.assignment2.test1.equipment.impl;

import club.xiaoandx.experiment3.assignment2.test1.equipment.Television;

/**  
 * <p> Haier TV 海尔电视  </p> 
 *	1. 继承TV接口，得到具体的海尔电视
 * @ClassName:HaierTV   
 * @author: WEI.ZHOU
 * @date: 2021-04-08 15:20
 * @since: JDK1.8
 * @version V1.0.0
 */
public class HaierTV implements Television {

	/**   
	 * <p> 海尔电视 测试方法 </p></br>
	 * <p>Title: play</p> 
	 * @date: 2021-04-08 15:20       
	 * @see club.xiaoandx.experiment3.assignment2.test1.equipment.Television#play()   
	 */
	@Override
	public void play() {
		System.out.println("Haier TV 播放中---------");
	}

}
