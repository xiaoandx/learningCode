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
package club.xiaoandx.assignment2;

/**  
 * <p> 三角形测试类 </p> 
 * @ClassName:Triangle   
 * @author: WEI.ZHOU
 * @date: 2021-05-14 08:37
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Triangle {
	
	/**
	 * @Title: createrTriangle  
	 * @date: 2021-05-14 08:46
	 * @param x		三角形x边
	 * @param y		三角形y边
	 * @param z		三角形z边
	 * @return int  判断结果
	 * @since: 1.0.0   
	 */
	public static int createrTriangle(int x, int y, int z) {
		if((x + y > z) && (y + z > x) && (x + z > y)) {
			if((x == y) && (y == z)) {
				return 3;
			}
			if((x == y) || (y == z) || (z == x)) {
				return 2;
			}else {
				return 1;
			}
		}
		return 0;
	}
}
