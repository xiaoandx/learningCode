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
package club.xiaoandx.commons.utils;

import java.util.Iterator;
import java.util.Map;

/**  
 * <p> 
 *	对象工具类  判空  判断是否属于基本类型
 * </p> 
 * @ClassName:ObjectUtil   
 * @author: WEI.ZHOU
 * @date: 2021-03-19 09:05
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
public class ObjectUtil {
	
	/**
	 * 检查对象是否为null<br>
	 * 判断标准为：
	 *
	 * <pre>
	 * 1. == null
	 * 2. equals(null)
	 * </pre>
	 *
	 * @param obj 对象
	 * @return 是否为null
	 */
	public static boolean isNull(Object obj) {
		//noinspection ConstantConditions
		return null == obj || obj.equals(null);
	}

	/**
	 * 检查对象是否不为null
	 *
	 * @param obj 对象
	 * @return 是否为null
	 */
	public static boolean isNotNull(Object obj) {
		//noinspection ConstantConditions
		return null != obj && false == obj.equals(null);
	}
	
	/**
	 * 判断指定对象是否为空，支持：
	 *
	 * <pre>
	 * 1. CharSequence (String, StringBuffer, StringBuilder)
	 * 2. Map
	 * 3. Iterable
	 * 4. Iterator
	 * 5. Array
	 * </pre>
	 * @param <T>
	 *
	 * @param obj 被判断的对象
	 * @return 是否为空，如果类型不支持，返回false
	 * @since 1.0
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> boolean isEmpty(Object obj) {
		if (null == obj) {
			return true;
		}
		if (obj instanceof CharSequence) {
			// 判断对象是否属于CharSequence对象 常见的对象(String, StringBuffer, StringBuilder)
			CharSequence str = (CharSequence) obj;
			return str == null || str.length() == 0;
		} else if (obj instanceof Map) {
			// 判断 obj 对象是否属于 Map
			Map map = (Map)obj;
			return null == map || map.isEmpty();
		} else if (obj instanceof Iterable) { 
			// 判断 obj 是否属于 Iterable集合接口
			Iterable<?> iterable = (Iterable) obj;
			return null == iterable || isEmpty(iterable.iterator());
		} else if (obj instanceof Iterator) {
			Iterator<?> iterator = (Iterator) obj;
			return null == iterator || false == iterator.hasNext();
		} else if (null != obj && obj.getClass().isArray()) {
			// 判断 obj 是否属于数组类型
			T[] array = (T[]) obj;
			return array == null || array.length == 0;
		}
		return false;
	}

	/**
	 * 判断指定对象是否为非空，支持：
	 *
	 * <pre>
	 * 1. CharSequence
	 * 2. Map
	 * 3. Iterable
	 * 4. Iterator
	 * 5. Array
	 * </pre>
	 *
	 * @param obj 被判断的对象
	 * @return 是否为空，如果类型不支持，返回true
	 * @since 4.5.7
	 */
	public static boolean isNotEmpty(Object obj) {
		return false == isEmpty(obj);
	}
	
	/**
	 * 
	 * <p> 判断是否属于基本类型 </p></br>
	 * <pre>
	 * 	如果对象属于基本数据类型  返回true；不属于基本数据类型返回false
	 * </pre>
	 * @Title: isBasicType   
	 * @date: 2021-03-24 11:58
	 * @param object
	 * @return boolean     
	 * @since: 1.0.0   
	 */
	public static boolean isBasicType(Object object) {
		Class<?> clazz  = object.getClass();
		if (null == clazz) {
			return false;
		}
		return (clazz.isPrimitive());
	}
	
	
}
