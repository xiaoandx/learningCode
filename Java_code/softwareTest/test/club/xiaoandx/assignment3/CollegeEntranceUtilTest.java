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
package club.xiaoandx.assignment3;

import static org.junit.Assert.*;

import org.junit.Test;

/**  
 * <p> 高考报名判断 测试用例 </p> 
 * @ClassName:CollegeEntranceUtilTest   
 * @author: WEI.ZHOU
 * @date: 2021-05-17 11:47
 * @since: JDK1.8
 * @version V1.0.0
 */
public class CollegeEntranceUtilTest {
	
	@Test
	public void equivalenceTest01() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("2000-01");
		boolean rust = true;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void equivalenceTest02() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("1996-12");
		boolean rust = true;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void notEquivalenceTest01() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("1995-12");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void notEquivalenceTest02() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("2006-01");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void notEquivalenceTest03() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("2000-00");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void notEquivalenceTest04() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("2000-13");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void notEquivalenceTest05() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("1996-00");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void notEquivalenceTest06() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("2005-13");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void notEquivalenceTest07() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("200a-0a");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void notEquivalenceTest08() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("-2001-2");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void notEquivalenceTest09() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("199812");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void notEquivalenceTest10() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("200-12");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void notEquivalenceTest11() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("2000-2");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void boundaryValueTest01() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("5");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void boundaryValueTest02() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("96");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void boundaryValueTest03() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("200");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void boundaryValueTest04() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("2000");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void boundaryValueTest05() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("2000-1");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void boundaryValueTest06() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("2000-12");
		boolean rust = true;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void boundaryValueTest07() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("2010");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void boundaryValueTest08() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("1992");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}

	@Test
	public void boundaryValueTest09() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("-1");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void boundaryValueTest10() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("2000-10");
		boolean rust = true;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void boundaryValueTest11() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("2000-13");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void boundaryValueTest12() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("2000-00");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void boundaryValueTest13() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("1996-05");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void boundaryValueTest14() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("2005-09");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void errorValueTest01() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("0000-00");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void errorValueTest02() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void errorValueTest03() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("12-2000");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void errorValueTest04() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("200-012");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}
	
	@Test
	public void errorValueTest05() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("-200012");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}
}
