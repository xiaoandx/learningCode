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

/**  
 * <p> 泛型学习 </p>
 * 泛型类
 * 泛型接口
 * 泛型方法  √
 * <T> <T, E> 代表可以定义多个泛型类型变量
 * @ClassName:Example1   
 * @author: WEI.ZHOU
 * @date: 2021-03-24 20:13
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
public class Example3 {
	public static void main(String[] args) {
		// 使用泛型方法  直接传入具体类型的泛型
		add(1, 2);
	}
	
	/**
	 * 
	 * <p> 泛型方式的定义 </p></br>
	 *
	 * <pre> 泛型方法定义格式：在方法返回值前面 定义泛型与个数，然后再方法形参中进行使用 </pre></br>

	 * @Title: add   
	 * @Description:    
	 * @date: 2021-03-24 20:34
	 * @param t
	 * @param e void    
	 * @since: 1.0.0   
	 * @throws
	 */
	public static <T, E> void add(T t, E e) {
		System.out.println(t+"+"+e+"= "+t+e);
	}
}

