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
package club.xiaoandx.experiment6.assignment1.business.drypan;

import java.util.HashMap;
import java.util.Map;

import club.xiaoandx.experiment6.assignment1.business.MenuItem;
import club.xiaoandx.experiment6.assignment1.iterator.Iterator;

/**  
 * <p> 干锅 菜单 </p> 
 * @ClassName:DryPanMenu   
 * @author: WEI.ZHOU
 * @date: 2021-05-26 17:54
 * @since: JDK1.8
 * @version V1.0.0
 */
public class DryPanMenu {
	
	/**
	 * 干锅菜单集合
	 */
	Map<String, MenuItem> dryPanMenus = new HashMap<String, MenuItem>();
	
	int pointer;
	
	/**   
	 * <p> </p></br>
	 * @Title:  MapTest   
	 * @date: 2021-05-29 17:02 
	 * @since: 1.0.0
	 */
	public DryPanMenu() {
		pointer = 0;
	}
	/**
	 * <p> 向菜单添加菜品 </p></br>
	 * @Title: addDryPanMenuItem  
	 * @date: 2021-05-26 19:01
	 * @param name		菜品名称
	 * @param des		菜品简介
	 * @param price		菜品价格
	 * @return void    
	 * @since: 1.0.0   
	 */
	public void addDryPanMenuItem(String name, String des, double price) {
		dryPanMenus.put(String.valueOf(pointer++), new MenuItem(name, des, price));
	}
	
	/**
	 * <p> 创建菜单迭代器 </p></br>
	 * @Title: createIterator  
	 * @date: 2021-05-26 19:02
	 * @return Iterator    
	 * @since: 1.0.0   
	 */
	public Iterator createIterator() {
		return new DryPanMenuIterator(dryPanMenus);
	}
	
}
