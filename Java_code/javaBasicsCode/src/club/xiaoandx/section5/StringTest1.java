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
package club.xiaoandx.section5;

/**  
 * <p> String 练习，设计一个方法，可以获取任意范围内的随机数 </p> 
 *
 * @ClassName:StringTest1   
 * @author: WEI.ZHOU
 * @date: 2021-04-28 10:31
 * @since: JDK1.8
 * @version V1.0.0
 */
public class StringTest1 {
	
	public static void main(String[] args) {
		for(int i=0; i<1000; i++) {
			int number  = getRandom(1, 100);
			System.out.println(number);
		}
	}
	
	/**
	 * <p> 获取指定范围内的随机数 </p></br>
	 * @Title: getRandom  
	 * @date: 2021-04-28 10:34
	 * @param start	范围开始
	 * @param end	范围结束
	 * @return int  生成的随机数(包含开始随机范围中开始与结束)
	 * @since: 1.0.0   
	 */
	public static int getRandom(int start, int end) {
		return (int) (Math.random() * (end - start + 1)) + start;
	}
}
