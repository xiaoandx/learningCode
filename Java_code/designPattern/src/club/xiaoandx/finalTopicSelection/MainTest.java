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

import club.xiaoandx.finalTopicSelection.organizationStructure.HospitalsList;
import club.xiaoandx.finalTopicSelection.templateMethod.HospitalTreatmentProcess;
import club.xiaoandx.finalTopicSelection.templateMethod.impl.YinbinHospital;

/**  
 * <p> 看病拿药测试 </p> 
 * @ClassName:MainTest   
 * @author: WEI.ZHOU
 * @date: 2021-06-13 16:35
 * @since: JDK1.8
 * @version V1.0.0
 */
public class MainTest{
	public static void main(String[] args) {
		/*
		 * 测试流程
		 * 1. 先选择一个医院进行看病，选择医院就实例化创建对应医院
		 * 2. 再获取对应医院的组织结构图，方便用户挂号选择
		 * 3. 然后按照统一的模板方法进行看病流程处理
		 */
		HospitalTreatmentProcess hospitalTreatmentProcess = new YinbinHospital();
		hospitalTreatmentProcess.patientVisits(new HospitalsList().getYibinHospita());
	}
}
