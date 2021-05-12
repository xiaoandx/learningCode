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
package club.xiaoandx.experiment5.assignment1;

import club.xiaoandx.experiment5.assignment1.decorator.ConcreteDecorator;
import club.xiaoandx.experiment5.assignment1.product.Component;
import club.xiaoandx.experiment5.assignment1.product.impl.ConcreteComponent;

/**  
 * <p> 设计模式 - 装饰器测试 </p> 
 * @ClassName:Test   
 * @author: WEI.ZHOU
 * @date: 2021-05-12 13:08
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Test {
	public static void main(String[] args) {
		/*
		 * 1. 创建基础产品 
		 * 2. 将基础产品进行装饰器包装 -> 得到最新的产品
		 * 3. 最后计算最新产品的价格
		 */
		Component component = new ConcreteComponent();
		ConcreteDecorator concreteDecorator = new ConcreteDecorator(component);
		System.out.println("基础产品进行装饰包装后得到的新产品的价格：" + concreteDecorator.operation());
	}
}
