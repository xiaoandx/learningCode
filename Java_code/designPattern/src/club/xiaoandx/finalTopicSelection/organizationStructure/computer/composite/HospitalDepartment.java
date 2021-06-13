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
package club.xiaoandx.finalTopicSelection.organizationStructure.computer.composite;

import java.util.ArrayList;
import java.util.List;

import club.xiaoandx.finalTopicSelection.organizationStructure.computer.component.HospitalComponent;


/**  
 * <p> 医院科室 </p> 
 * @ClassName:HospitalDepartment   
 * @author: WEI.ZHOU
 * @date: 2021-06-13 13:44
 * @since: JDK1.8
 * @version V1.0.0
 */
public class HospitalDepartment extends HospitalComponent{
	
	/**
	 * 科室下面的组件
	 */
	private List<HospitalComponent> child;

	/**   
	 * <p> 构造器保存 医院科室名称  </p></br>
	 * @Title:  HospitalDepartment   
	 * @date: 2021-06-13 13:45
	 * @param name 
	 * @since: 1.0.0
	 */
	public HospitalDepartment(String name) {
		super(name);
		child = new ArrayList<HospitalComponent>();
	}

	/**   
	 * <p> 医院科室 职责(如果为科室 者会展示科室下面的医师与子科室等) </p></br>
	 * <p>Title: duty</p> 
	 * @date: 2021-06-13 13:45       
	 * @see club.xiaoandx.finalTopicSelection.organizationStructure.computer.component.HospitalComponent#duty()   
	 */
	@Override
	public void duty() {
		System.out.println(name);
		for(HospitalComponent h : child) {
			h.duty();
		}
	}

	/**   
	 * <p> 科室添加医院组件（可以是医师或者科室） </p></br>
	 * <p>Title: add</p> 
	 * @date: 2021-06-13 13:45    
	 * @param component   
	 * @see club.xiaoandx.finalTopicSelection.organizationStructure.computer.component.HospitalComponent#add(club.xiaoandx.finalTopicSelection.organizationStructure.computer.component.HospitalComponent)   
	 */
	@Override
	public void add(HospitalComponent component) {
		if(null != component) {
			child.add(component);
		}
	}

	/**   
	 * <p> 删除移除科室下面的 组织 </p></br>
	 * <p>Title: remove</p> 
	 * @date: 2021-06-13 13:45    
	 * @param component   
	 * @see club.xiaoandx.finalTopicSelection.organizationStructure.computer.component.HospitalComponent#remove(club.xiaoandx.finalTopicSelection.organizationStructure.computer.component.HospitalComponent)   
	 */
	@Override
	public void remove(HospitalComponent component) {
		if (null != component) {
			child.remove(component);
		}
	}

}
