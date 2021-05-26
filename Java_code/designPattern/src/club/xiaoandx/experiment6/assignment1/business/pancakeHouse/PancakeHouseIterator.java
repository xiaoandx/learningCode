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
 * <p> 煎饼屋 迭代器 </p> 
 *
 * @ClassName:PancakeHouseIterator   
 * @author: WEI.ZHOU
 * @date: 2021-05-26 17:01
 * @since: JDK1.8
 * @version V1.0.0
 */
public class PancakeHouseIterator implements Iterator {
	ArrayList<MenuItem> menuItems;
	int posittion = 0;
	
	/**   
	 * @Title:  PancakeHouseIterator   
	 * @date: 2021-05-26 17:02 
	 * @since: 1.0.0
	 */
	public PancakeHouseIterator(ArrayList<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	
	/**   
	 * <p>Title: hasNext</p> 
	 * @date: 2021-05-26 17:01    
	 * @return   
	 * @see club.xiaoandx.experiment6.assignment1.iterator.Iterator#hasNext()   
	 */
	@Override
	public boolean hasNext() {
		if (menuItems.size() != 0 && posittion < menuItems.size()
				&& menuItems.get(posittion) != null) {
			return true;
		}
		return false;
	}

	/**   
	 * <p>Title: next</p> 
	 * @date: 2021-05-26 17:01    
	 * @return   
	 * @see club.xiaoandx.experiment6.assignment1.iterator.Iterator#next()   
	 */
	@Override
	public Object next() {
		return menuItems.get(posittion++);
	}

}
