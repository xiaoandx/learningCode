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
package club.xiaoandx.experiment4.assignment1.phone;

import club.xiaoandx.experiment4.assignment1.phoneconnector.PhoneConnector;

/**  
 * <p> IOS手机 </p> 
 * @ClassName:IOSPhone   
 * @author: WEI.ZHOU
 * @date: 2021-04-29 10:09
 * @since: JDK1.8
 * @version V1.0.0
 */
public interface IOSPhone {
	
	/**
	 * <p> 充电 </p></br>
	 * @Title: charge  
	 * @date: 2021-04-29 10:05
	 * @param PhoneConnector phoneConnect
	 * @return void    
	 * @since: 1.0.0   
	 */
	void charge(PhoneConnector phoneConnect);
}
