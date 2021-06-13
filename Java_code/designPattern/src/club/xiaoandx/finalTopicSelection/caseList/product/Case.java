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
package club.xiaoandx.finalTopicSelection.caseList.product;

/**  
 * <p> 病例     </p> 
 * @ClassName:Case   
 * @author: WEI.ZHOU
 * @date: 2021-06-13 14:34
 * @since: JDK1.8
 * @version V1.0.0
 */
public abstract class Case {
	
	/**
	 * <p> 计算病例中开出药的价格  </p></br>
	 * @Title: cost 	价格 
	 * @date: 2021-05-12 13:25
	 * @return double    
	 * @since: 1.0.0   
	 */
	public abstract double cost();
	
	/**
	 * <p> 获取病例中 药品 </p></br>
	 * @Title: getDescription  
	 * @date: 2021-05-12 13:26
	 * @return String 	药品名称描述   
	 * @since: 1.0.0   
	 */
	public abstract String getDescription();

}
