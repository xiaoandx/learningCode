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
package club.xiaoandx.experiment3.assignment1.test2.factory.impl;

import club.xiaoandx.experiment3.assignment1.test2.factory.GreenstuffFactory;
import club.xiaoandx.experiment3.assignment1.test2.greenstuff.Greenstuff;
import club.xiaoandx.experiment3.assignment1.test2.greenstuff.impl.StemGreenstuff;

/**  
 * <p> 茎菜蔬菜创建工厂  </p> 
 *
 * @ClassName:StemGreenstuffFactory   
 * @author: WEI.ZHOU
 * @date: 2021-04-01 17:28
 * @since: JDK1.8
 * @version V1.0.0
 */
public class StemGreenstuffFactory implements GreenstuffFactory {

	/**   
	 * <p> 获取茎菜蔬菜种植对象 </p></br>
	 * <p>Title: getGreenstuff</p> 
	 * @date: 2021-04-01 17:28    
	 * @return   Greenstuff		蔬菜种植对象
	 * @see club.xiaoandx.experiment3.assignment1.test2.factory.GreenstuffFactory#getGreenstuff()   
	 */
	@Override
	public Greenstuff getGreenstuff() {
		return new StemGreenstuff();
	}

}
