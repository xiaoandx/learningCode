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
 * <p> 结构型 - 外观(Facade) </p>
 * 它提供了一个统一的接口，用来访问子系统中的一群接口，从而让子系统更容易使用 
 * @ClassName:Facade   
 * @author: WEI.ZHOU
 * @date: 2021-04-14 16:56
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Facade {
	
	private SubSystem subSystem = new SubSystem();
	
	/**
	 * <p> 包装对外统一观看电影接口 </p></br>
	 * @Title: wacthMovie  
	 * @date: 2021-04-14 17:03
	 * @param cdName void    
	 * @since: 1.0.0   
	 * @throws
	 */
	public void wacthMovie(String cdName) {
		subSystem.turnOnTV();
		subSystem.setCD(cdName);
		subSystem.starWatching();
	}
}
