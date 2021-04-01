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
package club.xiaoandx.experiment3.assignment1.test3.greenstuff.impl;

import club.xiaoandx.experiment3.assignment1.test3.greenstuff.RootGreenstuff;

/**  
 * <p> 转基因 茎菜 蔬菜 </p> 
 * @ClassName:TransgenosisStemGreenstuff   
 * @author: WEI.ZHOU
 * @date: 2021-04-01 19:37
 * @since: JDK1.8
 * @version V1.0.0
 */
public class TransgenosisStemGreenstuff implements RootGreenstuff {

	/**   
	 * <p> 播种 </p></br>
	 * <p>Title: sowing</p> 
	 * @date: 2021-04-01 19:37       
	 * @see club.xiaoandx.experiment3.assignment1.test3.greenstuff.Greenstuff#sowing()   
	 */
	@Override
	public void sowing() {
		System.out.println("播种转基因茎菜蔬菜");
	}

	/**   
	 * <p> 成长 </p></br>
	 * <p>Title: growUp</p> 
	 * @date: 2021-04-01 19:37       
	 * @see club.xiaoandx.experiment3.assignment1.test3.greenstuff.Greenstuff#growUp()   
	 */
	@Override
	public void growUp() {
		System.out.println("播种的转基因茎菜已经在成长中");
	}

	/**   
	 * <p> 果实 </p></br>
	 * <p>Title: fruit</p> 
	 * @date: 2021-04-01 19:37       
	 * @see club.xiaoandx.experiment3.assignment1.test3.greenstuff.Greenstuff#fruit()   
	 */
	@Override
	public void fruit() {
		System.out.println("转基因茎菜蔬菜已经成熟，得到果实");
	}

}
