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
package club.xiaoandx.experiment2.test1;

/**  
 * <p> 任务一 </p> 
 *	1，简单工厂UML，根据UML图搭建代码框架
 * @ClassName:Questions1   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 10:42
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Questions1 {
	public static void main(String[] args) {
		/*
		 * Test：
		 * 	简单工厂创建对象测试
		 * 	1. 声明产品对象等待接收 想要得到的产品对象
		 * 	2. 通过工厂类中的getProduct("ProductA")方法获取具体产品对象
		 * 	3. getProduct("ProductA")方法中传入指定需要的对象ProductA
		 * 	4， 通过多态返回得到ProductA具体对象
		 */
		AbstractProduct product;
		product = SimpleProductFactory.getProduct("ProductA");
		product.methdDiff();
	}

}

/**
 * <p> 产品抽象，如果需要不同的产品，实现产品抽象接口即可 </p> 
 * @ClassName:AbstractProduct   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 10:56
 * @since: JDK1.8
 * @version V1.0
 */
abstract class AbstractProduct{
	/**
	 * <p> 抽象产品中的抽象方法 </p></br>
	 * @Title: methdDiff   
	 * @date: 2021-03-25 10:59 
	 * @return void    
	 * @since: 1.0.0   
	 */
	public abstract void methdDiff();
}

/**
 * <p> ProductA 产品实现抽象产品 得到具体的ProductA </p> 
 * @ClassName:ProductA   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 10:57
 * @since: JDK1.8
 * @version V1.0
 */
class ProductA extends AbstractProduct{

	/**   
	 * <p> ProductA 具体实现抽象方法，表明自身产品类别 </p></br>
	 * <p>Title: methdDiff</p> 
	 * @date: 2021-03-25 10:47       
	 * @see club.xiaoandx.experiment2.test1.AbstractProduct#methdDiff()   
	 */
	@Override
	public void methdDiff() {
		System.out.println("This is ProductA extends AbstractProduct");
	}
}

/**
 * <p> ProductB 产品实现抽象产品 得到具体的ProductB </p>
 * @ClassName:ProductB   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 11:02
 * @since: JDK1.8
 * @version V1.0.0
 */
class ProductB extends AbstractProduct{

	/**   
	 * <p> ProductA 具体实现抽象方法，表明自身产品类别 </p></br>
	 * <p>Title: methdDiff</p> 
	 * @date: 2021-03-25 10:47       
	 * @see club.xiaoandx.experiment2.test1.AbstractProduct#methdDiff()   
	 */
	@Override
	public void methdDiff() {
		System.out.println("This is ProductB extends AbstractProduct");
	}
}

/**
 * <p> 简单工厂类，复制生成需要的产品对象 </p> 
 *	1. 简单工厂类提供一个获取具体产品对象的静态方法getProduct(),通过getProduct()得到需要的产品对象
 * @ClassName:SimpleProductFactory   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 11:03
 * @since: JDK1.8
 * @version V1.0.0
 */
class SimpleProductFactory{
	
	/**
	 * <p> 获取指定产品对象 </p></br>
	 *	1. 根据传入的参数不同可以创建不同产品对象</br>
	 *		eg: SimpleProductFactory.getProduct("ProductA") 方法返回得到的是ProductA对象
	 * @Title: getProduct   
	 * @date: 2021-03-25 11:05
	 * @param productType		产品类型名称
	 * @return AbstractProduct	产品具体对象（多态）
	 * @since: 1.0.0   
	 */
	public static AbstractProduct getProduct(String productType) {
		AbstractProduct abstractProduct = null;
		if(productType.equalsIgnoreCase("ProductA")) {
			abstractProduct = new ProductA();
		}else if(productType.equalsIgnoreCase("ProductB")) {
			abstractProduct = new ProductB();
		}
		return abstractProduct;
	}
}
