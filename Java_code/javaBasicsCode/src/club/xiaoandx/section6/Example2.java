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
 * 泛型接口 √
 * 泛型方法 
 * <T> <T, E> 代表可以定义多个泛型类型变量
 * @ClassName:Example1   
 * @author: WEI.ZHOU
 * @date: 2021-03-24 20:13
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
public class Example2 {
	public static void main(String[] args) {
		GenericInterfaceImp gi = new GenericInterfaceImp();
		gi.test("1");
		gi.test1("2");
	}
}

/**
 * 
 * <p> 泛型接口定义 </p> 
 *	泛型接口定义格式：泛型定义放在接口名 后面
 * @ClassName:GenericInterface   
 * @author: WEI.ZHOU
 * @date: 2021-03-24 20:25
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
 interface GenericInterface<T, E>{
	 
	 public abstract void test(T t);
	 
	 public abstract void test1(E e);
 }
 
 /**
  * 
  * <p> 实现泛型接口 </p> 
  *	实现需要指定泛型具体使用类型，不指定默认 Object
  * @ClassName:GenericInterfaceImp   
  * @author: WEI.ZHOU
  * @date: 2021-03-24 20:29
  * @since: JDK1.8
  * @version V1.0
  * @Copyright: Note: This prohibition leaks and for other commercial projects
  */
 class GenericInterfaceImp implements GenericInterface<String, String>{

	@Override
	public void test(String t) {
		System.out.println(t);
	}

	@Override
	public void test1(String e) {
		System.out.println(e);
	}
	 
 }
