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
package club.xiaoandx.experiment7.assignment3;

import club.xiaoandx.experiment7.assignment3.observer.impl.JobSeeker;
import club.xiaoandx.experiment7.assignment3.subject.impl.HardwareDev;
import club.xiaoandx.experiment7.assignment3.subject.impl.SoftwareDev;
import club.xiaoandx.experiment7.assignment3.subject.impl.UIDev;

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
		 * 1.先实例化一家中介不同类别的岗位主题
		 * 2.学生进行求职，实例化几个学生，并到对应主题进行注册
		 * 3.中介公司新增了不同类别的求职岗位信息，就会通知所有在公司注册地学生
		 */
		UIDev headHunter = new UIDev();
		SoftwareDev softwareDev = new SoftwareDev();
		HardwareDev hardwareDev = new HardwareDev();
		
		headHunter.registerObserver(new JobSeeker("张三"));
		softwareDev.registerObserver(new JobSeeker("李四"));
		hardwareDev.registerObserver(new JobSeeker("周巍"));
		
		headHunter.addJob("软件开发人员");
		softwareDev.addJob("硬件开发人员");
		hardwareDev.addJob("UI设计人员");
	}
}
