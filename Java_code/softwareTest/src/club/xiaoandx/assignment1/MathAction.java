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
package club.xiaoandx.assignment1;

import java.math.BigDecimal;

/**  
 * <p> 数学运行类 </p> 
 * @ClassName:Addition   
 * @author: WEI.ZHOU
 * @date: 2021-04-16 08:37
 * @since: JDK1.8
 * @version V1.0.0
 */
public class MathAction {
	
	private static MathAction mathAction;
	
	private MathAction() {};
	
	/**
	 * <p> 单例模式 - 懒汉模式 </p></br>
	 * @Title: getAddition  
	 * @date: 2021-04-16 09:12
	 * @return Addition    
	 * @since: 1.0.0   
	 * @throws
	 */
	public static MathAction getMathAction() {
		if(mathAction == null) {
			mathAction = new MathAction();
		}
		return mathAction;
	}
	
	
	/**
	 * <p> 两个数相加,支持基本数据类型的相加操作 </p>
	 * 支持：
	 * 	1.byte
	 * 	2.short
	 * 	3.int
	 * 	4.long
	 * 	5.float
	 * 	6.double
	 * @Title: add   
	 * @date: 2021-03-24 11:29
	 * @param x
	 * @param y
	 * @return double (x + y)   
	 * @since: 1.1.0   
	 */
	public double add(double x, double y) {
		BigDecimal bg_x = new BigDecimal(Double.toString(x));
		BigDecimal bg_y = new BigDecimal(Double.toString(y));
		return bg_x.add(bg_y).doubleValue();
	}
	
	/**
	 * <p> 两个数相减,支持基本数据类型的相减操作 </p>
	 * 支持：
	 * 	1.byte
	 * 	2.short
	 * 	3.int
	 * 	4.long
	 * 	5.float
	 * 	6.double
	 * @Title: subtract   
	 * @date: 2021-03-24 11:39
	 * @param x
	 * @param y
	 * @return double (x - y)    
	 * @since: 1.0.0   
	 */
	public double subtract(double x, double y) {
		BigDecimal bg_x = new BigDecimal(Double.toString(x));
		BigDecimal bg_y = new BigDecimal(Double.toString(y));
		return bg_x.subtract(bg_y).doubleValue();
	}
}
