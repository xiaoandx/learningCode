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
package club.xiaoandx.finalTopicSelection;

import java.util.Scanner;

import club.xiaoandx.finalTopicSelection.organizationStructure.HospitalsList;
import club.xiaoandx.finalTopicSelection.templateMethod.HospitalTreatmentProcess;
import club.xiaoandx.finalTopicSelection.templateMethod.impl.Clinic;
import club.xiaoandx.finalTopicSelection.templateMethod.impl.YinbinHospitalOne;
import club.xiaoandx.finalTopicSelection.templateMethod.impl.YinbinHospitalTwo;

/**  
 * <p> 看病拿药测试 </p> 
 * @ClassName:MainTest   
 * @author: WEI.ZHOU
 * @date: 2021-06-13 16:35
 * @since: JDK1.8
 * @version V1.2.0
 */
public class MainTest{
	
	public static void main(String[] args) {
		/**
		 * 诊所看病测试
		 */
		HospitalTreatmentProcess hospitalTreatmentProcess = new Clinic();
		hospitalTreatmentProcess.patientVisits(null);
		
		/**
		 * 医院看病测试
		 */
		//seeDoctor();
	}
	
	/**
	 * <p> 医院看病 </p></br>
	 * @Title: seeDoctor  
	 * @date: 2021-06-15 18:20 void    
	 * @since: 1.0.0   
	 */
	public static void seeDoctor() {
		HospitalTreatmentProcess hospitalTreatmentProcess;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("选择要去的医院(1.宜宾第一医院  2.宜宾第二医院)：");
		int no = input.nextInt();
		switch (no) {
		case 1:
			hospitalTreatmentProcess = new YinbinHospitalOne();
			hospitalTreatmentProcess.patientVisits(new HospitalsList().getYibinHospitaOne());
			break;
		case 2:
			hospitalTreatmentProcess = new YinbinHospitalTwo();
			hospitalTreatmentProcess.patientVisits(new HospitalsList().getYibinHospitaTwo());
			break;
		}
	}
}
