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
 * <p> 手机来电装饰器 - 闪光灯 </p> 
 * @ClassName:ComplexPhone   
 * @author: WEI.ZHOU
 * @date: 2021-05-13 10:22
 * @since: JDK1.8
 * @version V1.0.0
 */
public class ComplexPhone extends PhoneDecorator{

	/**   
	 * @Title:  ComplexPhone   
	 * @date: 2021-05-13 10:23 
	 * @since: 1.0.0
	 */
	public ComplexPhone(Cellphone cellphone) {
		this.cellphone = cellphone;
	}
	
	/**   
	 * <p>Title: receiveCall</p> 
	 * @date: 2021-05-13 10:23       
	 * @see club.xiaoandx.experiment5.assignment3.product.Cellphone#receiveCall()   
	 */
	@Override
	public void receiveCall() {
		cellphone.receiveCall();
		System.out.print(" 闪光灯闪烁");
	}

}
