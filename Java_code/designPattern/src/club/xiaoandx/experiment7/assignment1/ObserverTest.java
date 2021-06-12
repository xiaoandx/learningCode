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
package club.xiaoandx.experiment7.assignment1;

import club.xiaoandx.experiment7.assignment1.observer.impl.ConcreteObserver;
import club.xiaoandx.experiment7.assignment1.subject.impl.ConcreteSubject;

/**  
 * <p> 观察者模式测试 </p> 
 * @ClassName:ObserverTest   
 * @author: WEI.ZHOU
 * @date: 2021-06-03 12:56
 * @since: JDK1.8
 * @version V1.0.0
 */
public class ObserverTest {
	public static void main(String[] args) {
		ConcreteSubject concreteSubject = new ConcreteSubject();
		concreteSubject.registerObserver(new ConcreteObserver("周巍"));
		concreteSubject.updateMessage("上课了");
		concreteSubject.updateMessage("下课了");
	}
}
