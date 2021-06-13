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
package club.xiaoandx.finalTopicSelection.organizationStructure.computer.component;

/**  
 * <p> 医院组件抽象类 Component </p> 
 * @ClassName:HospitalComponent   
 * @author: WEI.ZHOU
 * @date: 2021-06-13 13:40
 * @since: JDK1.8
 * @version V1.0.0
 */
public abstract class HospitalComponent {
	
	/**
	 * 组件名称
	 */
	protected String name;
	
	/**   
	 * @Title:  Component   
	 * @date: 2021-05-26 19:25 
	 * @since: 1.0.0
	 */
	public HospitalComponent(String name) {
		this.name = name;
	}
	
	/**
	 * <p> 组件 职责 </p></br>
	 * @Title: duty  
	 * @date: 2021-05-26 19:27 void    
	 * @since: 1.0.0   
	 */
	public abstract void duty();
	
	/**
	 * <p> 添加其它组件 </p></br>
	 * @Title: add  
	 * @date: 2021-05-26 19:28
	 * @param component void    
	 * @since: 1.0.0   
	 */
	public abstract void add(HospitalComponent component);
	
	/**
	 * <p> 删除组件 </p></br>
	 * @Title: remove  
	 * @date: 2021-05-26 19:28
	 * @param component void    
	 * @since: 1.0.0   
	 */
	public abstract void remove(HospitalComponent component);
}
