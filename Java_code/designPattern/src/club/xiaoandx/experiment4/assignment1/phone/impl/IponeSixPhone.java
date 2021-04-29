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
package club.xiaoandx.experiment4.assignment1.phone.impl;

import club.xiaoandx.experiment4.assignment1.phone.IOSPhone;
import club.xiaoandx.experiment4.assignment1.phoneconnector.PhoneConnector;

/**  
 * <p> 苹果6手机 </p> 
 * @ClassName:IponeSixPhone   
 * @author: WEI.ZHOU
 * @date: 2021-04-29 10:33
 * @since: JDK1.8
 * @version V1.0.0
 */
public class IponeSixPhone implements IOSPhone {

	/**   
	 * <p> 充电 </p></br>
	 * <p>Title: charge</p> 
	 * @date: 2021-04-29 10:33    
	 * @param phoneConnect   
	 * @see club.xiaoandx.experiment4.assignment1.phone.IOSPhone#charge(club.xiaoandx.experiment4.assignment1.phoneconnector.PhoneConnector)   
	 */
	@Override
	public void charge(PhoneConnector phoneConnect) {
		System.out.println("苹果6手机使用：" + phoneConnect.phoneConnect());
	}

}
