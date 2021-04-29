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
package club.xiaoandx.experiment4.assignment1.adpater;

import club.xiaoandx.experiment4.assignment1.phoneconnector.PhoneConnector;

/**  
 * <p> PhoneConnector适配器 </p> 
 * @classNme:PhoneConnector   
 * @author: WEI.ZHOU
 * @date: 2021-04-29 10:15
 * @since: JDK1.8
 * @version V1.0.0
 */
public class PhoneConnectorAdapter implements PhoneConnector{
	
	/**
	 * 手机充电接口连接线
	 */
	private PhoneConnector connector;

	public PhoneConnectorAdapter(PhoneConnector connector) {
		this.connector = connector;
	}

	/**   
	 * <p> 使用连接线进行充电 </p></br>
	 * <p>Title: phoneConnect</p> 
	 * @date: 2021-04-29 10:23       
	 * @see club.xiaoandx.experiment4.assignment1.phoneconnector.PhoneConnector#phoneConnect()   
	 */
	@Override
	public String phoneConnect() {
		return connector.phoneConnect();
	}
}
