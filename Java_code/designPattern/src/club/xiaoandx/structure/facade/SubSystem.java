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
package club.xiaoandx.structure.facade;

/**  
 * <p> 看电影 动作类 操作步骤如下 </p> 
 * 1. turnOnTV 打开电视</br>
 * 2. setCD 放置CD </br>
 * 3. starWatching 观看
 * @ClassName:SubSystem   
 * @author: WEI.ZHOU
 * @date: 2021-04-14 16:58
 * @since: JDK1.8
 * @version V1.0.0
 */
public class SubSystem {
	
	/**
	 * <p> 打开电视 </p></br>
	 * @Title: turnOnTV  
	 * @date: 2021-04-14 17:00 void    
	 * @since: 1.0.0   
	 */
	public void turnOnTV() {
		System.out.println("turnOnTV()");
	}
	
	/**
	 * <p> 放置CD </p></br>
	 * @Title: setCD  
	 * @date: 2021-04-14 17:00
	 * @param cd void    
	 * @since: 1.0.0   
	 */
	public void setCD(String cd) {
		System.out.println("setCD( " + cd + " )");
	}
	
	/**
	 * <p> 观看电影 </p></br>
	 * @Title: starWatching  
	 * @date: 2021-04-14 17:01 void    
	 * @since: 1.0.0   
	 */
	public void starWatching() {
		System.out.println("starWatching()");
	}
}
