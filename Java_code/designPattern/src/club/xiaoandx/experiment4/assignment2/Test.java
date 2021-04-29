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
package club.xiaoandx.experiment4.assignment2;

import club.xiaoandx.experiment4.assignment2.facade.GraduateProceduresFacade;

/**  
 * <p> 毕业生办理毕业手续，通过代理进行办理测试  </p> 
 * @ClassName:Test   
 * @author: WEI.ZHOU
 * @date: 2021-04-29 13:27
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Test {
	public static void main(String[] args) {
		/*
		 * Test: 毕业生办理毕业手续，通过代理进行办理测试
		 * 0. 创建一个大学毕业生对象(学生证、身份证、饭卡、借书证 手续齐全)
		 * 1. 先获得毕业生手续代办Facade对象
		 * 2. 代办中心直接进行办理
		 * 3. 查看办理结果
		 */
		Graduates goodStudent = new Graduates();
		goodStudent.setStudentID("10010");
		goodStudent.setFoodCardID("20121010");
		goodStudent.setLibraryCard("289883921");
		goodStudent.setIdentityCard("511322190812342345");
		
		GraduateProceduresFacade facade = new GraduateProceduresFacade();
		facade.transaction(goodStudent);
		
		System.out.println(goodStudent);
		
		/**
		 * 错误测试
		 */
		Graduates errorStudent = new Graduates();
		errorStudent.setStudentID("");
		errorStudent.setFoodCardID("");
		errorStudent.setLibraryCard("");
		errorStudent.setIdentityCard("511322190812342345");
		
		GraduateProceduresFacade errorFacade = new GraduateProceduresFacade();
		errorFacade.transaction(errorStudent);
		
		System.out.println(errorStudent);
	}
}
