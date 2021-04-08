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
package club.xiaoandx.experiment3.assignment2.test1.factory.impl;

import club.xiaoandx.experiment3.assignment2.test1.equipment.AirConditioner;
import club.xiaoandx.experiment3.assignment2.test1.equipment.Television;
import club.xiaoandx.experiment3.assignment2.test1.equipment.impl.HaierAir;
import club.xiaoandx.experiment3.assignment2.test1.equipment.impl.HaierTV;
import club.xiaoandx.experiment3.assignment2.test1.factory.BrandFactory;

/**  
 * <p> Haier 创建工厂类 </p> 
 * @ClassName:HaierFactory   
 * @author: WEI.ZHOU
 * @date: 2021-04-08 16:31
 * @since: JDK1.8
 * @version V1.0.0
 */
public class HaierFactory implements BrandFactory {

	/**   
	 * <p> 创建空调 </p></br>
	 * <p>Title: getAirConditioner</p> 
	 * @date: 2021-04-08 16:31    
	 * @return   AirConditioner		空调对象
	 * @see club.xiaoandx.experiment3.assignment2.test1.factory.BrandFactory#getAirConditioner()   
	 */
	@Override
	public AirConditioner getAirConditioner() {
		return new HaierAir();
	}

	/**   
	 * <p> 创建电视 </p></br>
	 * <p>Title: getTelevision</p> 
	 * @date: 2021-04-08 16:31    
	 * @return   Television			电视对象
	 * @see club.xiaoandx.experiment3.assignment2.test1.factory.BrandFactory#getTelevision()   
	 */
	@Override
	public Television getTelevision() {
		return new HaierTV();
	}

}
