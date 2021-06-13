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
package club.xiaoandx.finalTopicSelection.entity;

import club.xiaoandx.finalTopicSelection.caseList.product.Case;

/**  
 * <p> 看病记录实体 </p> 
 * @ClassName:MedicalRecords   
 * @author: WEI.ZHOU
 * @date: 2021-06-13 16:17
 * @since: JDK1.8
 * @version V1.0.0
 */
public class MedicalRecords {
	
	/**
	 * 患者姓名
	 */
	private String patientName;
	
	/**
	 * 选择挂号科室
	 */
	private String department;
	
	/**
	 * 挂号医生姓名
	 */
	private String doctorName;
	
	/**
	 * 病例内容
	 */
	private Case coseContext;

	/**
	 * @Title:  getDepartment 挂号科室</br>  
	 * @Description: GET方法 </br>
	 * @return: String </br>  
	 * @return: department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @Title:  setDepartment 挂号科室</br>  
	 * @Description: 属性的SET方法 </br>  
	 * @return: String </br> 
	 * @param: department 要设置的 department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @Title:  getDoctorName 医生姓名 </br>  
	 * @Description: GET方法 </br>
	 * @return: String </br>  
	 * @return: doctorName
	 */
	public String getDoctorName() {
		return doctorName;
	}

	/**
	 * @Title:  setDoctorName 医生姓名 </br>  
	 * @Description: 属性的SET方法 </br>  
	 * @return: String </br> 
	 * @param: doctorName 要设置的 doctorName
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	/**
	 * @Title:  getCoseContext 病例 </br>  
	 * @Description: GET方法 </br>
	 * @return: Case </br>  
	 * @return: coseContext
	 */
	public Case getCoseContext() {
		return coseContext;
	}

	/**
	 * @Title:  setCoseContext 病例 </br>  
	 * @Description: 属性的SET方法 </br>  
	 * @return: Case </br> 
	 * @param: coseContext 要设置的 coseContext
	 */
	public void setCoseContext(Case coseContext) {
		this.coseContext = coseContext;
	}

	/**
	 * @Title:  getPatientName </br>  
	 * @Description: GET方法 </br>
	 * @return: String </br>  
	 * @return: patientName
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * @Title:  setPatientName </br>  
	 * @Description: 属性的SET方法 </br>  
	 * @return: String </br> 
	 * @param: patientName 要设置的 patientName
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	/**   
	 * <p> </p></br>
	 *
	 * <pre> </pre></br>
	 *
	 * <ul>
	 * 	<li> </li>
	 * </ul>
	 *
	 * <p>Title: toString</p> 
	 * @date: 2021-06-13 16:45    
	 * @return   
	 * @see java.lang.Object#toString()   
	 */
	@Override
	public String toString() {
		return "MedicalRecords [patientName=" + patientName + ", department=" + department
				+ ", doctorName=" + doctorName + ", coseContext=" + coseContext + "]";
	}

	/**   
	 * <p> </p></br>
	 * @Title:  MedicalRecords   
	 * @date: 2021-06-13 16:46
	 * @param patientName
	 * @param department
	 * @param doctorName
	 * @param coseContext 
	 * @since: 1.0.0
	 */
	public MedicalRecords(String patientName, String department, String doctorName,
			Case coseContext) {
		super();
		this.patientName = patientName;
		this.department = department;
		this.doctorName = doctorName;
		this.coseContext = coseContext;
	}

	/**   
	 * <p> </p></br>
	 * @Title:  MedicalRecords   
	 * @date: 2021-06-13 16:46 
	 * @since: 1.0.0
	 */
	public MedicalRecords() {
		super();
	}


	
	
}
