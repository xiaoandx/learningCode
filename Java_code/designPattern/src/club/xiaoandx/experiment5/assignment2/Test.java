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
package club.xiaoandx.experiment5.assignment2;

import club.xiaoandx.experiment5.assignment2.decorator.impl.Acid;
import club.xiaoandx.experiment5.assignment2.decorator.impl.Brown;
import club.xiaoandx.experiment5.assignment2.decorator.impl.Pretzel;
import club.xiaoandx.experiment5.assignment2.decorator.impl.Salt;
import club.xiaoandx.experiment5.assignment2.product.Bread;
import club.xiaoandx.experiment5.assignment2.product.impl.French;
import club.xiaoandx.experiment5.assignment2.product.impl.Japanese;

/**  
 * <p> 面包测试 </p> 
 * @ClassName:Test   
 * @author: WEI.ZHOU
 * @date: 2021-05-12 13:42
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Test {
	public static void main(String[] args) {
		/*
		 * 1.先获取基本的面包  法式、美式、日式
		 * 2.在基础面包上加调料
		 * 3.得到最新的面包，在进行价格输出
		 */
		Bread frenchBread = new French();
		Pretzel pretzel = new Pretzel(frenchBread);
		Acid acid = new Acid(pretzel);
		// 法式面包+椒盐+酸	的价格：13.5
		System.out.println(acid.getDescription() + " 的价格：" + acid.cost());
		
		Bread jpaBread = new Japanese();
		Brown brown = new Brown(jpaBread);
		Salt salt = new Salt(brown);
		// 日式面包+褐色+盐	的价格：16.0
		System.out.println(salt.getDescription() + " 的价格：" + salt.cost());
	}
}
