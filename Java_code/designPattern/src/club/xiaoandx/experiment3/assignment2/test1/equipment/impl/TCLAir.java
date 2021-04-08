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

import club.xiaoandx.experiment3.assignment2.test1.equipment.AirConditioner;

/**  
 * <p> TCL 空调 </p> 
 *	1. TCLAir 具体实现空调接口
 * @ClassName:TCLAir   
 * @author: WEI.ZHOU
 * @date: 2021-04-08 15:22
 * @since: JDK1.8
 * @version V1.0.0
 */
public class TCLAir implements AirConditioner {

	/**   
	 * <p> TCL Air 产品测试 </p></br>
	 * <p>Title: paly</p> 
	 * @date: 2021-04-08 15:22       
	 * @see club.xiaoandx.experiment3.assignment2.test1.equipment.AirConditioner#play()   
	 */
	@Override
	public void play() {
		System.out.println("TCL Air 运行中------------");
	}

}
