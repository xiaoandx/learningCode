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

import club.xiaoandx.section3.entity.Student;

/**  
 * <p> 测试学生实体类 </p> 
 * @ClassName:TestStudent   
 * @author: WEI.ZHOU
 * @date: 2021-03-31 10:27
 * @since: JDK1.8
 * @version V1.0.0
 */
public class TestStudent {
	public static void main(String[] args) {
		Student student = new Student();
		student.setName("周巍");
		student.setAge(22);
		student.setSex("男");
		student.show();
		
		Student student2 = new Student("周巍2", 22, "男");
		student2.show();
	}
}
