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
package club.xiaoandx.experiment7.assignment2.observer;

import club.xiaoandx.experiment7.assignment2.pojo.Attribute;

/**  
 * <p> 属性展示面板 观察者接口 </p> 
 * @ClassName:Observer   
 * @author: WEI.ZHOU
 * @date: 2021-06-03 10:44
 * @since: JDK1.8
 * @version V1.0.0
 */
public interface PanelObserver {
	
	/**
	 * <p> 更新得到最新的游戏人物数据 </p></br>
	 * @Title: update  
	 * @date: 2021-06-10 10:06
	 * @param attr void    
	 * @since: 1.0.0   
	 */
	void update(Attribute attr);
	
	/**
	 * <p> 绘制UI显示 </p></br>
	 * @Title: showContext  
	 * @date: 2021-06-10 10:07 void    
	 * @since: 1.0.0   
	 * @throws
	 */
	void showContext();
}
