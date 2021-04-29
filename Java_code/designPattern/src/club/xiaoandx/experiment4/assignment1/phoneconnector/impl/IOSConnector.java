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
package club.xiaoandx.experiment4.assignment1.phoneconnector.impl;

import club.xiaoandx.experiment4.assignment1.phoneconnector.PhoneConnector;

/**  
 * <p> IOS充电接口连接线 </p> 
 * @ClassName:IOSConnecttor   
 * @author: WEI.ZHOU
 * @date: 2021-04-29 10:11
 * @since: JDK1.8
 * @version V1.0.0
 */
public class IOSConnector implements PhoneConnector{
	
	/**   
	 * <p> 充电 </p></br>
	 * <p>Title: phoneConnect</p> 
	 * @date: 2021-04-29 10:23       
	 * @see club.xiaoandx.experiment4.assignment1.phoneconnector.PhoneConnector#phoneConnect()   
	 */
	@Override
	public String phoneConnect() {
		return "使用IOSConnector进行充电";
	}
}
