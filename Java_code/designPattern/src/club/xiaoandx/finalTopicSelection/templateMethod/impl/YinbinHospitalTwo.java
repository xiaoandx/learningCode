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

import java.math.BigDecimal;
import java.util.Scanner;

import club.xiaoandx.finalTopicSelection.caseList.decorator.CaseDecorator;
import club.xiaoandx.finalTopicSelection.caseList.decorator.impl.Amoxicillin;
import club.xiaoandx.finalTopicSelection.caseList.decorator.impl.DrawBlood;
import club.xiaoandx.finalTopicSelection.caseList.decorator.impl.Norfloxacin;
import club.xiaoandx.finalTopicSelection.caseList.decorator.impl.Register;
import club.xiaoandx.finalTopicSelection.caseList.decorator.impl.Sismin;
import club.xiaoandx.finalTopicSelection.caseList.product.Case;
import club.xiaoandx.finalTopicSelection.caseList.product.impl.BasicsCase;
import club.xiaoandx.finalTopicSelection.entity.MedicalRecords;
import club.xiaoandx.finalTopicSelection.organizationStructure.computer.component.HospitalComponent;
import club.xiaoandx.finalTopicSelection.templateMethod.HospitalTreatmentProcess;

/**  
 * <p> 宜宾第二人民医院 </p> 
 * @ClassName:YinbinHospitalOne   
 * @author: WEI.ZHOU
 * @date: 2021-06-13 15:47
 * @since: JDK1.8
 * @version V1.2.0
 */
public class YinbinHospitalTwo extends HospitalTreatmentProcess{
	
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
		System.out.println("\t\t\t 宜宾第二人民医院为你服务（看病检查拿药测试）");
		medicalRecords = new MedicalRecords();
		hospitalComponent.duty();
		System.out.print("\n1.请根据上面医院的组织结构，输入你要进行挂号的医生编号：");
		int dotorNo = inputText.nextInt();
		medicalRecords.setDoctorName(findDotorName(dotorNo));
		sleep(1);
		// 进行挂号并前往财务
		Case bingli = new BasicsCase();
		Register register = new Register(bingli);
		System.out.println("\n2.请先缴挂号费: " + register.cost() + "元\n");
		double meray = 0.0;
		do {
			System.out.print("3.输入金额进行挂号缴费: ");
			meray = inputText.nextDouble();
		}while(meray != register.cost());
		sleep(1);
		System.out.println("\n4.挂号缴费成功");
		sleep(1);
		System.out.println("\n5.你已成功挂上"+findDotorName(dotorNo)+"的诊断号,请前往诊断室等待-----------");
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
		// TODO 医生治疗，就开具病例  需要进行检查（开检查单->缴费->检查->医生在根据检查报告诊断开药）
		sleep(1.5);
		if(medicalRecords.isInspect()) {
			System.out.println("\n6."+medicalRecords.getDoctorName() + "医生根据检测报告，开药中...............");
			// 医生开药
			Case bingli = new BasicsCase();
			CaseDecorator amxl = new Amoxicillin(bingli);
			CaseDecorator norfloxacin = new Norfloxacin(amxl);
			CaseDecorator sismin = new Sismin(norfloxacin);
			medicalRecords.setCoseContext(sismin);
			sleep(2);
			System.out.println("\n7.病例药方，开具完成。 接下来你需要先去财务窗口缴费");
			medicalRecords.setInspect(false);
			pay();
		}else {
			System.out.println("\n6."+medicalRecords.getDoctorName() + "正在给你看病，开具检查单，需要先去检查");
			medicalRecords.setInspect(true);
			Case bingli = new BasicsCase();
			CaseDecorator drawBlood = new DrawBlood(bingli);
			medicalRecords.setCoseContext(drawBlood);
		}
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
		BigDecimal b = new BigDecimal(expenses);
		expenses = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		
		if(medicalRecords.isInspect()) {
			System.out.println("\n8.你的检查需要缴费: " + expenses + "元\n");
			double meray = 0.0;
			do {
				System.out.print("9.输入缴费金额: ");
				meray = inputText.nextDouble();
			}while(meray != expenses);
			sleep(1);
			System.out.println("\n10.缴费成功，下面你可以去拿着检查单去检查");
		}else {
			System.out.println("\n8.合计病例上药品总价，你需要缴费: " + expenses + "元\n");
			double meray = 0.0;
			do {
				System.out.print("9.输入缴费金额: ");
				meray = inputText.nextDouble();
			}while(meray != expenses);
			sleep(1);
			System.out.println("\n10.缴费成功，下面你可以去拿着病例去药房窗口拿药");
			doctorTreatment();
		}
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
		
		if(medicalRecords.isInspect()) {
			System.out.println("\n11.你需要进行检查的是：" + medicalRecords.getCoseContext().getDescription());
			sleep(2);
			System.out.println("检查完毕请等待报告结果，拿好结果到医生那里进行开药治疗");
			doctorVisits();
		}else {
			System.out.println("\n11.你需要拿的药品有：" + medicalRecords.getCoseContext().getDescription());
			sleep(2);
			System.out.print("\n12.医院拿药完成，请你检查是否药品数量是否与病例单上一致（1一致，2不一致）：");
			int isInspect = inputText.nextInt();
			switch (isInspect) {
			case 1:
				System.out.println("\n13.检查所拿的药品与病例单上一致，无误");
				break;
			case 2:
				System.out.println("\n13.检查所拿的药品与病例单上不一致，前往医院窗口再次确认");
				sleep(1);
				System.out.println("\n.窗口进行缺漏药品进行了补拿------------");
				break;
			}
		}
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
		sleep(2);
		System.out.println("\n14.完成看病拿药流程，结束医院看病");
		inputText.close();
	}
	
	/**
	 * <p> 选择对应医生进行挂号 </p></br>
	 * @Title: findDotorName  
	 * @date: 2021-06-13 18:21
	 * @param i
	 * @return String    
	 * @since: 1.0.0   
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
	 */
	protected void sleep(double d) {
		try {
			Thread.sleep((long) (d * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
