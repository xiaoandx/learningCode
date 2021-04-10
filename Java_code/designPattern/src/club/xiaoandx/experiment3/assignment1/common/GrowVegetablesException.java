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
package club.xiaoandx.experiment3.assignment1.common;

/**  
 * <p> 种菜自定义异常处理 </p> 
 * @ClassName:GrowVegetablesException   
 * @author: WEI.ZHOU
 * @date: 2021-04-10 20:35
 * @since: JDK1.8
 * @version V1.0.0
 */
public class GrowVegetablesException extends Exception {
	/**   
	 * @Fields serialVersionUID : TODO(Exception 版本标识号)   
	 */ 
	private static final long serialVersionUID = 7258712006837145035L;
	
	/**   
	 * <p> 自定义异常信息 构造器 </p></br>
	 * @Title:  GrowVegetablesException   
	 * @date: 2021-04-10 20:37 
	 * @since: 1.0.0
	 */
	public GrowVegetablesException(String massage) {
		super(massage);
	}

}
