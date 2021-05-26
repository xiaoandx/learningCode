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
 * <p> 火锅菜单迭代器 </p> 
 * @ClassName:HotPotMenuIterator   
 * @author: WEI.ZHOU
 * @date: 2021-05-26 17:50
 * @since: JDK1.8
 * @version V1.0.0
 */
public class HotPotMenuIterator implements Iterator {
	
	MenuItem[] hotPotMenus;
	
	int posittion = 0;
	
	/**   
	 * @Title:  HotPotMenuIterator   
	 * @date: 2021-05-26 17:50 
	 * @since: 1.0.0
	 */
	public HotPotMenuIterator(MenuItem[] hotPotMenus) {
		this.hotPotMenus = hotPotMenus;
	}

	/**   
	 * <p>Title: hasNext</p> 
	 * @date: 2021-05-26 17:50    
	 * @return   
	 * @see club.xiaoandx.experiment6.assignment1.iterator.Iterator#hasNext()   
	 */
	@Override
	public boolean hasNext() {
		if(posittion < hotPotMenus.length && hotPotMenus[posittion] != null) {
			return true;
		}
		return false;
	}

	/**   
	 * <p>Title: next</p> 
	 * @date: 2021-05-26 17:50    
	 * @return   
	 * @see club.xiaoandx.experiment6.assignment1.iterator.Iterator#next()   
	 */
	@Override
	public Object next() {
		return hotPotMenus[posittion++];
	}

}
