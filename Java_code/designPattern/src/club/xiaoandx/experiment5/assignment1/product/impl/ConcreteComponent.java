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
package club.xiaoandx.experiment5.assignment1.product.impl;

import club.xiaoandx.experiment5.assignment1.product.Component;

/**  
 * <p> 具体产品  </p> 
 * @ClassName:ConcreteComponent   
 * @author: WEI.ZHOU
 * @date: 2021-05-12 12:57
 * @since: JDK1.8
 * @version V1.0.0
 */
public class ConcreteComponent implements Component {

	/**   
	 * <p>Title: operation</p> 
	 * @return Double 		价格  
	 * @date: 2021-05-12 12:57       
	 * @see club.xiaoandx.experiment5.assignment1.product.Component#operation()   
	 */
	@Override
	public Double operation() {
		return 10.00;
	}

}
