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
 * <p> Thread 与 runnable 两者区别</p> 
 * @ClassName:Example_8_3  
 * @author: WEI.ZHOU
 * @date: 2021-03-21 13:46
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
public class Example_8_3 {
	public static void main(String[] args) {
		
		// ================= Thread 售票 ================
//		// 创建第一个线程窗口售票
//		new TicketWindow().start();
//		// 创建第二个线程窗口售票
//		new TicketWindow().start();
//		// 创建第三个线程窗口售票
//		new TicketWindow().start();
//		// 创建第四个线程窗口售票
//		new TicketWindow().start();
		// =============================================
		// 缺点：每次new TicketWindow() 一个线程对象 就会有一个tickets=100的变量，由于
		// 售票系统的票资源是共享的这种方式不合理
		
		
		// ================ Runnable售票 ===================
		// 创建线程对象
		TicketWindow myThread = new TicketWindow();
		// 创建线程窗口1
		new Thread(myThread, "窗口1").start();
		// 创建线程窗口2
		new Thread(myThread, "窗口2").start();
		// 创建线程窗口3
		new Thread(myThread, "窗口3").start();
		// 创建线程窗口4
		new Thread(myThread, "窗口4").start();
		
	}
}

// ========================== Thread =============================
//class TicketWindow extends Thread{
//	private int tickets = 100;
//	/**   
//	 * <p> 重写Thread中的run函数</p></br>
//	 * <p>Title: run</p> 
//	 * @date: 2021-03-21 13:27       
//	 * @see java.lang.Thread#run()   
//	 */
//	@Override
//	public void run() {
//		while (true) {
//			if(tickets > 0) {
//				// 获取当前线程
//				Thread th = Thread.currentThread();
//				String threadName = th.getName();
//				System.out.println(threadName + "正在发售第 " + tickets-- + "张票");
//			}
//		}
//	}
//}


class TicketWindow implements Runnable{
	private int tickets = 100;
	/**   
	 * <p> 重写Thread中的run函数</p></br>
	 * <p>Title: run</p> 
	 * @date: 2021-03-21 13:27       
	 * @see java.lang.Thread#run()   
	 */
	@Override
	public void run() {
		while (true) {
			if(tickets > 0) {
				// 获取当前线程
				Thread th = Thread.currentThread();
				String threadName = th.getName();
				System.out.println(threadName + "正在发售第 " + tickets-- + "张票");
			}
		}
	}
}
