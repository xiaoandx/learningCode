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
package club.xiaoandx.experiment3.assignment1.test1;

import club.xiaoandx.experiment3.assignment1.test1.factory.CultivateFactory;
import club.xiaoandx.experiment3.assignment1.test1.greenstuff.Greenstuff;

/**  
 * <p> 种植根菜蔬菜测试类 </p> 
 *	1. 通过根菜蔬菜工厂获取需要种植的蔬菜对象
 *	2. 调用对象中的方法进行种植
 * @ClassName:TestGreenstuff   
 * @author: WEI.ZHOU
 * @date: 2021-04-01 16:54
 * @since: JDK1.8
 * @version V1.0.0
 */
public class TestGreenstuff {
	
	public static void main(String[] args) {
		// 声明创建工厂模式对象，用于获取需要种植的蔬菜对象
		CultivateFactory cultivateFactory = new CultivateFactory();
		// 通过简单工厂模式获取大头菜种植对象
		Greenstuff turnipGreenstuff = cultivateFactory.getGreestuff("turnip");
		turnipGreenstuff.sowing();
		turnipGreenstuff.growUp();
		turnipGreenstuff.fruit();
		System.out.println("==========================================");
		
		// 通过简单工厂模式获取萝卜种植对象
		Greenstuff radishGreenstuff = cultivateFactory.getGreestuff("radish");
		radishGreenstuff.sowing();
		radishGreenstuff.growUp();
		radishGreenstuff.fruit();
		System.out.println("==========================================");
		
		// 通过简单工厂模式获取土豆种植对象
		Greenstuff potatoGreenstuff = cultivateFactory.getGreestuff("potato");
		potatoGreenstuff.sowing();
		potatoGreenstuff.growUp();
		potatoGreenstuff.fruit();
		System.out.println("==========================================");
		
		// 通过简单工厂模式获取胡萝卜种植对象
		Greenstuff carotaGreenstuff = cultivateFactory.getGreestuff("carota");
		carotaGreenstuff.sowing();
		carotaGreenstuff.growUp();
		carotaGreenstuff.fruit();
		System.out.println("==========================================");
	}

}
