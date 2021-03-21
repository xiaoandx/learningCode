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
 * <p> 线程的创建 (Thread) </p> 
 * 缺点：类只能单继承，如果有继承对象，则没办法进行Thread创建线程继承
 * @ClassName:Example_8_1   
 * @author: WEI.ZHOU
 * @date: 2021-03-21 13:24
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
public class Example_8_1 {
	public static void main(String[] args) {
		// 创建线程对象
		MyThread myThread = new MyThread();
		// 开启线程
		myThread.start();
		while(true) {
			System.out.println("main函数--在运行");
		}
	}
}

class MyThread extends Thread{
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
