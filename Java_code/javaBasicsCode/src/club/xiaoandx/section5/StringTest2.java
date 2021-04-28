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
package club.xiaoandx.section5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

/**  
 * <p> 随机产生一个字符串，统计个字符的个数 </p> 
 *
 * @ClassName:StringTest2  
 * @author: WEI.ZHOU
 * @date: 2021-04-28 10:39
 * @since: JDK1.8
 * @version V1.0.0
 */
public class StringTest2 {
	
	public static void main(String[] args) {
		String randomString = getRandomString(10);
		System.out.println("随机生成的字符串：" + randomString);
		Map<String, Integer> searchCharCount = searchFileCharCount(randomString);
		
		for (Entry<String, Integer> entry : searchCharCount.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + "字符出现的次数：" + value);
		}

	}
	
	
	/**
	 * <p> 随机生成指定长度的字符串（包含大小写字母，数字或者符号） </p></br>
	 * @Title: getRandomString  
	 * @date: 2021-04-28 10:45
	 * @param length	需要生成随机字符的长度
	 * @return String   生成的随机字符
	 * @since: 1.0.0   
	 */
	public static String getRandomString(int length) {
		String str = "abcdefghijklmnopqrstuvwxyz"
				+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "0123456789"
				+ "<>,.?/;[]{}|+=_-)(*&^%$#@!~";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(str.length());
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}
	
	/**
	 * <p> 判断字符中每个字符出现数量 </p></br>
	 * @Title: searchFileCharCount  
	 * @date: 2021-04-28 10:53
	 * @param str		需要判断字符串
	 * @return Map<String,Integer>    统计Map；kay表示单个字符，value为该字符的数量
	 * @since: 1.0.0   
	 */
	public static Map<String, Integer> searchFileCharCount(String str){
		int strLen = str.length();
		Map<String, Integer> strMap = new HashMap<String, Integer>();
		Set<String> cSet = new HashSet<String>();
		for (int i = 0; i < strLen; i++) {
			cSet.add(String.valueOf(str.charAt(i)));
		}
		for (String s : cSet) {
			int count = 0;
			for (int i = 0; i < strLen; i++) {
				if (s.equals(String.valueOf(str.charAt(i)))) {
					count++;
				}
			}
			strMap.put(s, count);
		}
		return strMap;
	}
}
