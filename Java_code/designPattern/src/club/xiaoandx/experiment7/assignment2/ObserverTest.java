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
package club.xiaoandx.experiment7.assignment2;

import club.xiaoandx.experiment7.assignment2.observer.impl.JobSeeker;
import club.xiaoandx.experiment7.assignment2.subject.impl.HeadHunter;

/**  
 * <p> 求职学生去中介公司进行求职质询-测试类 </p> 
 * @ClassName:ObserverTest   
 * @author: WEI.ZHOU
 * @date: 2021-06-03 11:08
 * @since: JDK1.8
 * @version V1.0.0
 */
public class ObserverTest {
	public static void main(String[] args) {
		/*
		 * 测试说明：
		 * 1.先实例化一家中介公司
		 * 2.学生进行求职，实例化几个学生，并到中介公司进行注册
		 * 3.中介公司新增了求职岗位信息，就会通知所有再公司注册地学生
		 */
		HeadHunter headHunter = new HeadHunter();
		headHunter.registerObserver(new JobSeeker("张三"));
		headHunter.registerObserver(new JobSeeker("李四"));
		headHunter.registerObserver(new JobSeeker("周巍"));
		
		headHunter.addJob("Java开发工程师");
		headHunter.addJob("Web前端开发工程师");
		headHunter.addJob("Java架构师");
	}
}
