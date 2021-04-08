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
 * <p> 单例模式 - 枚举实现 </p> 
 *	1.这是单例模式的最佳实践，它实现简单，并且在面对复杂的序列化或者反射攻击的时候，能够防止实例化多次
 * @ClassName:EnumStyle   
 * @author: WEI.ZHOU
 * @date: 2021-04-08 13:28
 * @since: JDK1.8
 * @version V1.0.0
 */
public class EnumStyle {
	public static void main(String[] args) {
		/*
		 * Test:
		 * 1.多线程（默认）创建5个EnumSingleton对象
		 * 2.各自枚举对象通过测试方法play(),验证5个对象引用地址是否相同
		 */
		for (int i = 0; i < 5; i++) {
			new Thread(() -> EnumSingleton.INSTANCE.getInstance().play()).start();
		}
	}
}

/**
 * <p> 枚举实现 </p> 
 * @ClassName:EnumSingleton   
 * @author: WEI.ZHOU
 * @date: 2021-04-08 13:33
 * @since: JDK1.8
 * @version V1.0.0
 */
enum  EnumSingleton {
    INSTANCE;
    public EnumSingleton getInstance(){
        return INSTANCE;
    }
    
    /**
     * <p> 打印测试 </p></br>
     * @Title: play  
     * @date: 2021-04-08 13:36 void    
     * @since: 1.0.0   
     */
    public void play() {
		System.out.println("对象创建成功 "+ INSTANCE);
	}
}