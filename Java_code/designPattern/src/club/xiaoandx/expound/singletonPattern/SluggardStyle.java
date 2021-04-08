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
 * <p> 懒汉式  - 线程不安全</p> 
 * <pre>
 * 	1. 静态变量 被延迟实例化，这样做的好处是，如果没有用到该类，那么就不会实例化，从而节约资源。
 * 	2. 这个实现在多线程环境下是不安全的，如果多个线程能够同时进入,这将导致多次实例化
 * 	
 * </pre>
 * @ClassName:SluggardStyle   
 * @author: WEI.ZHOU
 * @date: 2021-04-08 12:46
 * @since: JDK1.8
 * @version V1.0.0
 */
public class SluggardStyle {
	public static void main(String[] args) {
		/*
		 * Test:
		 * 1.单线程（默认）创建两个Singleton对象
		 * 2.通过测试方法play(),验证两个对象是否相同
		 */
		Singleton singleton = Singleton.getUniqueInstance();
		singleton.play();
		Singleton singleton2 = Singleton.getUniqueInstance();
		singleton2.play();
	}
}

/**
 * 
 * <p> 单例模式-懒汉式 </p> 
 * @ClassName:Singleton   
 * @author: WEI.ZHOU
 * @date: 2021-04-08 12:48
 * @since: JDK1.8
 * @version V1.0.0
 */
class Singleton {
    private static Singleton uniqueInstance;
    private Singleton() {}
    
    /**
     * <p> 获取唯一可用的对象  </p></br>
     * @Title: getUniqueInstance  
     * @date: 2021-04-08 12:54
     * @return Singleton    
     * @since: 1.0.0   
     */
    public static Singleton getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
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
