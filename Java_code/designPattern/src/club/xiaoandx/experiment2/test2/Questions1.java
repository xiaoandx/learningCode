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
package club.xiaoandx.experiment2.test2;

/**  
 * <p> 任务二 </p> 
 *	1. 工厂方法UML图代码框架
 * @ClassName:Questions1   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 21:40
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Questions1 {
	public static void main(String[] args) {
		/*
		 * Test:
		 * 	1. 声明产品对象用于接收通过工厂模式创建的具体产品对象、
		 * 	2. 通过具体产品工厂类获取具体产品的对象
		 * 	3. 产品调用测试方法进行验证
		 */
		IProduct iProduct;
		IFactory iFactory = new ConcreteFactory();
		iProduct = iFactory.FactoryMethod();
		iProduct.play();
	}
}

/**
 * <p> 定义抽象IProduct类 </p> 
 * @ClassName:IProduct   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 21:53
 * @since: JDK1.8
 * @version V1.0.0
 */
abstract class IProduct{
	
	/**
	 * <p> 定义一个抽象方法 </p></br>
	 * @Title: play  
	 * @date: 2021-03-25 21:54 void    
	 * @since: 1.0.0   
	 */
	public abstract void play();
}

/**
 * <p> 具体实现ConreteProduct的类 </p> 
 * @ClassName:ConreteProduct   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 21:55
 * @since: JDK1.8
 * @version V1.0.0
 */
class ConreteProduct extends IProduct{

	/**   
	 * <p> 实现抽象方法进行测试 </p></br>
	 * <p>Title: play</p> 
	 * @date: 2021-03-25 21:47       
	 * @see club.xiaoandx.experiment2.test2.IProduct#play()   
	 */
	@Override
	public void play() {
		System.out.println("This is ConreteProduct extends IProduct");
	}
}

/**
 * <p> 工厂方法工厂抽象类 </p> 
 * @ClassName:IFactory   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 21:56
 * @since: JDK1.8
 * @version V1.0.0
 */
abstract class IFactory{
	
	/**
	 * <p> 生成获取Product对象 </p></br>
	 * @Title: FactoryMethod  
	 * @date: 2021-03-25 21:56
	 * @return IProduct    
	 * @since: 1.0.0   
	 */
	public abstract IProduct FactoryMethod();
}

/**
 * <p> 产品具体的工厂模式 </p> 
 * @ClassName:ConcreteFactory   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 21:58
 * @since: JDK1.8
 * @version V1.0.0
 */
class ConcreteFactory extends IFactory{

	/**   
	 * <p> 获取具体产品对象 </p></br>
	 * <p>Title: FactoryMethod</p> 
	 * @date: 2021-03-25 21:49    
	 * @return  IProduct	产品对象 
	 * @see club.xiaoandx.experiment2.test2.IFactory#FactoryMethod()   
	 */
	@Override
	public IProduct FactoryMethod() {
		return new ConreteProduct();
	}
	
}