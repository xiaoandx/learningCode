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
 * <p> User实体 </p> 
 *
 * @ClassName:User   
 * @author: WEI.ZHOU
 * @date: 2021-03-31 11:01
 * @since: JDK1.8
 * @version V1.0.0
 */
public class User {
	private String id;
	private String userName;
	private boolean sex;
	private int age;
	private String password;
	private String remind;
	
	/**   
	 * <p> 初始用户并将用户密码设置为123456 </p></br>
	 * @Title:  User   
	 * @date: 2021-03-31 11:20 
	 * @since: 1.0.0
	 */
	public User() {
		this.setPassword("123456");
	}

	/**
	 * @Title:  getId <BR>  
	 * @Description: GET方法 <BR>
	 * @return: String <BR>  
	 * @return: id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @Title:  setId <BR>  
	 * @Description: 属性的SET方法 <BR>  
	 * @return: String <BR> 
	 * @param: id 要设置的 id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @Title:  getUserName <BR>  
	 * @Description: GET方法 <BR>
	 * @return: String <BR>  
	 * @return: userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @Title:  setUserName <BR>  
	 * @Description: 属性的SET方法 <BR>  
	 * @return: String <BR> 
	 * @param: userName 要设置的 userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @Title:  isSex <BR>  
	 * @Description: GET方法 <BR>
	 * @return: boolean <BR>  
	 * @return: sex
	 */
	public boolean isSex() {
		return sex;
	}

	/**
	 * @Title:  setSex <BR>  
	 * @Description: 属性的SET方法 <BR>  
	 * @return: boolean <BR> 
	 * @param: sex 要设置的 sex
	 */
	public void setSex(boolean sex) {
		this.sex = sex;
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
	 * @Title:  getRemind <BR>  
	 * @Description: GET方法 <BR>
	 * @return: String <BR>  
	 * @return: remind
	 */
	public String getRemind() {
		return remind;
	}

	/**
	 * @Title:  setRemind <BR>  
	 * @Description: 属性的SET方法 <BR>  
	 * @return: String <BR> 
	 * @param: remind 要设置的 remind
	 */
	public void setRemind(String remind) {
		this.remind = remind;
	}

	/**
	 * @Title:  getPassword <BR>  
	 * @Description: GET方法 <BR>
	 * @return: String <BR>  
	 * @return: password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @Title:  setPassword <BR>  
	 * @Description: 属性的SET方法 <BR>  
	 * @return: String <BR> 
	 * @param: password 要设置的 password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * <p> 用户登录操作 </p></br>
	 * @Title: userLogin  
	 * @date: 2021-03-31 11:32
	 * @param loginUaerName	用户名
	 * @param password		用户密码
	 * @return boolean  	登录状态  
	 * @since: 1.0.0   
	 */
	public boolean userLogin(String loginUaerName, String password) {
		if(loginUaerName == "admin" && password == "admin") {
			return true;
		}
		return false;
	}
	
	/**
	 * <p> 修改密码 </p></br>
	 * @Title: changePassword  
	 * @date: 2021-03-31 11:33
	 * @param newPassword	修改的新密码
	 * @return boolean   	修改状态 
	 * @since: 1.0.0   
	 */
	public boolean changePassword(String newPassword) {
		this.setPassword(newPassword);
		return true;
	}

	/**   
	 * <p> user信息输出 </p></br>
	 * <p>Title: toString</p> 
	 * @date: 2021-03-31 11:26    
	 * @see java.lang.Object#toString()   
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", sex=" + sex + ", age=" + age + ", remind=" + remind
				+ "]";
	}

	
}
