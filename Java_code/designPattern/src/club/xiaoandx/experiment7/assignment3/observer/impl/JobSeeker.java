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
package club.xiaoandx.experiment7.assignment3.observer.impl;

import club.xiaoandx.experiment7.assignment3.observer.Observer;
import club.xiaoandx.experiment7.assignment3.subject.Subject;

/**  
 * <p> 求职者 </p> 
 * @ClassName:JobSeeker   
 * @author: WEI.ZHOU
 * @date: 2021-06-03 10:56
 * @since: JDK1.8
 * @version V1.0.0
 */
public class JobSeeker implements Observer{
	
	/**
	 * 求职者姓名
	 */
	private String seekerName;
	
	/**   
	 * @Title:  JobSeeker   
	 * @date: 2021-06-03 10:57 
	 * @since: 1.0.0
	 */
	public JobSeeker(String seekerName) {
		this.seekerName = seekerName;
	}

	/**   
	 * <p> 跟新得到最新中介公司的所有岗位 </p></br>
	 * <p>Title: update</p> 
	 * @date: 2021-06-03 10:57    
	 * @param s   		中介公司
	 * @see club.xiaoandx.experiment7.assignment1.observer.Observer#update(club.xiaoandx.experiment7.assignment1.subject.Subject)   
	 */
	@Override
	public void update(Subject s) {
		System.out.print(seekerName + "接收到中介最新岗位信息：");
		System.out.println(s.toString());
	}

}
