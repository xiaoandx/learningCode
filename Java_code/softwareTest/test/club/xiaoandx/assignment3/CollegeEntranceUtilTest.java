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
	public void coverTest1() {
		boolean registrationResults = CollegeEntranceUtil.registrationJudgment("2004-06");
		boolean rust = false;
		assertEquals(registrationResults, rust);
	}

}
