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
package club.xiaoandx.experiment6.assignment1.business.hotpot;

import club.xiaoandx.experiment6.assignment1.business.MenuItem;
import club.xiaoandx.experiment6.assignment1.iterator.Iterator;

/**  
 * <p> 火锅 </p> 
 * @ClassName:HotPotMenu   
 * @author: WEI.ZHOU
 * @date: 2021-05-26 17:44
 * @since: JDK1.8
 * @version V1.0.0
 */
public class HotPotMenu {
	
	/**
	 * 火锅菜单菜品最大数量
	 */
	private static final Integer MENU_ITEM_MAX = 10;
	
	int numberOfItems = 0; 
	
	/**
	 * 火锅菜单
	 */
	MenuItem[] hotPotMenus = new MenuItem[MENU_ITEM_MAX];
	
	/**
	 * <p> 添加菜单项 </p></br>
	 * @Title: addMenuItem  
	 * @date: 2021-05-26 18:57
	 * @param name		菜品名称
	 * @param des		菜品简介
	 * @param price		菜品价格
	 * @return void    	
	 * @since: 1.0.0   
	 */
	public void addMenuItem(String name, String des, double price) {
		if(numberOfItems < MENU_ITEM_MAX) {
			hotPotMenus[numberOfItems++] = new MenuItem(name, des, price);
		}
	}
	
	/**
	 * <p> 创建菜单迭代器 </p></br>
	 * @Title: createIterator  
	 * @date: 2021-05-26 18:58
	 * @return Iterator    
	 * @since: 1.0.0   
	 */
	public Iterator createIterator() {
		return new HotPotMenuIterator(hotPotMenus);
	}
}
