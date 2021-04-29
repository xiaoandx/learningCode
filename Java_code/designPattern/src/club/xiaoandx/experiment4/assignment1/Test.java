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
package club.xiaoandx.experiment4.assignment1;

import club.xiaoandx.experiment4.assignment1.adpater.PhoneConnectorAdapter;
import club.xiaoandx.experiment4.assignment1.phone.impl.IponeSixPhone;
import club.xiaoandx.experiment4.assignment1.phone.impl.MIPhone;
import club.xiaoandx.experiment4.assignment1.phoneconnector.impl.AndroidConnector;
import club.xiaoandx.experiment4.assignment1.phoneconnector.impl.IOSConnector;

/**  
 * <p> 安卓手机，IOS手机通过充电器适配器进行充电 </p> 
 * @ClassName:Test   
 * @author: WEI.ZHOU
 * @date: 2021-04-29 10:32
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Test {
	
	public static void main(String[] args) {
		
		/**
		 * 小米手机充电测试
		 */
		MIPhone miPhone = new MIPhone();
		miPhone.charge(new PhoneConnectorAdapter(new IOSConnector()));
		
		/**
		 * 苹果6手机充电测试
		 */
		IponeSixPhone iponeSixPhone = new IponeSixPhone();
		iponeSixPhone.charge(new PhoneConnectorAdapter(new AndroidConnector()));
	}
}
