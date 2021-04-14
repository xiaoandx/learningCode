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
package club.xiaoandx.structure.facade;

/**  
 * <p> 结构型设计模式 - 外观测试类 </p> 
 * @ClassName:TestFacade   
 * @author: WEI.ZHOU
 * @date: 2021-04-14 17:04
 * @since: JDK1.8
 * @version V1.0.0
 */
public class TestFacade {
	
	public static void main(String[] args) {
		Facade facade = new Facade();
		facade.wacthMovie("环太平洋");
	}
}
