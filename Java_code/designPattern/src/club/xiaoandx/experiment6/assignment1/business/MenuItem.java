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
package club.xiaoandx.experiment6.assignment1.business;

/**  
 * <p> 商家菜单中的菜单项基类 </p> 
 * @ClassName:MenuItem   
 * @author: WEI.ZHOU
 * @date: 2021-05-26 16:44
 * @since: JDK1.8
 * @version V1.0.0
 */
public class MenuItem {
	private String name;
	private String description;
	private double price;

	public MenuItem(String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

	/**
	 * @Title:  getName </br>  
	 * @Description: GET方法 </br>
	 * @return: String </br>  
	 * @return: name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @Title:  setName </br>  
	 * @Description: 属性的SET方法 </br>  
	 * @return: String </br> 
	 * @param: name 要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @Title:  getDescription </br>  
	 * @Description: GET方法 </br>
	 * @return: String </br>  
	 * @return: description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @Title:  setDescription </br>  
	 * @Description: 属性的SET方法 </br>  
	 * @return: String </br> 
	 * @param: description 要设置的 description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @Title:  getPrice </br>  
	 * @Description: GET方法 </br>
	 * @return: double </br>  
	 * @return: price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @Title:  setPrice </br>  
	 * @Description: 属性的SET方法 </br>  
	 * @return: double </br> 
	 * @param: price 要设置的 price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
}

