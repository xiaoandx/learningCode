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
 * <p> 单例模式 - 饿汉式 </p> 
 * <pre>
 * 	这种方式比较常用，但容易产生垃圾对象。
 *	优点：没有加锁，执行效率会提高。
 *	缺点：类加载时就初始化，浪费内存。
 * </pre>
 *	
 * @ClassName:HungryManStyle   
 * @author: WEI.ZHOU
 * @date: 2021-04-08 13:15
 * @since: JDK1.8
 * @version V1.0.0
 */
public class HungryManStyle {
	public static void main(String[] args) {
		/*
		 * Test:
		 * 1.多线程（默认）创建5个HungrySingleton对象
		 * 2.各自对象通过测试方法play(),验证5个对象引用地址是否相同
		 */
		for (int i = 0; i < 5; i++) {
			new Thread(() -> HungrySingleton.getInstance().play()).start();
		}
	}
}

/**
 * <p> 饿汉式 </p> 
 * @ClassName:HungrySingleton   
 * @author: WEI.ZHOU
 * @date: 2021-04-08 13:17
 * @since: JDK1.8
 * @version V1.0.0
 */
class HungrySingleton {
	
	/**
	 * <p>
	 * 	采取直接实例化 instance 的方式就不会产生线程不安全问题。</br>
	 * 	但是直接实例化的方式也丢失了延迟实例化带来的节约资源的好处。
	 * </p>
	 */
	private static HungrySingleton instance = new HungrySingleton();

	private HungrySingleton() { }
	
	/**
	 * 
	 * <p> 获取唯一对象 </p>
	 * @Title: getInstance  
	 * @date: 2021-04-08 13:17
	 * @return HungrySingleton    
	 * @since: 1.0.0   
	 */
	public static HungrySingleton getInstance() {
		return instance;
	}
	
	 /**
     * <p> 测试方法 </p></br>
     * @Title: play  
     * @date: 2021-04-08 12:52 void    
     * @since: 1.0.0   
     */
	public void play() {
		System.out.println("对象创建成功 "+ instance);
	}
}
