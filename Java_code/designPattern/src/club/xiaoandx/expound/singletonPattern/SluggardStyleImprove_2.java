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
 * <p> 懒汉式改进2  - 线程安全(加双检锁/双重校验锁)</p> 
 * <pre>
 * 	1. 静态变量 被延迟实例化，这样做的好处是，如果没有用到该类，那么就不会实例化，从而节约资源。
 * 	2. uniqueInstance 只需要被实例化一次，之后就可以直接使用了。
 * 	加锁操作只需要对实例化那部分的代码进行，只有当 uniqueInstance 没有被实例化时，才需要进行加锁。
 * 	3. 双重校验锁先判断 uniqueInstance 是否已经被实例化，如果没有被实例化，那么才对实例化语句进行加锁
 * </pre>
 * @ClassName:SluggardStyleImprove_2  
 * @author: WEI.ZHOU
 * @date: 2021-04-08 12:47
 * @since: JDK1.8
 * @version V1.0.0
 */
public class SluggardStyleImprove_2 {
	public static void main(String[] args) {
		/*
		 * Test:
		 * 1.多线程（默认）创建5个SingletonImprove_2对象
		 * 2.各自对象通过测试方法play(),验证5个对象引用地址是否相同
		 */
		for (int i = 0; i < 5; i++) {
			new Thread(() -> SingletonImprove_2.getUniqueInstance().play()).start();
		}
	}
}

/**
 * 
 * <p> 单例模式-懒汉式改进2 </p> 
 * @ClassName:SingletonImprove_2   
 * @author: WEI.ZHOU
 * @date: 2021-04-08 12:48
 * @since: JDK1.8
 * @version V1.0.0
 */
class SingletonImprove_2 {
	/**
	 * 	volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行
	 * 
	 *		采用 volatile 关键字修饰也是很有必要的。uniqueInstance = new Singleton(); 这段代码其实是分为三步执行。 
	 *	1分配内存空间           2初始化对象            3 将 uniqueInstance 指向分配的内存地址 
	 *	但是由于 JVM 具有指令重排的特性，有可能执行顺序变为了 1>3>2，这在单线程情况下自然是没有问题。
	 *	但如果是多线程下，有可能获得是一个还没有被初始化的实例，以致于程序出错
	 */
    private volatile  static SingletonImprove_2 uniqueInstance;
    private SingletonImprove_2() {}
    
    /**
	 * <p> 获取唯一可用的对象 </p> </br>
	 * <pre>
	 * 	如果两个线程同时执行 if 语句，那么两个线程就会同时进入 if 语句块内。
	 * 	虽然在 if 语句块内有加锁操作，但是两个线程都会执行 uniqueInstance = new Singleton(); 这条语句，只是先后的问题，
	 * 	那么就会进行两次实例化，从而产生了两个实例。因此必须使用双重校验锁，也就是需要使用两个 if 语句
	 * </pre>
	 * @Title: getUniqueInstance
	 * @date: 2021-04-08 12:54
	 * @return Singleton
	 * @since: 1.0.0
	 */
	public static SingletonImprove_2 getUniqueInstance() {
		if (uniqueInstance == null) {
			synchronized (SingletonImprove_2.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new SingletonImprove_2();
				}
			}
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
