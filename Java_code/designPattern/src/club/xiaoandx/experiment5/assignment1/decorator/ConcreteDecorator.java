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
package club.xiaoandx.experiment5.assignment1.decorator;

import club.xiaoandx.experiment5.assignment1.product.Component;

/**  
 * <p> 具体的装饰器实现  </p> 
 * @ClassName:ConcreteDecorator   
 * @author: WEI.ZHOU
 * @date: 2021-05-12 13:03
 * @since: JDK1.8
 * @version V1.0.0
 */
public class ConcreteDecorator extends Decorator{
	
	/**   
	 * <p> 当前还未进行装饰的 产品  </p></br>
	 * @Title:  ConcreteDecorator   
	 * @date: 2021-05-12 13:04 
	 * @since: 1.0.0
	 */
	public ConcreteDecorator(Component component) {
		this.component = component;
	}

	/**   
	 * <p>Title: operation</p> 
	 * @date: 2021-05-12 13:04    
	 * @return   Double		价格
	 * @see club.xiaoandx.experiment5.assignment1.product.Component#operation()   
	 */
	@Override
	public Double operation() {
		return component.operation() + 2.00;
	}

}
