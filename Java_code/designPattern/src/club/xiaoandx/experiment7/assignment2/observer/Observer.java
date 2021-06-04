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
package club.xiaoandx.experiment7.assignment2.observer;

import club.xiaoandx.experiment7.assignment2.subject.Subject;

/**  
 * <p> 找工作的学生 </p> 
 * @ClassName:Observer   
 * @author: WEI.ZHOU
 * @date: 2021-06-03 10:44
 * @since: JDK1.8
 * @version V1.0.0
 */
public interface Observer {
	public void update(Subject s);
}
