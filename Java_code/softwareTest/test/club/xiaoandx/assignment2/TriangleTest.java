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
package club.xiaoandx.assignment2;

import static org.junit.Assert.*;

import org.junit.Test;

/**  
 * <p> 三角形判断单元测试用例集合 </p> 
 * @ClassName:TriangleTest   
 * @author: WEI.ZHOU
 * @date: 2021-05-14 08:49
 * @since: JDK1.8
 * @version V1.0.0
 */
public class TriangleTest {
	
	/**
	 * 断言结果允许误差
	 */
	private static final double DELTA = 0.01;
	
	@Test
	public void coverTest1() {
		int number = Triangle.createrTriangle(1, 2, 3);
		int rust = 0;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void coverTest2() {
		int number = Triangle.createrTriangle(2, 2, 3);
		int rust = 2;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void coverTest3() {
		int number = Triangle.createrTriangle(3, 4, 5);
		int rust = 1;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void coverTest4() {
		int number = Triangle.createrTriangle(2, 2, 2);
		int rust = 3;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void judgeTest1() {
		int number = Triangle.createrTriangle(1, 1, 3);
		int rust = 0;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void judgeTest2() {
		int number = Triangle.createrTriangle(3, 1, 1);
		int rust = 0;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void judgeTest3() {
		int number = Triangle.createrTriangle(1, 3, 1);
		int rust = 0;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void judgeTest4() {
		int number = Triangle.createrTriangle(3, 3, 4);
		int rust = 2;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void judgeTest5() {
		int number = Triangle.createrTriangle(3, 4, 3);
		int rust = 2;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void judgeTest6() {
		int number = Triangle.createrTriangle(4, 3, 3);
		int rust = 2;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void judgeTest7() {
		int number = Triangle.createrTriangle(2, 3, 4);
		int rust = 1;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void judgeTest8() {
		int number = Triangle.createrTriangle(3, 3, 3);
		int rust = 3;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void conditionTest1() {
		int number = Triangle.createrTriangle(1, 6, 7);
		int rust = 0;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void conditionTest2() {
		int number = Triangle.createrTriangle(2, 6, 4);
		int rust = 0;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void conditionTest3() {
		int number = Triangle.createrTriangle(7, 2, 4);
		int rust = 0;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void conditionTest4() {
		int number = Triangle.createrTriangle(4, 3, 4);
		int rust = 2;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void conditionTest5() {
		int number = Triangle.createrTriangle(3, 4, 4);
		int rust = 2;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void conditionTest6() {
		int number = Triangle.createrTriangle(4, 4, 3);
		int rust = 2;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void conditionTest7() {
		int number = Triangle.createrTriangle(4, 4, 4);
		int rust = 3;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void conditionTest8() {
		int number = Triangle.createrTriangle(4, 3, 5);
		int rust = 1;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void conditionTudgeTest1() {
		int number = Triangle.createrTriangle(1, 6, 8);
		int rust = 0;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void conditionTudgeTest2() {
		int number = Triangle.createrTriangle(2, 6, 3);
		int rust = 0;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void conditionTudgeTest3() {
		int number = Triangle.createrTriangle(8, 2, 4);
		int rust = 0;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void conditionTudgeTest4() {
		int number = Triangle.createrTriangle(5, 3, 5);
		int rust = 2;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void conditionTudgeTest5() {
		int number = Triangle.createrTriangle(3, 5, 5);
		int rust = 2;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void conditionTudgeTest6() {
		int number = Triangle.createrTriangle(5, 5, 3);
		int rust = 2;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void conditionTudgeTest7() {
		int number = Triangle.createrTriangle(5, 5, 5);
		int rust = 3;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void conditionTudgeTest8() {
		int number = Triangle.createrTriangle(4, 3, 5);
		int rust = 1;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void conditionalCombinationTest1() {
		int number = Triangle.createrTriangle(3, 4, 7);
		int rust = 0;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void conditionalCombinationTest2() {
		int number = Triangle.createrTriangle(3, 7, 4);
		int rust = 0;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void conditionalCombinationTest3() {
		int number = Triangle.createrTriangle(7, 1, 5);
		int rust = 0;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void conditionalCombinationTest4() {
		int number = Triangle.createrTriangle(6, 5, 6);
		int rust = 2;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void conditionalCombinationTest5() {
		int number = Triangle.createrTriangle(5, 6, 6);
		int rust = 2;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void conditionalCombinationTest6() {
		int number = Triangle.createrTriangle(6, 6, 5);
		int rust = 2;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void conditionalCombinationTest7() {
		int number = Triangle.createrTriangle(5, 5, 5);
		int rust = 3;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void conditionalCombinationTest8() {
		int number = Triangle.createrTriangle(4, 3, 5);
		int rust = 1;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void routeTest1() {
		int number = Triangle.createrTriangle(1, 6, 7);
		int rust = 0;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void routeTest2() {
		int number = Triangle.createrTriangle(7, 1, 6);
		int rust = 0;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void routeTest3() {
		int number = Triangle.createrTriangle(1, 7, 6);
		int rust = 0;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void routeTest4() {
		int number = Triangle.createrTriangle(6, 6, 6);
		int rust = 3;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void routeTest5() {
		int number = Triangle.createrTriangle(6, 6, 5);
		int rust = 2;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void routeTest6() {
		int number = Triangle.createrTriangle(5, 6, 6);
		int rust = 2;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void routeTest7() {
		int number = Triangle.createrTriangle(6, 5, 6);
		int rust = 2;
		assertEquals(number, rust, DELTA);
	}
	
	@Test
	public void routeTest8() {
		int number = Triangle.createrTriangle(3, 5, 4);
		int rust = 1;
		assertEquals(number, rust, DELTA);
	}
}
