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
package club.xiaoandx.experiment3.assignment1.test3.factory.impl;

import club.xiaoandx.experiment3.assignment1.test3.factory.GreenstuffFactory;
import club.xiaoandx.experiment3.assignment1.test3.greenstuff.Greenstuff;
import club.xiaoandx.experiment3.assignment1.test3.greenstuff.impl.NotTransgenosisRootGreenstuff;
import club.xiaoandx.experiment3.assignment1.test3.greenstuff.impl.NotTransgenosisStemGreenstuff;

/**  
 * <p> 种植非转基因工厂 </p> 
 *	1. 转基因工厂实现蔬菜工作
 *	2. 转基因工厂可以种植->非转基因根菜蔬菜  or 非转基因茎菜蔬菜
 * @ClassName:NotTransgenosisFactory   
 * @author: WEI.ZHOU
 * @date: 2021-04-01 19:49
 * @since: JDK1.8
 * @version V1.0.0
 */
public class NotTransgenosisFactory implements GreenstuffFactory {

	/**   
	 * <p> 非转基因根菜蔬菜 </p></br>
	 * <p>Title: getRootGreebstuff</p> 
	 * @return: Greenstuff		种植非转基因根菜蔬菜  
	 * @date: 2021-04-01 19:49       
	 * @see club.xiaoandx.experiment3.assignment1.test3.factory.GreenstuffFactory#getRootGreebstuff()   
	 */
	@Override
	public Greenstuff getRootGreebstuff() {
		return new NotTransgenosisRootGreenstuff();
	}

	/**   
	 * <p> 非转基因茎菜蔬菜 </p></br>
	 * <p>Title: getStemGreenstuff</p> 
	 * @return: Greenstuff		种植非转基因茎菜蔬菜  
	 * @date: 2021-04-01 19:49       
	 * @see club.xiaoandx.experiment3.assignment1.test3.factory.GreenstuffFactory#getStemGreenstuff()   
	 */
	@Override
	public Greenstuff getStemGreenstuff() {
		return new NotTransgenosisStemGreenstuff();
	}

}
