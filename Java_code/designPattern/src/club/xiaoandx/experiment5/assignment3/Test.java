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
package club.xiaoandx.experiment5.assignment3;

import club.xiaoandx.experiment5.assignment3.decorator.impl.ComplexPhone;
import club.xiaoandx.experiment5.assignment3.decorator.impl.JarPhone;
import club.xiaoandx.experiment5.assignment3.product.Cellphone;
import club.xiaoandx.experiment5.assignment3.product.impl.SimplePhone;

/**  
 * <p> 手机来电测试 </p> 
 * @ClassName:Test   
 * @author: WEI.ZHOU
 * @date: 2021-05-13 10:24
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Test {
	public static void main(String[] args) {
		/*
		 * 1.获取一部简单手机，来电为铃声提示
		 * 2.将简单手机进行装饰，来电在原有的基础上增加了震动
		 * 3.在震动的基础上来电又增加了闪光灯闪烁
		 */
		Cellphone simplePhone = new SimplePhone();
		JarPhone jarPhone = new JarPhone(simplePhone);
		ComplexPhone complexPhone = new ComplexPhone(jarPhone);
		
		complexPhone.receiveCall();
	}
}
