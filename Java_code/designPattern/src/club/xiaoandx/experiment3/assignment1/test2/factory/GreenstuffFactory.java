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
package club.xiaoandx.experiment3.assignment1.test2.factory;

import club.xiaoandx.experiment3.assignment1.test2.greenstuff.Greenstuff;

/**  
 * <p> 蔬菜种植工厂方法 </p> 
 *	1. 具体蔬菜类别的工厂方法需要实现本接口
 * @ClassName:GreenstuffFactory   
 * @author: WEI.ZHOU
 * @date: 2021-04-01 17:21
 * @since: JDK1.8
 * @version V1.0.0
 */
public interface GreenstuffFactory {
	
	/**
	 * <p> 获取种植蔬菜对象 </p></br>
	 * @Title: getGreenstuff  
	 * @date: 2021-04-01 17:22
	 * @return Greenstuff    
	 * @since: 1.0.0   
	 * @throws
	 */
	Greenstuff getGreenstuff();
}
