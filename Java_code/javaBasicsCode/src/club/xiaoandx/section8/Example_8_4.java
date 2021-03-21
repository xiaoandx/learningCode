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
package club.xiaoandx.section8;

/**  
 * <p>线程调度  线程的优先级</p> 

 * @ClassName:Example_8_4   
 * @author: WEI.ZHOU
 * @date: 2021-03-21 15:52
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
public class Example_8_4 {
	public static void main(String[] args) {
		// 创建两个线程
		Thread minPriority = new Thread(new MinPriority(), "1的线程");
		Thread maxPriority = new Thread(new MaxPriority(), "10的线程");
		// 设置线程的优先级为1
		minPriority.setPriority(Thread.MIN_PRIORITY); 
		// 设置线程的优先级为10
		maxPriority.setPriority(Thread.MAX_PRIORITY); 
		// 开启两个线程
		maxPriority.start();
		minPriority.start();
	}
}

/**
 * <p> 定义类MaxPriority实现Runnable接口 </p> 
 * @ClassName:MaxPriority   
 * @author: WEI.ZHOU
 * @date: 2021-03-21 15:53
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
class MaxPriority implements Runnable {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "正在输出：" + i);
		}
	}
}

/**
 * <p> 定义类MinPriority实现Runnable接口 </p> 
 * @ClassName:MinPriority   
 * @author: WEI.ZHOU
 * @date: 2021-03-21 15:54
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
class MinPriority implements Runnable {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "正在输出：" + i);
		}
	}
}
