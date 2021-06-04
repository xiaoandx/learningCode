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
package club.xiaoandx.experiment7.assignment1.observer.impl;

import club.xiaoandx.experiment7.assignment1.observer.Observer;

/**  
 * <p> 注册者实现 </p> 
 * @ClassName:ConcreteObserver   
 * @author: WEI.ZHOU
 * @date: 2021-06-03 12:44
 * @since: JDK1.8
 * @version V1.0.0
 */
public class ConcreteObserver implements Observer{
	
	/**
	 * 注册者 name标识
	 */
	private String name;
	
	/**   
	 * @Title:  ConcreteObserver   
	 * @date: 2021-06-03 12:44 
	 * @since: 1.0.0
	 */
	public ConcreteObserver(String name) {
		this.name = name;
	}

	/**   
	 * <p>Title: update</p> 
	 * @date: 2021-06-03 12:45    
	 * @param s   
	 * @see club.xiaoandx.experiment7.assignment1.observer.Observer#update(club.xiaoandx.experiment7.assignment1.subject.Subject)   
	 */
	@Override
	public void update(String message) {
		System.out.println("registerObserver:" + name);
		if(!message.isEmpty()) {
			System.out.println("newMessage is:" + message);
		}
	}
	
}
