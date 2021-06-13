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
package club.xiaoandx.finalTopicSelection.caseList.decorator;

import club.xiaoandx.finalTopicSelection.caseList.product.Case;

/**  
 * <p> 病例装饰器 </p> 
 * @ClassName:CaseDecorator   
 * @author: WEI.ZHOU
 * @date: 2021-06-13 14:40
 * @since: JDK1.8
 * @version V1.0.0
 */
public abstract class CaseDecorator extends Case{
	
	/**
	 * 当前为病例对象
	 */
	public Case caseContext;
}
