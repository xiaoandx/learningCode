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
 * <p> 线程安全 synchronized锁</p> 
 * @ClassName:Example_8_6   
 * @author: WEI.ZHOU
 * @date: 2021-03-23 21:49
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
public class Example_8_6 {
	public static void main(String[] args) {
		// 创建Ticket1对象
		Ticket1 ticket = new Ticket1(); 
        // 创建并开启四个线程
		new Thread(ticket,"线程一").start();
		new Thread(ticket,"线程二").start();
		new Thread(ticket,"线程三").start();
		new Thread(ticket,"线程四").start();
	}
}

/**
 * <p> 定义Ticket1类实现Runnable接口 </p> 
 * @ClassName:Ticket1   
 * @author: WEI.ZHOU
 * @date: 2021-03-23 21:50
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
class Ticket1 implements Runnable {
	private int tickets = 10;

	public void run() {
		while (true) {
			saleTicket(); // 调用售票方法
			if (tickets <= 0) {
				break;
			}
		}
	}

	// 定义一个同步方法saleTicket()
	private synchronized void saleTicket() {
		if (tickets > 0) {
			try {
				Thread.sleep(10); // 经过的线程休眠10毫秒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "---卖出的票" + tickets--);
		}
	}
}
