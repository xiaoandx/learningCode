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
package club.xiaoandx.section6;

import java.util.ArrayList;

/**  
 * <p> 泛型学习 </p>
 * 泛型类
 * 泛型接口
 * 泛型方法  
 * 泛型通配符 √
 * <T> <T, E> 代表可以定义多个泛型类型变量
 * @ClassName:Example1   
 * @author: WEI.ZHOU
 * @date: 2021-03-24 20:13
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
public class Example4 {
	public static void main(String[] args) {
		ArrayList<Prosen> list1 = new ArrayList<Prosen>();
		ArrayList<Student> list2 = new ArrayList<Student>();
		ArrayList<Object> list3 = new ArrayList<Object>();
		forPri(list1);
		forPri(list2);
		forPri(list3);
		
		// 向下匹配包括天花板本身
		forPriEx(list2);
		forPriEx(list1);
		
		// 向上匹配包括 地板本身
		forPriSuper(list1);
		forPriSuper(list3);
		
	}
	
	/**
	 * <p> ? 类型通配符  无限制 </p></br>
	 * @Title: forPri   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @date: 2021-03-24 20:42
	 * @param list void    
	 * @since: 1.0.0   
	 * @throws
	 */
	public static void forPri(ArrayList<?> list) {
		for (Object object : list) {
			System.out.println(object);
		}
	}
	
	/**
	 * 
	 * <p> <? extends Prosen> 向下匹配  Prosen为天花板</p></br>
	 * @Title: forPriEx   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @date: 2021-03-24 20:43
	 * @param list void    
	 * @since: 1.0.0   
	 * @throws
	 */
	public static void forPriEx(ArrayList<? extends Prosen> list) {
		for (Object object : list) {
			System.out.println(object);
		}
	}
	
	/**
	 * 
	 * <p> <? super Prosen> 向上匹配   Prosen为地板 </p></br>
	 * @Title: forPriSuper   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @date: 2021-03-24 20:45
	 * @param list void    
	 * @since: 1.0.0   
	 * @throws
	 */
	public static void forPriSuper(ArrayList<? super Prosen> list) {
		for (Object object : list) {
			System.out.println(object);
		}
	}
}




class Prosen{
	void pri() {
		
	}
}

class Student extends Prosen{
	
}

