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
package club.xiaoandx.experiment6.assignment1.iterator;

/**  
 * <p> 自定义菜单系统迭代器 </p> 
 * @ClassName:Iterator   
 * @author: WEI.ZHOU
 * @date: 2021-05-26 16:50
 * @since: JDK1.8
 * @version V1.0.0
 */
public interface Iterator {
	
	/**
	 * <p> 判断当前元素是否存在 </p></br>
	 * @Title: hasNext  
	 * @date: 2021-05-26 16:52
	 * @return boolean		有元素 true；没有元素false  
	 * @since: 1.0.0   
	 */
	boolean hasNext();
	
	/**
	 * <p> 获取当前存在的元素，将元素指针指向下一个 </p></br>
	 * @Title: next  
	 * @date: 2021-05-26 16:53
	 * @return Object    	当前元素
	 * @since: 1.0.0   
	 */
	Object next();
}
