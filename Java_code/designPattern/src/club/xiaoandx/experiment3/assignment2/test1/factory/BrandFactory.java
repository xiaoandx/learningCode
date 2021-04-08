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
package club.xiaoandx.experiment3.assignment2.test1.factory;

import club.xiaoandx.experiment3.assignment2.test1.equipment.AirConditioner;
import club.xiaoandx.experiment3.assignment2.test1.equipment.Television;

/**  
 * <p> 企业工厂接口  - 提供企业创建各种电器的方法 </p> 
 * @ClassName:EFactory   
 * @author: WEI.ZHOU
 * @date: 2021-04-08 16:23
 * @since: JDK1.8
 * @version V1.0.0
 */
public interface BrandFactory {
	
	/**
	 * <p> 创建空调方法 </p></br>
	 * @Title: getAirConditioner  
	 * @date: 2021-04-08 16:27
	 * @return AirConditioner    
	 * @since: 1.0.0   
	 */
	AirConditioner getAirConditioner();
	
	
	/**
	 * <p> 创建电视方法 </p></br>
	 * @Title: getTelevision  
	 * @date: 2021-04-08 16:27
	 * @return Television    
	 * @since: 1.0.0   
	 */
	Television getTelevision();
}
