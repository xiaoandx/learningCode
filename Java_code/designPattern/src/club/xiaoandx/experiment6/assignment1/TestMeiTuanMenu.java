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
package club.xiaoandx.experiment6.assignment1;

import club.xiaoandx.experiment6.assignment1.business.dinerMenu.DinerMenu;
import club.xiaoandx.experiment6.assignment1.business.drypan.DryPanMenu;
import club.xiaoandx.experiment6.assignment1.business.hotpot.HotPotMenu;
import club.xiaoandx.experiment6.assignment1.business.pancakeHouse.PancakeHouseMenu;

/**  
 * <p> 美团代理商店菜单输出 </p> 
 * @ClassName:TestMeiTuanMenu   
 * @author: WEI.ZHOU
 * @date: 2021-05-26 18:19
 * @since: JDK1.8
 * @version V1.0.0
 */
public class TestMeiTuanMenu {
	
	public static void main(String[] args) {
		/**
		 * 创建干锅店的菜单
		 */
		DryPanMenu dryPan = new DryPanMenu();
		dryPan.addDryPanMenuItem("干锅鱼", "没有刺的鱼", 58.90);
		dryPan.addDryPanMenuItem("干锅兔", "好吃的兔肉", 58.90);
		dryPan.addDryPanMenuItem("干锅排骨", "新鲜排骨", 58.90);
		
		/**
		 * 创建火锅店菜单
		 */
		HotPotMenu hotPotMenu = new HotPotMenu();
		hotPotMenu.addMenuItem("菌汤火锅", "不辣，清汤", 100);
		hotPotMenu.addMenuItem("牛油火锅", "辣，好味道", 110);
		hotPotMenu.addMenuItem("清油火锅", "不辣，好味道", 105);
		
		/**
		 * 创建 餐馆 菜单
		 */
		DinerMenu dinerMenu = new DinerMenu();
		dinerMenu.addMenuItem("青椒肉丝", "家常便菜", 8.5);
		dinerMenu.addMenuItem("丸子青菜汤", "家常便菜", 10);
		dinerMenu.addMenuItem("潘茄蛋汤", "家常便菜", 7);
		
		/**
		 * 创建 煎饼屋 菜单
		 */
		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
		pancakeHouseMenu.addMenuItem("普通煎饼", "实惠", 5);
		pancakeHouseMenu.addMenuItem("加肠煎饼", "实惠好吃", 6);
		pancakeHouseMenu.addMenuItem("加肠加蛋煎饼", "超级好吃", 8);
		
		/**
		 * 美团进行菜单代理
		 */
		Meituan meituan = new Meituan(dinerMenu, dryPan, hotPotMenu, pancakeHouseMenu);
		meituan.printMenus();
	}
	
}
