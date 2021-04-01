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
package club.xiaoandx.experiment3.assignment1.test1.factory;

import club.xiaoandx.experiment3.assignment1.test1.greenstuff.Greenstuff;
import club.xiaoandx.experiment3.assignment1.test1.greenstuff.impl.CarotaImpl;
import club.xiaoandx.experiment3.assignment1.test1.greenstuff.impl.PotatoImpl;
import club.xiaoandx.experiment3.assignment1.test1.greenstuff.impl.RadishImpl;
import club.xiaoandx.experiment3.assignment1.test1.greenstuff.impl.TurnipImpl;

/**  
 * <p> 种植蔬菜工厂 </p> 
 *	1.通过种植方法得到具体需要种植蔬菜的对象
 * @ClassName:CultivateFactory   
 * @author: WEI.ZHOU
 * @date: 2021-04-01 16:48
 * @since: JDK1.8
 * @version V1.0.0
 */
public class CultivateFactory {
	
	/**
	 * <p> 获取需要种植蔬菜对象 </p></br>
	 * @Title: getGreestuff  
	 * @date: 2021-04-01 16:53
	 * @param type			蔬菜名称
	 * @return Greenstuff	种植蔬菜对象
	 * @since: 1.0.0   
	 */
	public Greenstuff getGreestuff(String type) {
		if(type.equalsIgnoreCase("turnip")) {
			return new TurnipImpl();
		}
		if(type.equalsIgnoreCase("radish")) {
			return new RadishImpl();
		}
		if(type.equalsIgnoreCase("potato")) {
			return new PotatoImpl();
		}
		if(type.equalsIgnoreCase("carota")) {
			return new CarotaImpl();
		}
		return null;
	}
}
