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
package club.xiaoandx.experiment5.assignment2.decorator;

import club.xiaoandx.experiment5.assignment2.product.Bread;

/**  
 * <p> 面包装饰基类 </p> 
 * @ClassName:BreadDecorator   
 * @author: WEI.ZHOU
 * @date: 2021-05-12 13:32
 * @since: JDK1.8
 * @version V1.0.0
 */
public abstract class BreadDecorator extends Bread{
	public Bread bread;
}
