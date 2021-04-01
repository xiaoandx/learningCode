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
package club.xiaoandx.experiment3.assignment1.test2.greenstuff.impl;

import club.xiaoandx.experiment3.assignment1.test2.greenstuff.Greenstuff;

/**  
 * <p> 根菜蔬菜 </p> 
 *	1. 实现蔬菜的具体种植方法
 * @ClassName:RootGreenstuff   
 * @author: WEI.ZHOU
 * @date: 2021-04-01 17:10
 * @since: JDK1.8
 * @version V1.0.0
 */
public class RootGreenstuff implements Greenstuff {

	/**   
	 * <p> 播种 </p></br>
	 * <p>Title: sowing</p> 
	 * @date: 2021-04-01 17:10       
	 * @see club.xiaoandx.experiment3.assignment1.test2.greenstuff.Greenstuff#sowing()   
	 */
	@Override
	public void sowing() {
		System.out.println("正在种植根菜蔬菜");
	}

	/**   
	 * <p> 成长 </p></br>
	 * <p>Title: growUp</p> 
	 * @date: 2021-04-01 17:10       
	 * @see club.xiaoandx.experiment3.assignment1.test2.greenstuff.Greenstuff#growUp()   
	 */
	@Override
	public void growUp() {
		System.out.println("种植的根菜蔬菜正在成长中");
	}

	/**   
	 * <p> 果实 </p></br>
	 * <p>Title: fruit</p> 
	 * @date: 2021-04-01 17:10       
	 * @see club.xiaoandx.experiment3.assignment1.test2.greenstuff.Greenstuff#fruit()   
	 */
	@Override
	public void fruit() {
		System.out.println("成长的根菜蔬菜已经长大得到根菜果实");
	}

}
