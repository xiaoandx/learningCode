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
package club.xiaoandx.experiment7.assignment1.subject;

import club.xiaoandx.experiment7.assignment1.observer.Observer;

/**  
 * <p> Subject </p></br>
 * tip:提供最基础地3个抽象方法注册，通知，移除
 * @ClassName:Subject   
 * @author: WEI.ZHOU
 * @date: 2021-06-03 12:29
 * @since: JDK1.8
 * @version V1.0.0
 */
public interface Subject {
	
	/**
	 * <p> Observer进行注册 </p></br>
	 * @Title: registerObserver  
	 * @date: 2021-06-03 12:32
	 * @param o 		Observer 对象   
	 * @since: 1.0.0   
	 */
	void registerObserver(Observer o);

	/**
	 * <p> 移除 Observer对象 </p></br>
	 * @Title: removeObserver  
	 * @date: 2021-06-03 12:33
	 * @param o 		Observer对象   
	 * @since: 1.0.0   
	 */
	void removeObserver(Observer o);
	
	/**
	 * <p> 通知所有注册地Observer </p></br>
	 * @Title: notifyObserver  
	 * @date: 2021-06-03 12:34 void    
	 * @since: 1.0.0   
	 */
	void notifyObserver();
}
