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
package club.xiaoandx.experiment3.test2;

/**  
 * <p> 任务二 </p> 
 *	1. P55页第4题
 * @ClassName:Questions2   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 22:06
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Questions2 {
	public static void main(String[] args) {
		/*
		 * Test:
		 * 	1. 通过具体汽车工厂生产对应的汽车
		 * 	2. 生产成功的汽车品牌进行测试
		 */
		Car bmwCar = new BMWFactory().getCar();
		Car benzCar = new BenzFactory().getCar();
		bmwCar.play();
		benzCar.play();
	}
}

/**
 * <p> Car抽象类 </p> 
 * @ClassName:Car   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 22:08
 * @since: JDK1.8
 * @version V1.0.0
 */
abstract class Car{
	
	/**
	 * <p> 抽象测试方法 </p></br>
	 * @Title: play  
	 * @date: 2021-03-25 22:09 void    
	 * @since: 1.0.0   
	 * @throws
	 */
	public abstract void play();
}

/**
 * <p> 宝马车  </p> 
 * @ClassName:BMW   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 22:11
 * @since: JDK1.8
 * @version V1.0.0
 */
class BMW extends Car{

	/**   
	 * <p>BMW play() </p></br>
	 * <p>Title: play</p> 
	 * @date: 2021-03-25 22:09       
	 * @see club.xiaoandx.experiment3.test2.Car#play()   
	 */
	@Override
	public void play() {
		System.out.println("BMW 生产成功");
	}
}

/**
 * <p> 奔驰 </p> 
 * @ClassName:Benz   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 22:12
 * @since: JDK1.8
 * @version V1.0.0
 */
class Benz extends Car{

	/**   
	 * <p> Benz </p></br>
	 * <p>Title: play</p> 
	 * @date: 2021-03-25 22:11       
	 * @see club.xiaoandx.experiment3.test2.Car#play()   
	 */
	@Override
	public void play() {
		System.out.println("Benz 生产成功");
	}
} 

/**
 * <p> 汽车工厂抽象类 </p> 
 * @ClassName:CarFactory   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 22:14
 * @since: JDK1.8
 * @version V1.0.0
 */
abstract class CarFactory{
	
	/**
	 * <p> 获取car对象抽象方法 </p></br>
	 * @Title: getCar  
	 * @date: 2021-03-25 22:14
	 * @return Car    
	 * @since: 1.0.0   
	 */
	public abstract Car getCar();
}

/**
 * <p> BMW工厂类 </p> 
 * @ClassName:BMWFactory   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 22:16
 * @since: JDK1.8
 * @version V1.0.0
 */
class BMWFactory extends CarFactory{

	/**   
	 * <p> 获取宝马车 </p></br>
	 * <p>Title: getCar</p> 
	 * @date: 2021-03-25 22:15    
	 * @return   
	 * @see club.xiaoandx.experiment3.test2.CarFactory#getCar()   
	 */
	@Override
	public Car getCar() {
		return new BMW();
	}
}

/**
 * <p> Benz工厂类 </p> 
 * @ClassName:BenzFactory   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 22:17
 * @since: JDK1.8
 * @version V1.0.0
 */
class BenzFactory extends CarFactory{

	/**   
	 * <p> 获取奔驰车  </p></br>
	 * <p>Title: getCar</p> 
	 * @date: 2021-03-25 22:17    
	 * @return   
	 * @see club.xiaoandx.experiment3.test2.CarFactory#getCar()   
	 */
	@Override
	public Car getCar() {
		return new Benz();
	}
}
