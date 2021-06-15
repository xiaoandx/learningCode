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
package club.xiaoandx.finalTopicSelection.caseList.decorator.impl;

import club.xiaoandx.finalTopicSelection.caseList.decorator.CaseDecorator;
import club.xiaoandx.finalTopicSelection.caseList.product.Case;

/**  
 * <p> 挂号 </p> 
 * @ClassName:Amoxicillin   
 * @author: WEI.ZHOU
 * @date: 2021-06-13 14:42
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Register extends CaseDecorator{
	
	/**   
	 * <p> </p></br>
	 * @Title:  Amoxicillin   
	 * @date: 2021-06-13 14:43 
	 * @since: 1.0.0
	 */
	public Register(Case caseContext) {
		super.caseContext = caseContext;
	}
	
	/**
	 * <p> 价格 </p></br>
	 * <p>Title: cost</p> 
	 * @date: 2021-06-13 14:45    
	 * @return   	药品价格
	 * @see club.xiaoandx.finalTopicSelection.caseList.product.Case#cost()
	 */
	@Override
	public double cost() {
		return caseContext.cost() + 10;
	}

	/**   
	 * <p> 药物</p></br>
	 * <p>Title: getDescription</p> 
	 * @date: 2021-06-13 14:45    
	 * @return		药品名称   
	 * @see club.xiaoandx.finalTopicSelection.caseList.product.Case#getDescription()   
	 */
	@Override
	public String getDescription() {
		return caseContext.getDescription() + " 挂号服务";
	}
	
}
