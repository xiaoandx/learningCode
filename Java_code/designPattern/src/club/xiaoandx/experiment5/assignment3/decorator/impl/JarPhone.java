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
package club.xiaoandx.experiment5.assignment3.decorator.impl;

import club.xiaoandx.experiment5.assignment3.decorator.PhoneDecorator;
import club.xiaoandx.experiment5.assignment3.product.Cellphone;

/**  
 * <p> 手机来电装饰 - 震动 </p> 
 *
 * @ClassName:JarPhone   
 * @author: WEI.ZHOU
 * @date: 2021-05-13 10:19
 * @since: JDK1.8
 * @version V1.0.0
 */
public class JarPhone extends PhoneDecorator{

	/**   
	 * @Title:  JarPhone   
	 * @date: 2021-05-13 10:20 
	 * @since: 1.0.0
	 */
	public JarPhone(Cellphone cellphone) {
		this.cellphone = cellphone;
	}
	
	/**   
	 * <p>Title: receiveCall</p> 
	 * @date: 2021-05-13 10:20       
	 * @see club.xiaoandx.experiment5.assignment3.product.Cellphone#receiveCall()   
	 */
	@Override
	public void receiveCall() {
		cellphone.receiveCall();
		System.out.print(" 手机震动");
	}

}
