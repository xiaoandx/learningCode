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
package club.xiaoandx.expound.singletonPattern;

/**  
 * <p> 懒汉式改进1  - 线程安全(加synchronized锁)</p> 
 * <pre>
 * 	1. 静态变量 被延迟实例化，这样做的好处是，如果没有用到该类，那么就不会实例化，从而节约资源。
 * 	2. 对 getUniqueInstance() 方法加锁，那么在一个时间点只能有一个线程能够进入该方法，
 * 		从而避免了多次实例化 uniqueInstance 的问题。
 * 	3. 但是当一个线程进入该方法之后，其它试图进入该方法的线程都必须等待，因此性能上有一定的损耗
 * </pre>
 * @ClassName:SluggardStyleImprove_1   
 * @author: WEI.ZHOU
 * @date: 2021-04-08 12:47
 * @since: JDK1.8
 * @version V1.0.0
 */
public class SluggardStyleImprove_1 {
	public static void main(String[] args) {
		/*
		 * Test:
		 * 1.多线程（默认）创建5个SingletonImprove_1对象
		 * 2.各自对象通过测试方法play(),验证5个对象引用地址是否相同
		 */
		for (int i = 0; i < 5; i++) {
			new Thread(() -> SingletonImprove_1.getUniqueInstance().play()).start();
		}
	}
}

/**
 * 
 * <p> 单例模式-懒汉式改进1 </p> 
 * @ClassName:SingletonImprove_1   
 * @author: WEI.ZHOU
 * @date: 2021-04-08 12:48
 * @since: JDK1.8
 * @version V1.0.0
 */
class SingletonImprove_1 {
    private static SingletonImprove_1 uniqueInstance;
    private SingletonImprove_1() {}
    
    /**
	 * <p> 获取唯一可用的对象 </p> </br>
	 * @Title: getUniqueInstance
	 * @date: 2021-04-08 12:54
	 * @return Singleton
	 * @since: 1.0.0
	 */
	public static synchronized SingletonImprove_1 getUniqueInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new SingletonImprove_1();
		}
		return uniqueInstance;
	}
    
    /**
     * <p> 测试方法 </p></br>
     * @Title: play  
     * @date: 2021-04-08 12:52 void    
     * @since: 1.0.0   
     */
	public void play() {
		System.out.println("对象创建成功 "+ uniqueInstance);
	}
}
