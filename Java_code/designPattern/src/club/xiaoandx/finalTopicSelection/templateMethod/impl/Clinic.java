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

import club.xiaoandx.finalTopicSelection.MainTest;
import club.xiaoandx.finalTopicSelection.caseList.decorator.CaseDecorator;
import club.xiaoandx.finalTopicSelection.caseList.decorator.impl.Amoxicillin;
import club.xiaoandx.finalTopicSelection.caseList.decorator.impl.Norfloxacin;
import club.xiaoandx.finalTopicSelection.caseList.decorator.impl.Sismin;
import club.xiaoandx.finalTopicSelection.caseList.product.Case;
import club.xiaoandx.finalTopicSelection.caseList.product.impl.BasicsCase;
import club.xiaoandx.finalTopicSelection.entity.MedicalRecords;
import club.xiaoandx.finalTopicSelection.organizationStructure.computer.component.HospitalComponent;
import club.xiaoandx.finalTopicSelection.templateMethod.HospitalTreatmentProcess;

/**  
 * <p> 普通诊所</p> 
 * @ClassName:YinbinHospitalOne   
 * @author: WEI.ZHOU
 * @date: 2021-06-13 15:47
 * @since: JDK1.8
 * @version V1.2.0
 */
public class Clinic extends HospitalTreatmentProcess{
	
	/**
	 * 看病信息实体
	 */
	private MedicalRecords medicalRecords;
	
	/**
	 * 终端输入流，用于获取用户输入数据
	 */
	Scanner inputText = new Scanner(System.in);
	
	/**
	 * 是否去医院
	 */
	int isGoHospital;
	
	/**   
	 * <p> 患者就诊 </p></br>
	 * <pre> </pre></br>
	 * <p>Title: register</p> 
	 * @date: 2021-06-13 15:48       
	 * @see club.xiaoandx.finalTopicSelection.templateMethod.HospitalTreatmentProcess#register()   
	 */
	@Override
	public void register(HospitalComponent hospitalComponent) {
		medicalRecords = new MedicalRecords();
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
		// TODO 诊所医生根据病情，就开具病例或推荐去医院就诊
		sleep(1.5);
		System.out.print("诊所医生在给你看病，根据你的病情，诊所医生询问你是否需要前往医院(1是，2不去):");
		isGoHospital = inputText.nextInt();
		sleep(2);
		if(isGoHospital == 1) {
			MainTest.seeDoctor();
		}else {
			System.out.println("\n正在给你看病，开药中...............");
			// 医生开药
			Case bingli = new BasicsCase();
			CaseDecorator amxl = new Amoxicillin(bingli);
			CaseDecorator norfloxacin = new Norfloxacin(amxl);
			CaseDecorator sismin = new Sismin(norfloxacin);
			medicalRecords.setCoseContext(sismin);
			System.out.println("\n病例药方，开具完成。 接下来你需要先去结账");
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
		if(isGoHospital != 1) {
			double expenses = medicalRecords.getCoseContext().cost();
			BigDecimal b = new BigDecimal(expenses);
			expenses = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			System.out.println("\n合计病例上药品总价，你需要缴费: " + expenses + "元\n");
			double meray = 0.0;
			do {
				System.out.print("输入缴费金额: ");
				meray = inputText.nextDouble();
			}while(meray != expenses);
			sleep(1);
			System.out.println("\n缴费成功，下面你可以去拿着病例去药房窗口拿药");
		}
	}

	/**   
	 * <p> 诊所开药 </p></br>
	 * <p>Title: doctorTreatment</p> 
	 * @date: 2021-06-13 15:48       
	 * @see club.xiaoandx.finalTopicSelection.templateMethod.HospitalTreatmentProcess#doctorTreatment()   
	 */
	@Override
	public void doctorTreatment() {
		// TODO 然后就根据病例上需要的治疗药物抓药
		if(isGoHospital != 1) {
			System.out.println("\n11.你需要拿的药品有：" + medicalRecords.getCoseContext().getDescription());
			sleep(2);
			System.out.print("\n医院拿药完成，请你检查是否药品数量是否与病例单上一致（1一致，2不一致）：");
			int isInspect = inputText.nextInt();
			switch (isInspect) {
			case 1:
				System.out.println("\n检查所拿的药品与病例单上一致，无误");
				break;
			case 2:
				System.out.println("\n检查所拿的药品与病例单上不一致，前往医院窗口再次确认");
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
		if(isGoHospital != 1) {
			sleep(2);
			System.out.println("\n完成看病拿药流程，结束医院看病");
			inputText.close();
		}
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
