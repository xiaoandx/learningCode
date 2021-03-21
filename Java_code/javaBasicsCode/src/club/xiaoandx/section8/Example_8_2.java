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
 * <p> 线程的创建 (Runnable) </p> 
 * 优点：Runnable是面向接口，所以不存在多继承的影响
 * @ClassName:Example_8_2
 * @author: WEI.ZHOU
 * @date: 2021-03-21 13:30
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
public class Example_8_2 {
	public static void main(String[] args) {
		// 创建线程对象
		MyThread2 myThread = new MyThread2();
		Thread thread = new Thread(myThread);
		// 开启线程
		thread.start();
		while(true) {
			System.out.println("main函数--在运行");
		}
	}
}

class MyThread2 implements Runnable{
	/**   
	 * <p> 重写Thread中的run函数</p></br>
	 * <p>Title: run</p> 
	 * @date: 2021-03-21 13:27       
	 * @see java.lang.Thread#run()   
	 */
	@Override
	public void run() {
		while (true) {
			System.out.println("MyThread类中的方法--在运行");
		}
	}
}
