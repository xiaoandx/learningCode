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
 * <p> 线程等待，类似与seelp()  </p> 
 *
 * @ClassName:Example_8_5   
 * @author: WEI.ZHOU
 * @date: 2021-03-22 16:20
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
public class Example_8_5 {
	public static void main(String[] args) throws Exception {
		// 创建线程
		Thread t = new Thread(new EmergencyThread(),"线程一");
		t.start(); // 开启线程
		for (int i = 1; i < 6; i++) {
			System.out.println(Thread.currentThread().getName()+"输入："+i);
			if (i == 2) {
				t.join(); // 调用join()方法
		}
			Thread.sleep(500); // 线程休眠500毫秒
		}
	}
}

/**
 * @ClassName:EmergencyThread   
 * @author: WEI.ZHOU
 * @date: 2021-03-22 16:21
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
class EmergencyThread implements Runnable {
	public void run() {
		for (int i = 1; i < 6; i++) {
			System.out.println(Thread.currentThread().getName()+" 输入："+i);
			try {
				Thread.sleep(500); // 线程休眠500毫秒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}