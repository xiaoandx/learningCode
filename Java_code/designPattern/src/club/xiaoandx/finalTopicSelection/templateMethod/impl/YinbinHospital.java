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
package club.xiaoandx.finalTopicSelection.templateMethod.impl;

import java.util.Scanner;

import club.xiaoandx.finalTopicSelection.caseList.decorator.CaseDecorator;
import club.xiaoandx.finalTopicSelection.caseList.decorator.impl.Amoxicillin;
import club.xiaoandx.finalTopicSelection.caseList.product.Case;
import club.xiaoandx.finalTopicSelection.caseList.product.impl.BasicsCase;
import club.xiaoandx.finalTopicSelection.entity.MedicalRecords;
import club.xiaoandx.finalTopicSelection.organizationStructure.computer.component.HospitalComponent;
import club.xiaoandx.finalTopicSelection.templateMethod.HospitalTreatmentProcess;

/**  
 * <p> 宜宾一家医院 </p> 
 * @ClassName:YinbinHospital   
 * @author: WEI.ZHOU
 * @date: 2021-06-13 15:47
 * @since: JDK1.8
 * @version V1.0.0
 */
public class YinbinHospital extends HospitalTreatmentProcess{
	
	/**
	 * 看病信息实体
	 */
	private MedicalRecords medicalRecords;
	
	/**
	 * 终端输入流，用于获取用户输入数据
	 */
	Scanner inputText = new Scanner(System.in);
	
	/**   
	 * <p> 患者就诊 </p></br>
	 * <pre> </pre></br>
	 * <p>Title: register</p> 
	 * @date: 2021-06-13 15:48       
	 * @see club.xiaoandx.finalTopicSelection.templateMethod.HospitalTreatmentProcess#register()   
	 */
	@Override
	public void register(HospitalComponent hospitalComponent) {
		// TODO 医院具体挂号流程实现（需要结合组合模式）
		System.out.println("\t\t\t 宜宾医院为你服务");
		medicalRecords = new MedicalRecords();
		hospitalComponent.duty();
		System.out.println("\n1.请根据上面医院的组织结构，输入你要进行挂号的医生编号：");
		int dotorNo = inputText.nextInt();
		medicalRecords.setDoctorName(findDotorName(dotorNo));
		sleep(1.5);
		System.out.println("\n2.你已成功挂上"+findDotorName(dotorNo)+"的诊断号,请前往诊断室等待-----------");
	}

	/**   
	 * <p> 医生就诊 </p></br>
	 * <pre> 需要开具病例清单 </pre></br>
	 * @Title: doctorVisits  
	 * @date: 2021-06-13 15:48       
	 * @see club.xiaoandx.finalTopicSelection.templateMethod.HospitalTreatmentProcess#doctorVisits()   
	 */
	@Override
	public void doctorVisits() {
		// TODO 医生治疗，就开具病例
		sleep(1.5);
		System.out.println("\n3."+medicalRecords.getDoctorName() + "正看病人情况，开药中");
		sleep(2);
		Case bingli = new BasicsCase();
		CaseDecorator amxl = new Amoxicillin(bingli);
		medicalRecords.setCoseContext(amxl);
		System.out.println("\n4.医生病例药方，开具完成，接下来需要先去缴费");
	}

	/**   
	 * <p> 付费 </p></br>
	 * <pre> 根据病例清单进行付费 </pre></br> 
	 * @Title: pay  
	 * @date: 2021-06-13 15:48       
	 * @see club.xiaoandx.finalTopicSelection.templateMethod.HospitalTreatmentProcess#pay()   
	 */
	@Override
	public void pay() {
		// TODO 通过医生开具的病例进行财务缴费
		sleep(2);
		double expenses = medicalRecords.getCoseContext().cost();
		System.out.println("\n5.你需要缴费: " + expenses + "元\n");
		double meray = 0.0;
		do {
			System.out.print("6.输入缴费金额: ");
			meray = inputText.nextDouble();
		}while(meray != expenses);
		sleep(1);
		System.out.println("\n7.缴费成功，下面你可以去拿着病例去拿药，与做检查");
	}

	/**   
	 * <p> 医院的医生进行治疗或者开药 </p></br>
	 * <p>Title: doctorTreatment</p> 
	 * @date: 2021-06-13 15:48       
	 * @see club.xiaoandx.finalTopicSelection.templateMethod.HospitalTreatmentProcess#doctorTreatment()   
	 */
	@Override
	public void doctorTreatment() {
		// TODO 然后就根据病例上需要的治疗药物与检查进行治疗
		System.out.println("\n8.药房更具你的病例给你拿了药方有：" + medicalRecords.getCoseContext().getDescription());
		sleep(2);
		System.out.println("\n9.拿药完成，请你检查是否药品数量是否与病例单上一致");
	}

	/**   
	 * <p> 结束治疗 </p></br>
	 * <p>Title: endTreatment</p> 
	 * @date: 2021-06-13 15:48       
	 * @see club.xiaoandx.finalTopicSelection.templateMethod.HospitalTreatmentProcess#endTreatment()   
	 */
	@Override
	public void endTreatment() {
		// TODO 最后结束治疗
		sleep(1);
		System.out.println("\n10.检查是否拿的药品是否与病例单上一直，无误");
		sleep(1);
		System.out.println("\n11.检查无误，结束医院看病");
		inputText.close();
	}
	
	/**
	 * <p> 选择对应医生进行挂号 </p></br>
	 * @Title: findDotorName  
	 * @date: 2021-06-13 18:21
	 * @param i
	 * @return String    
	 * @since: 1.0.0   
	 * @throws
	 */
	protected String findDotorName(int i) {
		String name = "";
		switch(i) {
			case 1: name = "黄医生";
			break;
			case 2: name = "李医生";
			break;
			case 3: name = "张医生";
			break;
			case 4: name = "刘医生";
			break;
			case 5: name = "周医生";
			break;
		}
		return name;
	}
	
	/**
	 * <p> 模拟等待 </p></br>
	 * @Title: sleep  
	 * @date: 2021-06-13 17:53
	 * @param s 	等待时长，秒为单位
	 * @since: 1.0.0   
	 * @throws
	 */
	protected void sleep(double d) {
		try {
			Thread.sleep((long) (d * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
