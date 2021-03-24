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
package club.xiaoandx.section1;

import java.math.BigDecimal;

/**  
 * <p> 学习Java第一个源文件 </p> </br>
 * 
 * 1.需要注意javaClass文件名与类名（带有public static的标识）必须一致
 * 2.文件命名及主类名的首字母必须大写，其它单词采用驼峰命名规则
 * 3.方法名首字母小写，其余单词采用驼峰命名
 * 4.java源文件需要先进行编译  将源码文件编译成字节码文件(.class)
 * 		编译得到字节码文件后 -> 再由JVM进行解释运行 -> 调用操作系统接口进行运行
 * 
 * @ClassName:Example1   
 * @author: WEI.ZHOU
 * @date: 2021-03-24 10:50
 * @since: JDK1.8
 * @version V1.0.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
public class Example1 {
	
	/**
	 * <p> 入口函数main </p></br>
	 * @Title: main   
	 * @date: 2021-03-24 10:52
	 * @param args      
	 * @return: void    
	 * @since: 1.0.0   
	 * @throws
	 */
	public static void main(String[] args) {
		int a, b;
		double sum;
		a = 20;
		b = 10;
		sum = subtract(a, b);
		System.out.println(a + " - " + b + " = " + sum);
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
	public static double add(double x, double y) {
		BigDecimal bg_x = new BigDecimal(Double.toString(x));
		BigDecimal bg_y = new BigDecimal(Double.toString(y));
		return bg_x.add(bg_y).doubleValue();
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
	 * @Title: subtract   
	 * @date: 2021-03-24 11:39
	 * @param x
	 * @param y
	 * @return double (x - y)    
	 * @since: 1.0.0   
	 */
	public static double subtract(double x, double y) {
		BigDecimal bg_x = new BigDecimal(Double.toString(x));
		BigDecimal bg_y = new BigDecimal(Double.toString(y));
		return bg_x.subtract(bg_y).doubleValue();
	}
}
