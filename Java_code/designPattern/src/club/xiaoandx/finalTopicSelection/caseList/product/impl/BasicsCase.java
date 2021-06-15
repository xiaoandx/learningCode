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
package club.xiaoandx.finalTopicSelection.caseList.product.impl;

import club.xiaoandx.finalTopicSelection.caseList.product.Case;

/**  
 * <p> 基础病例 </p> 
 *	病例中已经包括了 看病的基础费用
 * @ClassName:BasicsCase   
 * @author: WEI.ZHOU
 * @date: 2021-06-13 14:37
 * @since: JDK1.8
 * @version V1.0.0
 */
public class BasicsCase extends Case{

	/**   
	 * <p> 基础病例中的 价格 </p></br>
	 * <p>Title: cost</p> 
	 * @date: 2021-06-13 14:38    
	 * @return  		价格 
	 * @see club.xiaoandx.finalTopicSelection.caseList.product.Case#cost()   
	 */
	@Override
	public double cost() {
		return 0;
	}

	/**   
	 * <p> </p></br>
	 * <p>Title: getDescription</p> 
	 * @date: 2021-06-13 14:38    
	 * @return   		基础病例信息
	 * @see club.xiaoandx.finalTopicSelection.caseList.product.Case#getDescription()   
	 */
	@Override
	public String getDescription() {
		return "病例内容: ";
	}

}
