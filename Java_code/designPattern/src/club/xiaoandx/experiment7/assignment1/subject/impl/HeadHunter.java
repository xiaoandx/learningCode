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
 * <p> 求职中介公司具体实现 </p> 
 * @ClassName:HeadHunter   
 * @author: WEI.ZHOU
 * @date: 2021-06-03 10:45
 * @since: JDK1.8
 * @version V1.0.0
 */
public class HeadHunter implements Subject{
	
	/**
	 * 中介保存注册学生集合
	 */
	private ArrayList<Observer> userList;
	
	/**
	 * 中介公司所有的招聘岗位集合
	 */
	private ArrayList<String> jobs;
 
	/**
	 * <p> 进行集合的初始化  </p></br>
	 * @Title:  HeadHunter   
	 * @date: 2021-06-03 10:51 
	 * @since: 1.0.0
	 */
	public HeadHunter(){
		userList = new ArrayList<Observer>();
		jobs = new ArrayList<String>();
	}

	/**   
	 * <p> 学生向中介进程身份注册 </p></br>
	 * <p>Title: registerObserver</p> 
	 * @date: 2021-06-03 10:46    
	 * @param o   		求职的学生
	 * @see club.xiaoandx.experiment7.assignment1.subject.Subject#registerObserver(club.xiaoandx.experiment7.assignment1.observer.Observer)   
	 */
	@Override
	public void registerObserver(Observer o) {
		userList.add(o);		
	}

	/**   
	 * <p>移除学生</p></br>
	 * <p>Title: removeObserver</p> 
	 * @date: 2021-06-03 10:46    
	 * @param o  		求职的学生 
	 * @see club.xiaoandx.experiment7.assignment1.subject.Subject#removeObserver(club.xiaoandx.experiment7.assignment1.observer.Observer)   
	 */
	@Override
	public void removeObserver(Observer o) {
		int i = userList.indexOf(o);
        if (i >= 0) {
        	userList.remove(i);
        }
	}
	
	/**
	 * <p> 添加新的工作	 </p></br>
	 * @Title: addJob  
	 * @date: 2021-06-03 10:51
	 * @param job 		工作岗位    
	 * @since: 1.0.0   
	 */
	public void addJob(String job) {
		this.jobs.add(job);
		notifyAllObservers();
	}
 
	/**
	 * <p> 获取所示的工作集合 </p></br>
	 * @Title: getJobs  
	 * @date: 2021-06-03 10:52
	 * @return ArrayList<String>  	中介的所有工作集合  
	 * @since: 1.0.0   
	 */
	public ArrayList<String> getJobs() {
		return jobs;
	}
 
	/**
	 * <p> 中介所有的工作toString </p></br>
	 * <p>Title: toString</p> 
	 * @date: 2021-06-03 10:53    
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuffer jobsString = new StringBuffer(" ");
		for(String j: jobs){
			jobsString.append(j + ", ");
		}
		return jobsString.toString();
	}

	/**
	 * <p> 通知所有的求职学生工作岗位消息  </p></br>
	 * <p>Title: notifyAllObservers</p> 
	 * @date: 2021-06-03 10:53       
	 * @see club.xiaoandx.experiment7.assignment1.subject.Subject#notifyAllObservers()
	 */
	@Override
	public void notifyAllObservers() {
		for(Observer o: userList){
			o.update(this);
		}
	}
}
