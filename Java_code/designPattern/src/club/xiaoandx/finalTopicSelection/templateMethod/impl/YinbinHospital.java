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
	 * <p> 患者就诊 </p></br>
	 * <pre> </pre></br>
	 * <p>Title: register</p> 
	 * @date: 2021-06-13 15:48       
	 * @see club.xiaoandx.finalTopicSelection.templateMethod.HospitalTreatmentProcess#register()   
	 */
	@Override
	public void register() {
		// TODO 医院具体挂号流程实现（需要结合组合模式）
		
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
		
	}

}
