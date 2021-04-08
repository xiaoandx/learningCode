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
 * <p> 单例模式 - 静态内部类实现 </p> 
 *	1. 种方式能达到双检锁方式一样的功效，但实现更简单。</br>
 *	2. 对静态域使用延迟初始化，应使用这种方式而不是双检锁方式。</br>
 *	3. 这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。</br>
 * @ClassName:StaticInteriorStyle   
 * @author: WEI.ZHOU
 * @date: 2021-04-08 13:21
 * @since: JDK1.8
 * @version V1.0.0
 */
public class StaticInteriorStyle {
	public static void main(String[] args) {
		/*
		 * Test:
		 * 1.多线程（默认）创建5个StaticInteriorSingleton对象
		 * 2.各自对象通过测试方法play(),验证5个对象引用地址是否相同
		 */
		for (int i = 0; i < 5; i++) {
			new Thread(() -> StaticInteriorSingleton.getUniqueInstance().play()).start();
		}
	}
}

/**
 * <p> 静态内部类  </p> 
 * @ClassName:StaticInteriorSingleton   
 * @author: WEI.ZHOU
 * @date: 2021-04-08 13:24
 * @since: JDK1.8
 * @version V1.0.0
 */
class StaticInteriorSingleton {

	private StaticInteriorSingleton() { }

	private static class SingletonHolder {
		/**
		 * 当 Singleton 类加载时，静态内部类 SingletonHolder 没有被加载进内存。</br>
		 * 只有当调用 getUniqueInstance() 方法从而触发 SingletonHolder.INSTANCE </br>
		 * 时 SingletonHolder 才会被加载,此时初始化 INSTANCE 实例
		 */
		private static final StaticInteriorSingleton INSTANCE = new StaticInteriorSingleton();
	}

	public static StaticInteriorSingleton getUniqueInstance() {
		return SingletonHolder.INSTANCE;
	}
	
	/**
     * <p> 测试方法 </p></br>
     * @Title: play  
     * @date: 2021-04-08 12:52 void    
     * @since: 1.0.0   
     */
	public void play() {
		System.out.println("对象创建成功 "+ SingletonHolder.INSTANCE);
	}
}
