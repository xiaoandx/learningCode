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
 * <p> 装饰器接口  </p> 
 * @ClassName:Decorator   
 * @author: WEI.ZHOU
 * @date: 2021-05-12 12:59
 * @since: JDK1.8
 * @version V1.0.0
 */
public abstract class Decorator implements Component{
	
	/**
	 * 装饰器装饰完成后其实还是一个最新的产品
	 */
	protected Component component;
}
