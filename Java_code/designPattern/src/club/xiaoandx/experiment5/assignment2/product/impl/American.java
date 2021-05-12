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
package club.xiaoandx.experiment5.assignment2.product.impl;

import club.xiaoandx.experiment5.assignment2.product.Bread;

/**  
 * <p> 美式面包 </p> 
 * @ClassName:American   
 * @author: WEI.ZHOU
 * @date: 2021-05-12 13:28
 * @since: JDK1.8
 * @version V1.0.0
 */
public class American extends Bread{

	/**   
	 * <p>Title: cost</p> 
	 * @date: 2021-05-12 13:28    
	 * @return  double		面包价格 
	 * @see club.xiaoandx.experiment5.assignment2.product.Bread#cost()   
	 */
	@Override
	public double cost() {
		return 15;
	}

	/**   
	 * <p>Title: getDescription</p> 
	 * @date: 2021-05-12 13:28    
	 * @return 	String		面试描述  
	 * @see club.xiaoandx.experiment5.assignment2.product.Bread#getDescription()   
	 */
	@Override
	public String getDescription() {
		return "美式面包";
	}

}
