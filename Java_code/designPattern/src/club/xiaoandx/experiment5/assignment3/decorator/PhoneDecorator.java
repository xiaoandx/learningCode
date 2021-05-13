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
package club.xiaoandx.experiment5.assignment3.decorator;

import club.xiaoandx.experiment5.assignment3.product.Cellphone;

/**  
 * <p> 手机来电装饰器抽象方法 </p> 
 * @ClassName:PhoneDecorator   
 * @author: WEI.ZHOU
 * @date: 2021-05-13 10:17
 * @since: JDK1.8
 * @version V1.0.0
 */
public abstract class PhoneDecorator extends Cellphone{
	
	public Cellphone cellphone;
}
