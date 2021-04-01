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
package club.xiaoandx.experiment3.assignment1.test2;

import club.xiaoandx.experiment3.assignment1.test2.greenstuff.Greenstuff;
import club.xiaoandx.experiment3.assignment1.test2.factory.GreenstuffFactory;
import club.xiaoandx.experiment3.assignment1.test2.factory.impl.RootGreenstuffFactory;
import club.xiaoandx.experiment3.assignment1.test2.factory.impl.StemGreenstuffFactory;

/**  
 * <p> 蔬菜种植工厂方法测试类	</p> 
 *	1. 通过蔬菜工厂接口具体实现的蔬菜类别工厂获取需要种植的蔬菜对象
 *	2. 调用蔬菜对象的种植方法进行种植
 * @ClassName:TestGreenstuff   
 * @author: WEI.ZHOU
 * @date: 2021-04-01 17:30
 * @since: JDK1.8
 * @version V1.0.0
 */
public class TestGreenstuff {
	
	public static void main(String[] args) {
		//	声明创建根菜蔬菜工厂对象
		GreenstuffFactory rootGreenstuffFactory = new RootGreenstuffFactory();
		//	通过根菜蔬菜工厂模式获取根菜蔬菜种植对象
		Greenstuff rootGreenstuff = rootGreenstuffFactory.getGreenstuff();
		
		//	声明创建茎菜蔬菜工厂对象
		GreenstuffFactory stemGreenstuffFactory = new StemGreenstuffFactory();
		//	通过茎蔬菜工厂模式获取茎菜蔬菜种植对象
		Greenstuff stemGreenstuff = stemGreenstuffFactory.getGreenstuff();
		
		rootGreenstuff.sowing();
		rootGreenstuff.growUp();
		rootGreenstuff.fruit();
		System.out.println("===============================");
		
		stemGreenstuff.sowing();
		stemGreenstuff.growUp();
		stemGreenstuff.fruit();
	}

}
