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
package club.xiaoandx.experiment3.assignment2.test1;

import club.xiaoandx.experiment3.assignment2.test1.equipment.AirConditioner;
import club.xiaoandx.experiment3.assignment2.test1.equipment.Television;
import club.xiaoandx.experiment3.assignment2.test1.factory.BrandFactory;
import club.xiaoandx.experiment3.assignment2.test1.factory.impl.HaierFactory;
import club.xiaoandx.experiment3.assignment2.test1.factory.impl.TCLFactory;

/**  
 * <p> 电器工厂生产多种电器测试类 </p> 
 * @ClassName:TestEquipment   
 * @author: WEI.ZHOU
 * @date: 2021-04-08 16:33
 * @since: JDK1.8
 * @version V1.0.0
 */
public class TestEquipment {
	
	/**
	 *Test:
	 *	1. 先创建具体品牌工厂对象
	 *	2. 在通过品牌工厂对象创建该品牌的各类电器产品（TV、Air）
	 *	3. 具体产品进行运行测试
	 * @Title: main  
	 * @date: 2021-04-08 16:41
	 */
	public static void main(String[] args) {
		
		//	创建TCL工厂对象
		BrandFactory tclFactory = new TCLFactory();
		//	通过TCL工厂创建TCL空调
		AirConditioner tclAirConditioner = tclFactory.getAirConditioner();
		//	运行TCL空调
		tclAirConditioner.play();
		
		//	通过TCL工厂创建TCL电视
		Television tclTelevision = tclFactory.getTelevision();
		//	播放TCL电视
		tclTelevision.play();
		
		System.out.println("==================== TCL 与   Haier 产品测试分割线	 =====================");
		
		//	创建Haier工厂
		BrandFactory haierFactory = new HaierFactory();
		//	通过Haier工厂创建Haier空调
		AirConditioner haierAirConditioner = haierFactory.getAirConditioner();
		//	运行Haier空调
		haierAirConditioner.play();
		
		//	通过Haier工厂创建Haier电视
		Television haierTelevision = haierFactory.getTelevision();
		//	播放Haier电视
		haierTelevision.play();
	}

}
