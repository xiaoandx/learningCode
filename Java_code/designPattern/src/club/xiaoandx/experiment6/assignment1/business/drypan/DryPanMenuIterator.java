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

import java.util.Map;
import java.util.Map.Entry;

import club.xiaoandx.experiment6.assignment1.business.MenuItem;
import club.xiaoandx.experiment6.assignment1.iterator.Iterator;

/**  
 * <p> 干锅菜单迭代器 </p> 
 * @ClassName:DryPanMenuIterator   
 * @author: WEI.ZHOU
 * @date: 2021-05-26 18:01
 * @since: JDK1.8
 * @version V1.0.0
 */
public class DryPanMenuIterator implements Iterator {
	
	Map<String, MenuItem> dryPanMenus;
	
	java.util.Iterator<Map.Entry<String, MenuItem>> it ;
	
	@SuppressWarnings("rawtypes")
	Map.Entry entry;
	
	/**   
	 * @Title:  DryPanMenuIterator   
	 * @date: 2021-05-26 18:01 
	 * @since: 1.0.0
	 */
	public DryPanMenuIterator(Map<String, MenuItem> dryPanMenus) {
		this.dryPanMenus = dryPanMenus;
		it = (java.util.Iterator<Entry<String, MenuItem>>) dryPanMenus.entrySet().iterator();
	}
	
	/**   
	 * <p>Title: hasNext</p> 
	 * @date: 2021-05-26 18:01    
	 * @return   
	 * @see club.xiaoandx.experiment6.assignment1.iterator.Iterator#hasNext()   
	 */
	@Override
	public boolean hasNext() {
		return it.hasNext();
	}

	/**   
	 * <p>Title: next</p> 
	 * @date: 2021-05-26 18:01    
	 * @return   
	 * @see club.xiaoandx.experiment6.assignment1.iterator.Iterator#next()   
	 */
	@Override
	public Object next() {
		Map.Entry<String, MenuItem> entry = it.next();
		return entry.getValue();
	}

}
