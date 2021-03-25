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
package club.xiaoandx.experiment3.test2;

/**  
 * <p> 任务一 </p> 
 *	2. P41页第4小题
 * @ClassName:Questions1   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 16:20
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Questions1 {
	public static void main(String[] args) {
		/*
		 * Test:
		 * 	1. 通过女娲创建工厂创建自定义的人类类型
		 * 	2. 创建成功后就进行自我介绍
		 */
		Person person = SimpleNvwaFactory.getPerson("w");
		person.speak();
	}
}

/**
 * <p> 女娲造人的类型抽象类 </p>
 * 常见类型：Man、Woman、Robot .... 
 * @ClassName:Person   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 16:53
 * @since: JDK1.8
 * @version V1.0.0
 */
abstract class Person{
	
	/**
	 * <p> 创建的人进行自我介绍抽象方法</p></br>
	 * @Title: speak  
	 * @date: 2021-03-25 16:54 void    
	 * @since: 1.0.0   
	 */
	public abstract void speak();
}

/**
 * <p> 男人实现女娲造人抽象类，得到一个Man类 </p> 
 * @ClassName:Man   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 16:55
 * @since: JDK1.8
 * @version V1.0.0
 */
class Man extends Person{

	/**   
	 * <p> 实现具体自我介绍方法 </p></br>
	 * <p>Title: speak</p> 
	 * @date: 2021-03-25 16:44       
	 * @see club.xiaoandx.experiment3.test2.Person#speak()   
	 */
	@Override
	public void speak() {
		System.out.println("成功创造一个Man，我是一个男人");
	}
}

/**
 * <p> 女人 实现女娲造人抽象类，得到一个女人 </p> 
 * @ClassName:Woman   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 16:56
 * @since: JDK1.8
 * @version V1.0.0
 */
class Woman extends Person{

	/**   
	 * <p> 实现具体自我介绍方法 </p></br>
	 * <p>Title: speak</p> 
	 * @date: 2021-03-25 16:46       
	 * @see club.xiaoandx.experiment3.test2.Person#speak()   
	 */
	@Override
	public void speak() {
		System.out.println("成功创建一个Woman，我是一个女人");
	}
}

/**
 * <p> 机器人 实现女娲造人抽象类，得到一个机器人  </p> 
 * @ClassName:Robot   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 16:57
 * @since: JDK1.8
 * @version V1.0.0
 */
class Robot extends Person{
	/**   
	 * <p> 实现具体自我介绍方法 </p></br>
	 * <p>Title: speak</p> 
	 * @date: 2021-03-25 16:47       
	 * @see club.xiaoandx.experiment3.test2.Person#speak()   
	 */
	@Override
	public void speak() {
		System.out.println("成功创建一个Robot，我是一个机器人");
	}
}

/**
 * <p> 女娲造人工厂类 </p> 
 * @ClassName:SimpleNvwaFactory   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 16:58
 * @since: JDK1.8
 * @version V1.0.0
 */
class SimpleNvwaFactory{
	
	/**
	 * <p> 工厂造人具体实现方法	</p></br>
	 * 1. 通过向getPerson()传入指定的type 就会得到指定类型的人 </br>
	 * 		eg: getPerson("W") 回得到一个女人对象
	 * @Title: getPerson  
	 * @date: 2021-03-25 16:58
	 * @param type		创建人类型(eg:M->man, W->woman, R->robor)
	 * @return Person  	具体对象  
	 * @since: 1.0.0   
	 */
	public static Person getPerson(String type) {
		Person person = null;
		if(type.equalsIgnoreCase("M")) {
			person = new Man();
		}
		if(type.equalsIgnoreCase("W")) {
			person = new Woman();
		}
		if(type.equalsIgnoreCase("R")) {
			person = new Robot();
		}
		return person;
	}
}
