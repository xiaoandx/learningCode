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
package club.xiaoandx.experiment3.assignment1.test3.factory;

import club.xiaoandx.experiment3.assignment1.test3.greenstuff.Greenstuff;

/**  
 * <p> 蔬菜工厂 </p>
 * 	1. 提供种根菜与种茎菜方法
 * @ClassName:GreenstuffFactory   
 * @author: WEI.ZHOU
 * @date: 2021-04-01 19:45
 * @since: JDK1.8
 * @version V1.0.0
 */
public interface GreenstuffFactory {
	
	/**
	 * <p> 根菜蔬菜 </p></br>
	 * @Title: getRootGreebstuff  
	 * @date: 2021-04-01 19:47 
	 * @return: Greenstuff		种植的蔬菜    
	 * @since: 1.0.0   
	 */
	Greenstuff getRootGreebstuff();
	
	/**
	 * <p> 茎菜蔬菜 </p></br>
	 * @Title: getStemGreenstuff  
	 * @date: 2021-04-01 19:47
	 * @return: Greenstuff		种植的蔬菜     
	 * @since: 1.0.0   
	 */
	Greenstuff getStemGreenstuff();
}
