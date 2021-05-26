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
package club.xiaoandx.experiment6.assignment1.business.dinerMenu;

import java.util.LinkedList;
import java.util.List;

import club.xiaoandx.experiment6.assignment1.business.MenuItem;
import club.xiaoandx.experiment6.assignment1.iterator.Iterator;

/**  
 * <p> 餐馆 菜单 </p> 
 * @ClassName:DinerMenu   
 * @author: WEI.ZHOU
 * @date: 2021-05-26 17:15
 * @since: JDK1.8
 * @version V1.0.0
 */
public class DinerMenu {
	
	/**
	 * 餐馆菜单集合
	 */
	List<MenuItem> dinerMenus = new LinkedList<MenuItem>();
	
	/**
	 * <p> 向菜单添加新的菜品 </p></br>
	 * @Title: addMenuItem  
	 * @date: 2021-05-26 19:03
	 * @param name		菜品名称
	 * @param des		菜品简介
	 * @param price		菜品价格
	 * @return void       
	 * @since: 1.0.0   
	 */
	public void addMenuItem(String name, String des, double price) {
		dinerMenus.add(new MenuItem(name, des, price));
	}
	
	/**
	 * <p> 创建菜单迭代器 </p></br>
	 * @Title: createIterator  
	 * @date: 2021-05-26 19:04
	 * @return Iterator    
	 * @since: 1.0.0   
	 */
	public Iterator createIterator() {
		return new DinerMenuIterator(dinerMenus);
	}
}
