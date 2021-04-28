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

import java.util.ArrayList;
import java.util.List;

/**  
 * <p> 输出10000内的所有回文素数 </p> 
 * @ClassName:StringTest3   
 * @author: WEI.ZHOU
 * @date: 2021-04-28 11:02
 * @since: JDK1.8
 * @version V1.0.0
 */
public class StringTest3 {
	
	public static void main(String[] args) {
		List<Integer> judgePrime = judgePrime(10000);
		List<Integer> anagrams = anagrams(judgePrime);
		for(Integer i : anagrams) {
			System.out.print(i + ",");
		}
	}
	
	/**
	 * <p> 获取指定范围内的素数 </p></br>
	 * @Title: judgePrime  
	 * @date: 2021-04-28 11:07
	 * @param n		范围
	 * @return List<Integer> 所有的素数集合
	 * @since: 1.0.0   
	 */
	public static List<Integer> judgePrime(int n) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			boolean st = false;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					st = true;
					break;
				}
			}
			if (st) {
				list.add(i);
			}
		}
		return list;
	}
	
	/**
	 * <p> 判断Integer集合中每个数据是否满足回文 </p></br>
	 * @Title: anagrams  
	 * @date: 2021-04-28 11:16
	 * @param list		原始集合
	 * @return List<Integer>  满足回文的集合  
	 * @since: 1.0.0   
	 */
	public static List<Integer> anagrams(List<Integer> list){
		List<Integer> anagramsList = new ArrayList<Integer>();
		for(Integer i : list) {
			if(String.valueOf(i).equals(new StringBuilder(String.valueOf(i))
					.reverse()
					.toString())) {
				
				anagramsList.add(i);
			}
		}
		return anagramsList;
	}
}
