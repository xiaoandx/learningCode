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

import java.util.Calendar;

/**  
 * <p> 高考报名判断工具类 - 直接调用 registrationJudgment("2001-04") 进行判断</p> 
 * @ClassName:CollegeEntranceUtil  
 * @author: WEI.ZHOU
 * @date: 2021-05-17 10:55
 * @since: JDK1.8
 * @version V1.0.2
 */
public class CollegeEntranceUtil {
	
	/**
	 * 高考报名出身年份最小要求
	 */
	private static final int REQUIRED_MIX_YEAR = 2005; 
	
	/**
	 * 高考报名出身月份最小要求
	 */
	private static final int REQUIRED_MIX_MONTH = 7; 
	
	/**
	 * 高考报名出身年份最大要求
	 */
	private static final int REQUIRED_MAX_YEAR = 1996; 
	
	/**
	 * 高考报名出身月份最大要求
	 */
	private static final int REQUIRED_MAX_MONTH = 6; 
	
	/**
	 * 高考报名年龄最大要求
	 */
	private static final int REQUIRED_MAX_AGE = 25; 
	
	/**
	 * 高考报名年龄最小要求
	 */
	private static final int REQUIRED_MIX_AGE = 16; 
	
	/**
	 * <p> 高考报名系统 </p></br>
	 * <pre> 进行高考报名需要传入报名学生的出身年月（格式：2020-04） ，系统会进行报名要求的认定</pre></br>
	 * @Title: registrationJudgment  
	 * @date: 2021-05-17 11:38
	 * @param birthTimeString	学生出身年月（格式：2020-04）
	 * @return boolean    		true 符合要求，报名成功； flase 不符合要求，报名失败
	 * @since: 1.0.2   
	 */
	public static boolean registrationJudgment(String birthTimeString) {
		if (judgeInputAge(birthTimeString) && judgeOrigin(birthTimeString)) {
			int age = getAgeFromBirthTime(birthTimeString);
			if (age >= REQUIRED_MIX_AGE && age <= REQUIRED_MAX_AGE) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <p> 根据年月计算年龄   </p></br>
	 * @Title: getAgeFromBirthTime  
	 * @date: 2021-05-17 11:00
	 * @param birthTimeString	出身的的日期，格式为：2020-05
	 * @return int		年龄
	 * @since: 1.0.2
	 */
	private static int getAgeFromBirthTime(String birthTimeString) {
		int[] yearMonth = getYearMonth(birthTimeString);
		Calendar cal = Calendar.getInstance();
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int yearMinus = yearNow - yearMonth[0];
		int monthMinus = monthNow - yearMonth[1];
		return calculateAge(yearMinus, monthMinus);
	}
	
	/**
	 * <p> 判断高考报名的日期符合要求范围 </p></br>
	 * <pre> 出身年月 要求：1996年7月至2005年6月  </pre></br>
	 * @Title: judgeOrigin  
	 * @date: 2021-05-17 12:51
	 * @param birthTimeString	出身的的日期
	 * @return boolean   		出身年月是否满足要求；true 满足。false 不满足     
	 * @since: 1.0.2
	 */
	private static boolean judgeOrigin(String birthTimeString) {
		int[] yearMonth = getYearMonth(birthTimeString);
		int selectYear = yearMonth[0];
		int selectMonth = yearMonth[1];
		if (selectYear > REQUIRED_MAX_YEAR && selectYear < REQUIRED_MIX_YEAR) {
			if (selectMonth >= 1 && selectMonth <= 12) {
				return true;
			}
			return false;
		} else if (selectYear == REQUIRED_MAX_YEAR) {
			if (selectMonth >= REQUIRED_MIX_MONTH && selectMonth <= 12) {
				return true;
			}
		} else if (selectYear == REQUIRED_MIX_YEAR) {
			if (selectMonth <= REQUIRED_MAX_MONTH && selectMonth >=1) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * <p> 获取用户的出身年 月 </p></br>
	 * @Title: getYearMonth  
	 * @date: 2021-05-17 11:12
	 * @param birthTimeString
	 * @return int[]   [0] -> Year ; [1] -> Month
	 * @since: 1.0.2   
	 */
	private static int[] getYearMonth(String birthTimeString) {
		String strs[] = birthTimeString.trim().split("-");
		int selectRust[] = {Integer.parseInt(strs[0]), Integer.parseInt(strs[1])};
		return selectRust;
	}
	

	/**
	 * <p> 获取报名学生的当前年龄 </p></br>
	 * @Title: calculateAge  
	 * @date: 2021-05-17 13:03
	 * @param yearMinus		出身年份与当前年份的差值
	 * @param monthMinus	出身月份与当前月份的差值
	 * @return int   		年龄 
	 * @since: 1.0.0   
	 */
	private static int calculateAge(int yearMinus, int monthMinus) {
		int age = yearMinus;
		if (yearMinus < 0) {
			age = 0;
		} else if (yearMinus == 0) {
			if (monthMinus < 0) {
				age = 0;
			} else if (monthMinus == 0) {
				age = 1;
			} else if (monthMinus > 0) {
				age = 1;
			}
		} else if (yearMinus > 0) {
			if (monthMinus < 0) {
			} else if (monthMinus == 0) {
				age = age + 1;
			} else if (monthMinus > 0) {
				age = age + 1;
			}
		}
		return age;
	}
	
	/**
	 * <p> 判断输入年龄是否满足格式 </p></br>
	 * <pre> 判断将从 长度==7、是否为空、是否包含‘-’、数字是否为6位、‘-’是否在第4位置索引 </pre></br>
	 * @Title: judgeInputAge  
	 * @date: 2021-05-17 13:23
	 * @param birthTimeString	输入年龄字符
	 * @return boolean    		格式判断状态；true 满足   ，  false 不满足
	 * @since: 1.0.0   
	 */
	private static boolean judgeInputAge(String birthTimeString) {
		int strLength = birthTimeString.length();
		if (birthTimeString.isEmpty() && strLength != 7
				&& !birthTimeString.contains("-")) {
			return false;
		}

		int number = 0;
		for (int i = 0; i < strLength; i++) {
			if (birthTimeString.charAt(i) >= 48 && birthTimeString.charAt(i) <= 57) {
				++number;
			}
		}
		if (number != 6 || (birthTimeString.indexOf("-")) != 4) {
			return false;
		}
		return true;
	}
}
