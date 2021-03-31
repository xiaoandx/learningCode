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
package club.xiaoandx.section3;

import club.xiaoandx.section3.entity.User;

/**  
 * <p> 用户实体测试 </p> 
 * @ClassName:TestUser   
 * @author: WEI.ZHOU
 * @date: 2021-03-31 11:27
 * @since: JDK1.8
 * @version V1.0.0
 */
public class TestUser {
	public static void main(String[] args) {
		User u = new User();
		u.setId("001");
		u.setUserName("admin");
		u.setAge(22);
		u.setSex(true);
		u.setRemind("开启通知");
		u.changePassword("admin");
		boolean loginStatue = u.userLogin(u.getUserName(), "admin");
		System.out.println(loginStatue);
		System.out.println(u.toString());
	}
}
