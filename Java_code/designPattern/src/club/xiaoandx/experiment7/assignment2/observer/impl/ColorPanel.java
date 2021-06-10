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
package club.xiaoandx.experiment7.assignment2.observer.impl;

import club.xiaoandx.experiment7.assignment2.observer.PanelObserver;
import club.xiaoandx.experiment7.assignment2.pojo.Attribute;

/**  
 * <p> 彩色属性面板 </p> 
 * @ClassName:ColorPanel   
 * @author: WEI.ZHOU
 * @date: 2021-06-10 09:50
 * @since: JDK1.8
 * @version V1.0.0
 */
public class ColorPanel implements PanelObserver{
	
	/**
	 * 具体面板名称
	 */
	private String panelName;
	
	/**
	 * 游戏人物属性
	 */
	private Attribute attr;
	
	/**   
	 * @Title:  ColorPanel   
	 * @date: 2021-06-10 10:04 
	 * @since: 1.0.0
	 */
	public ColorPanel(String panelName) {
		this.panelName = panelName;
	}

	/**   
	 * <p>Title: update</p> 
	 * @date: 2021-06-10 09:56    
	 * @param attr   
	 * @see club.xiaoandx.experiment7.assignment2.observer.PanelObserver#update(club.xiaoandx.experiment7.assignment2.pojo.Attribute)   
	 */
	@Override
	public void update(Attribute attr) {
		this.attr = attr;
		showContext();
	}

	/**   
	 * <p>Title: show</p> 
	 * @date: 2021-06-10 10:08       
	 * @see club.xiaoandx.experiment7.assignment2.observer.PanelObserver#show()   
	 */
	@Override
	public void showContext() {
		System.out.println("===============" + panelName + "主题面板显示================");
		System.out.println(attr.getAname() + "\t头像地址："+attr.getAheadUrl());
		System.out.println("等级："+attr.getAgrade() + "  体力："+attr.getAcombatEffectiveeness());
		System.out.println("\t\t 经验数："+attr.getAexperience());
		System.out.println("金币："+attr.getAgoldCoin() + "\t 钻石数："+attr.getAdiamonds());
	}
}
