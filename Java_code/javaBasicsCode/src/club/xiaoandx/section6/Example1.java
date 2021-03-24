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
 * 泛型类 √
 * 泛型接口
 * 泛型方法 
 * @ClassName:Example1   
 * @author: WEI.ZHOU
 * @date: 2021-03-24 20:13
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
public class Example1 {
	public static void main(String[] args) {
		GenericClass<String> g = new GenericClass<String>();
		g.setT("你好");
		String t = g.getT();
		System.out.println(t);
	}
}

/**
 * 
 * <p> 泛型类的定义 </p> 
 *	定义语法：泛型类型放在类名的后面
 * @ClassName:GenericClass   
 * @author: WEI.ZHOU
 * @date: 2021-03-24 20:21
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
class GenericClass<T>{
	
	T t;

	/**
	 * @Title:  getT <BR>  
	 * @Description: GET方法 <BR>
	 * @return: T <BR>  
	 * @return: t
	 */
	public T getT() {
		return t;
	}

	/**
	 * @Title:  setT <BR>  
	 * @Description: 属性的SET方法 <BR>  
	 * @return: T <BR> 
	 * @param: t 要设置的 t
	 */
	public void setT(T t) {
		this.t = t;
	}
	
}
