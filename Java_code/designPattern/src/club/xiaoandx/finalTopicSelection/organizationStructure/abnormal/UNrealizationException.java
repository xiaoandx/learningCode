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
package club.xiaoandx.finalTopicSelection.organizationStructure.abnormal;

/**  
 * <p> 没有实现异常 </p> 
 * @ClassName:UNrealizationException   
 * @author: WEI.ZHOU
 * @date: 2021-05-26 19:31
 * @since: JDK1.8
 * @version V1.0.0
 */
public class UNrealizationException extends RuntimeException{
	
	/**   
	 * @Fields serialVersionUID   
	 */ 
	private static final long serialVersionUID = -7747427081570808812L;

	public UNrealizationException() {
        super("方法没有进行实现");
    }
}
