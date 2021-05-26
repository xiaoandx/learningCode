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
package club.xiaoandx.experiment6.assignment1.business.pancakeHouse;

import java.util.ArrayList;

import club.xiaoandx.experiment6.assignment1.business.MenuItem;
import club.xiaoandx.experiment6.assignment1.iterator.Iterator;

/**  
 * <p> 煎饼屋  </p> 
 * @ClassName:PancakeHouseMenu   
 * @author: WEI.ZHOU
 * @date: 2021-05-26 16:58
 * @since: JDK1.8
 * @version V1.0.0
 */
public class PancakeHouseMenu {
	
	/**
	 * 煎饼屋 菜单集合
	 */
	ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
	
	/**
	 * <p> 向煎饼屋菜单中添加新的菜单项  </p></br>
	 * @Title: addMenuItem  
	 * @date: 2021-05-26 17:11
	 * @param name		菜品名称
	 * @param des		菜品介绍
	 * @param price 	菜品价格
	 * @since: 1.0.0   
	 */
	public void addMenuItem(String name, String des, double price) {
		menuItems.add(new MenuItem(name, des, price));
	}
	
	/**
	 * <p> 获取煎饼屋全部菜单迭代器 </p></br>
	 * @Title: createIterator  
	 * @date: 2021-05-26 17:12
	 * @return Iterator		迭代器 
	 * @since: 1.0.0   
	 */
	public Iterator createIterator() {
		return new PancakeHouseIterator(menuItems);
	}
}
