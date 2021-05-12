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
package club.xiaoandx.experiment5.assignment2.decorator.impl;

import club.xiaoandx.experiment5.assignment2.decorator.BreadDecorator;
import club.xiaoandx.experiment5.assignment2.product.Bread;

/**  
 * <p> 装饰 - 酸 </p> 
 * @ClassName:Acid   
 * @author: WEI.ZHOU
 * @date: 2021-05-12 13:34
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Acid extends BreadDecorator{

	/**   
	 * <p> 获取需要进行装饰前的面包 </p></br>
	 * @Title:  Sugar   
	 * @date: 2021-05-12 13:34 
	 * @since: 1.0.0
	 */
	public Acid(Bread bread) {
		this.bread = bread;
	}
	
	/**   
	 * <p>Title: cost</p> 
	 * @date: 2021-05-12 13:34    
	 * @return   
	 * @see club.xiaoandx.experiment5.assignment2.product.Bread#cost()   
	 */
	@Override
	public double cost() {
		return bread.cost() + 1.0;
	}

	/**   
	 * <p>Title: getDescription</p> 
	 * @date: 2021-05-12 13:34    
	 * @return   
	 * @see club.xiaoandx.experiment5.assignment2.product.Bread#getDescription()   
	 */
	@Override
	public String getDescription() {
		return bread.getDescription() + "+酸";
	}

}
