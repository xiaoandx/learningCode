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

import java.util.List;

import club.xiaoandx.experiment6.assignment1.business.MenuItem;
import club.xiaoandx.experiment6.assignment1.iterator.Iterator;

/**  
 * <p> 餐馆迭代器 </p> 
 * @ClassName:DinerMenuIterator   
 * @author: WEI.ZHOU
 * @date: 2021-05-26 17:17
 * @since: JDK1.8
 * @version V1.0.0
 */
public class DinerMenuIterator implements Iterator {
	
	List<MenuItem> dinerMenus;
	
	int posittion = 0;
	
	/**   
	 * @Title:  DinerMenuIterator   
	 * @date: 2021-05-26 17:17 
	 * @since: 1.0.0
	 */
	public DinerMenuIterator(List<MenuItem> dinerMenus) {
		this.dinerMenus = dinerMenus;
	}

	/**   
	 * <p>Title: hasNext</p> 
	 * @date: 2021-05-26 17:17    
	 * @return   
	 * @see club.xiaoandx.experiment6.assignment1.iterator.Iterator#hasNext()   
	 */
	@Override
	public boolean hasNext() {
		if (dinerMenus.size() != 0 && posittion < dinerMenus.size()
				&& dinerMenus.get(posittion) != null) {
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
		return dinerMenus.get(posittion++);
	}

}
