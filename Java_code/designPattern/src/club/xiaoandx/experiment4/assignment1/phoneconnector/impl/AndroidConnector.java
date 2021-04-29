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
 * <p> 安卓手机充电接口连接线 </p> 
 * @ClassName:AndroidConnector   
 * @author: WEI.ZHOU
 * @date: 2021-04-29 10:06
 * @since: JDK1.8
 * @version V1.0.0
 */
public class AndroidConnector implements PhoneConnector{

	/**   
	 * <p> 手机充电 </p></br>
	 * <p>Title: phoneConnect</p> 
	 * @date: 2021-04-29 10:22       
	 * @see club.xiaoandx.experiment4.assignment1.phoneconnector.PhoneConnector#phoneConnect()   
	 */
	@Override
	public String phoneConnect() {
		return "使用AndroidConnector进行充电";
	}

}
