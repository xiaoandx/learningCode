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
package club.xiaoandx.finalTopicSelection.templateMethod;

/**  
 * <p>医院看病流程 抽象 </p> 
 * @ClassName:PatientVisits   
 * @author: WEI.ZHOU
 * @date: 2021-06-13 15:37
 * @since: JDK1.8
 * @version V1.0.0
 */
public abstract class HospitalTreatmentProcess {
	
	/**
	 * <p> 患者就诊 </p></br>
	 * <pre> </pre></br>
	 * @Title: patientVisits  
	 * @date: 2021-06-13 15:45 void    
	 * @since: 1.0.0   
	 */
	public final void patientVisits() {
		register();
		doctorVisits();
		pay();
		doctorTreatment();
		endTreatment();
	}
	
	/**
	 * <p> 挂号 </p></br>
	 * 挂号需要选择指定医院的科室  与对应的医生
	 * @Title: register  
	 * @date: 2021-06-13 15:39 void    
	 * @since: 1.0.0   
	 */
	public abstract void register();
	
	/**
	 * <p> 医生就诊 </p></br>
	 * <pre> 需要开具病例清单 </pre></br>
	 * @Title: doctorVisits  
	 * @date: 2021-06-13 15:41 void    
	 * @since: 1.0.0   
	 */
	public abstract void doctorVisits();
	
	/**
	 * <p> 付费 </p></br>
	 * <pre> 根据病例清单进行付费 </pre></br>
	 * @Title: pay  
	 * @date: 2021-06-13 15:42 void    
	 * @since: 1.0.0   
	 */
	public abstract void pay();
	
	/**
	 * <p> 医院的医生进行治疗或者开药 </p></br>
	 * @Title: doctorTreatment  
	 * @date: 2021-06-13 15:43 void    
	 * @since: 1.0.0   
	 */
	public abstract void doctorTreatment();
	
	/**
	 * <p> 结束治疗 </p></br>
	 * @Title: endTreatment  
	 * @date: 2021-06-13 15:44 void    
	 * @since: 1.0.0   
	 */
	public abstract void endTreatment();
}
