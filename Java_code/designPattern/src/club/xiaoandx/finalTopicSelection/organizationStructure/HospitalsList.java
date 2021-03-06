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
package club.xiaoandx.finalTopicSelection.organizationStructure;

import club.xiaoandx.finalTopicSelection.organizationStructure.computer.composite.HospitalDepartment;
import club.xiaoandx.finalTopicSelection.organizationStructure.computer.leaf.Physician;

/**  
 * <p> 医院组织结构图 </p> 
 * @ClassName:Test   
 * @author: WEI.ZHOU
 * @date: 2021-06-13 13:57
 * @since: JDK1.8
 * @version V1.0.0
 */
public class HospitalsList {
	
	/**
	 * <p> 宜宾第一医院组织成员 </p></br>
	 * @Title: getYibinHospita  
	 * @date: 2021-06-13 18:24
	 * @return HospitalDepartment    
	 * @since: 1.0.0   
	 */
	public HospitalDepartment getYibinHospitaOne() {
		HospitalDepartment rootHospitaName = new HospitalDepartment("宜宾第一人民医院为你服务（看病拿药测试）");
		HospitalDepartment internalMedicine = new HospitalDepartment("\t内科");
		HospitalDepartment surgery = new HospitalDepartment("\t外科");
		HospitalDepartment departmentGastroenterology = new HospitalDepartment("\t\t消化内科");
		HospitalDepartment cardiovascularDepartment = new HospitalDepartment("\t\t心血管内科");
		HospitalDepartment orthopaedics = new HospitalDepartment("\t\t骨科");
		HospitalDepartment neurosurgery = new HospitalDepartment("\t\t神经外科");
		Physician huang = new Physician("\t\t\tNO.1 黄医生");
		Physician li = new Physician("\t\t\tNO.2 李医生");
		Physician zhang = new Physician("\t\t\tNO.3 张医生");
		Physician liu = new Physician("\t\t\tNO.4 刘医生");
		Physician zhou = new Physician("\t\t\tNO.5 周医生");
		
		rootHospitaName.add(internalMedicine);
		internalMedicine.add(departmentGastroenterology);
		departmentGastroenterology.add(huang);
		departmentGastroenterology.add(li);
		internalMedicine.add(cardiovascularDepartment);
		cardiovascularDepartment.add(zhang);
		rootHospitaName.add(surgery);
		surgery.add(orthopaedics);
		orthopaedics.add(liu);
		surgery.add(neurosurgery);
		neurosurgery.add(zhou);
		return rootHospitaName;
	}
	
	public HospitalDepartment getYibinHospitaTwo() {
		HospitalDepartment rootHospitaName = new HospitalDepartment("宜宾第二人民医院为你服务（看病检查拿药测试）");
		HospitalDepartment internalMedicine = new HospitalDepartment("\t内科");
		HospitalDepartment surgery = new HospitalDepartment("\t外科");
		HospitalDepartment departmentGastroenterology = new HospitalDepartment("\t\t消化内科");
		HospitalDepartment cardiovascularDepartment = new HospitalDepartment("\t\t心血管内科");
		HospitalDepartment orthopaedics = new HospitalDepartment("\t\t骨科");
		HospitalDepartment neurosurgery = new HospitalDepartment("\t\t神经外科");
		Physician huang = new Physician("\t\t\tNO.1 黄医生");
		Physician li = new Physician("\t\t\tNO.2 李医生");
		Physician zhang = new Physician("\t\t\tNO.3 张医生");
		Physician liu = new Physician("\t\t\tNO.4 刘医生");
		Physician zhou = new Physician("\t\t\tNO.5 周医生");
		
		rootHospitaName.add(internalMedicine);
		internalMedicine.add(departmentGastroenterology);
		departmentGastroenterology.add(huang);
		departmentGastroenterology.add(li);
		internalMedicine.add(cardiovascularDepartment);
		cardiovascularDepartment.add(zhang);
		rootHospitaName.add(surgery);
		surgery.add(orthopaedics);
		orthopaedics.add(liu);
		surgery.add(neurosurgery);
		neurosurgery.add(zhou);
		return rootHospitaName;
	}
}
