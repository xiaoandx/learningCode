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
package club.xiaoandx.section3.entity;

/**  
 * <p> 学生实体类 </p> 
 *
 * @ClassName:Student   
 * @author: WEI.ZHOU
 * @date: 2021-03-31 10:22
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Student {
	private String name;
	private int age;
	private String sex;
	
	
	/**   
	 * <p> </p></br>
	 * @Title:  Student   
	 * @date: 2021-03-31 10:53 
	 * @since: 1.0.0
	 */
	public Student() { super(); }

	/**
	 * <p> 初始化构造函数 </p></br>
	 * @Title:  Student   
	 * @date: 2021-03-31 10:52
	 * @param name
	 * @param age
	 * @param sex 
	 * @since: 1.0.0 
	 */
	public Student(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	// 展示方法
	public void show() {
		System.out.println(name + "是新时代的人才，祖国的花朵，今年" + age + "岁，性别：" + sex);
	}
	
	/**
	 * @Title:  getName <BR>  
	 * @Description: GET方法 <BR>
	 * @return: String <BR>  
	 * @return: name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @Title:  setName <BR>  
	 * @Description: 属性的SET方法 <BR>  
	 * @return: String <BR> 
	 * @param: name 要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @Title:  getAge <BR>  
	 * @Description: GET方法 <BR>
	 * @return: int <BR>  
	 * @return: age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * @Title:  setAge <BR>  
	 * @Description: 属性的SET方法 <BR>  
	 * @return: int <BR> 
	 * @param: age 要设置的 age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * @Title:  getSex <BR>  
	 * @Description: GET方法 <BR>
	 * @return: String <BR>  
	 * @return: sex
	 */
	public String getSex() {
		return sex;
	}
	
	/**
	 * @Title:  setSex <BR>  
	 * @Description: 属性的SET方法 <BR>  
	 * @return: String <BR> 
	 * @param: sex 要设置的 sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	/**   
	 * <p> 重新toString方法 </p></br>
	 * <p>Title: toString</p> 
	 * @date: 2021-03-31 10:24    
	 * @see java.lang.Object#toString()   
	 */
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
	
}
