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
package club.xiaoandx.experiment7.assignment1.subject.impl;

import java.util.ArrayList;

import club.xiaoandx.experiment7.assignment1.observer.Observer;
import club.xiaoandx.experiment7.assignment1.subject.Subject;

/**  
 * <p> 具体实现地Subject </p> 
 * @ClassName:ConcreteSubject   
 * @author: WEI.ZHOU
 * @date: 2021-06-03 12:36
 * @since: JDK1.8
 * @version V1.0.0
 */
public class ConcreteSubject implements Subject{
	
	/**
	 * 注册者集合
	 */
	private ArrayList<Observer> observers ;
	
	/**
	 * 更新地消息
	 */
	private String message;
	
	/**
	 * <p> 更新消息 </p></br>
	 * @Title: updateMessage  
	 * @date: 2021-06-03 14:34
	 * @param message 		更新消息内容  
	 * @since: 1.0.0   
	 */
	public void updateMessage(String message) {
		this.message = message;
		notifyObserver();
	}
	
	/**   
	 * <p> </p></br>
	 * @Title:  ConcreteSubject   
	 * @date: 2021-06-03 12:38 
	 * @since: 1.0.0
	 */
	public ConcreteSubject() {
		observers = new ArrayList<Observer>();
	}

	/**   
	 * <p>Title: registerObserver</p> 
	 * @date: 2021-06-03 12:37    
	 * @param o   
	 * @see club.xiaoandx.experiment7.assignment1.subject.Subject#registerObserver(club.xiaoandx.experiment7.assignment1.observer.Observer)   
	 */
	@Override
	public void registerObserver(Observer o) {
		int i = observers.indexOf(o);
		if (null != o && i < 0) {
			observers.add(o);
		}
	}

	/**   
	 * <p>Title: removeObserver</p> 
	 * @date: 2021-06-03 12:37    
	 * @param o   
	 * @see club.xiaoandx.experiment7.assignment1.subject.Subject#removeObserver(club.xiaoandx.experiment7.assignment1.observer.Observer)   
	 */
	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
        if (i >= 0) {
        	observers.remove(i);
        }
	}

	/**   
	 * <p>Title: notifyObserver</p> 
	 * @date: 2021-06-03 12:37       
	 * @see club.xiaoandx.experiment7.assignment1.subject.Subject#notifyObserver()   
	 */
	@Override
	public void notifyObserver() {
		if (null != observers && observers.size() > 0) {
			for(Observer o : observers) {
				o.update(message);
			}
		}
	}

}
