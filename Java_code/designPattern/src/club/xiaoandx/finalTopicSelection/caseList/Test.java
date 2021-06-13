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
package club.xiaoandx.finalTopicSelection.caseList;

import club.xiaoandx.finalTopicSelection.caseList.decorator.CaseDecorator;
import club.xiaoandx.finalTopicSelection.caseList.decorator.impl.Amoxicillin;
import club.xiaoandx.finalTopicSelection.caseList.product.Case;
import club.xiaoandx.finalTopicSelection.caseList.product.impl.BasicsCase;

/**  
 * <p> 病历单测试 </p> 
 * @ClassName:Test   
 * @author: WEI.ZHOU
 * @date: 2021-06-13 14:47
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Test {
	public static void main(String[] args) {
		Case bingli = new BasicsCase();
		CaseDecorator amxl = new Amoxicillin(bingli);
		double cost = amxl.cost();
		String description = amxl.getDescription();
		System.out.println("病例的价格为："+cost);
		System.out.println("病例的组成为："+description);
	}
}
