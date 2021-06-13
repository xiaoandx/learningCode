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
package club.xiaoandx.finalTopicSelection.organizationStructure.computer.leaf;

import club.xiaoandx.finalTopicSelection.organizationStructure.abnormal.UNrealizationException;
import club.xiaoandx.finalTopicSelection.organizationStructure.computer.component.HospitalComponent;

/**  
 * <p> 医院医师 </p> 
 * @ClassName:Physician   
 * @author: WEI.ZHOU
 * @date: 2021-06-13 13:54
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Physician extends HospitalComponent{

	/**   
	 * <p> 构造器记录医师姓名 </p></br>
	 * @Title:  Physician   
	 * @date: 2021-06-13 13:54
	 * @param name 
	 * @since: 1.0.0
	 */
	public Physician(String name) {
		super(name);
	}

	/**   
	 * <p> 医师看病  </p></br>
	 * <p>Title: duty</p> 
	 * @date: 2021-06-13 13:55       
	 * @see club.xiaoandx.finalTopicSelection.organizationStructure.computer.component.HospitalComponent#duty()   
	 */
	@Override
	public void duty() {
		System.out.println(name);
	}

	/**   
	 * <p> 医师不实现 </p></br>
	 * <p>Title: add</p> 
	 * @date: 2021-06-13 13:55    
	 * @param component   
	 * @see club.xiaoandx.finalTopicSelection.organizationStructure.computer.component.HospitalComponent#add(club.xiaoandx.finalTopicSelection.organizationStructure.computer.component.HospitalComponent)   
	 */
	@Override
	public void add(HospitalComponent component) {
		throw new UNrealizationException();
	}

	/**   
	 * <p> 医师不实现 </p></br>
	 * <p>Title: remove</p> 
	 * @date: 2021-06-13 13:55    
	 * @param component   
	 * @see club.xiaoandx.finalTopicSelection.organizationStructure.computer.component.HospitalComponent#remove(club.xiaoandx.finalTopicSelection.organizationStructure.computer.component.HospitalComponent)   
	 */
	@Override
	public void remove(HospitalComponent component) {
		throw new UNrealizationException();
	}

}
