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
import club.xiaoandx.experiment5.assignment2.decorator.impl.Pretzel;
import club.xiaoandx.experiment5.assignment2.product.Bread;
import club.xiaoandx.experiment5.assignment2.product.impl.French;

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
		System.out.println(acid.getDescription() + "的价格：" + acid.cost());
	}
}
