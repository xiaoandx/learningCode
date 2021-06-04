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
package club.xiaoandx.experiment7.assignment1.observer;

/**  
 * <p> Observer 注册者接口 </p> 
 * @ClassName:Observer   
 * @author: WEI.ZHOU
 * @date: 2021-06-03 12:32
 * @since: JDK1.8
 * @version V1.0.0
 */
public interface Observer {
	
	/**
	 * <p> 更新来自Subject最新地通知 </p></br>
	 * @Title: update  
	 * @date: 2021-06-03 12:35
	 * @param ArrayList<Observer> 		Subject对象 集合
	 * @since: 1.0.0   
	 */
	void update(String message);
}
