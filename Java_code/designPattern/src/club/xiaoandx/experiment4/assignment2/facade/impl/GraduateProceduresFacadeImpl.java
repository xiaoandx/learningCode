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
package club.xiaoandx.experiment4.assignment2.facade.impl;

import club.xiaoandx.experiment4.assignment2.Graduates;
import club.xiaoandx.experiment4.assignment2.facade.GraduateProceduresFacade;
import club.xiaoandx.experiment4.assignment2.institution.EducationalAdministration;
import club.xiaoandx.experiment4.assignment2.institution.Library;
import club.xiaoandx.experiment4.assignment2.institution.Logistics;
import club.xiaoandx.experiment4.assignment2.institution.PublicSecurity;

/**  
 * <p> 毕业生手续代办Facade </p> 
 *	只需提供，学生证、身份证、饭卡、借书证；</br>
 *	代办中心，会进行代办，毕业证、学位证、派遣证、饭卡余额、借书证押金
 * @ClassName:GraduateProceduresFacade   
 * @author: WEI.ZHOU
 * @date: 2021-04-29 13:20
 * @since: JDK1.8
 * @version V1.0.0
 */
public class GraduateProceduresFacadeImpl implements GraduateProceduresFacade {

	/**
	 * <p> 办理中心 </p></br>
	 * <ul>
	 * 	<li> 教务处代办 </li>
	 * 	<li> 公安处派遣证代办 </li>
	 * 	<li> 借书证押金代办 </li>
	 * 	<li> 饭卡余额代办 </li>
	 * </ul>
	 * @Title: transaction  
	 * @date: 2021-04-29 13:26
	 * @param graduates
	 * @return Graduates    
	 * @since: 1.0.0   
	 */
	public Graduates transaction(Graduates graduates) {
		transactionEducational(graduates);
		transactionPublicSecurity(graduates);
		transactionLibrary(graduates);
		transactionLogistics(graduates);
		return graduates;
	}
	
	/**
	 * <p> 教务处代办 </p></br>
	 * @Title: transactionEducational  
	 * @date: 2021-04-29 17:15
	 * @param graduates void    
	 * @since: 1.0.0   
	 */
	public void  transactionEducational(Graduates graduates) {
		EducationalAdministration.checkingStudentID(graduates);
	}
	
	/**
	 * <p> 公安处派遣证代办 </p></br>
	 * @Title: transactionEducational  
	 * @date: 2021-04-29 17:15
	 * @param graduates void    
	 * @since: 1.0.0   
	 */
	public void  transactionPublicSecurity(Graduates graduates) {
		PublicSecurity.checkingStudent(graduates);
	}
	
	/**
	 * <p> 借书证押金代办 </p></br>
	 * @Title: transactionEducational  
	 * @date: 2021-04-29 17:15
	 * @param graduates void    
	 * @since: 1.0.0   
	 */
	public void  transactionLibrary(Graduates graduates) {
		Library.checkingLibraryCardDeposit(graduates);
	}
	
	/**
	 * <p> 饭卡余额代办 </p></br>
	 * @Title: transactionEducational  
	 * @date: 2021-04-29 17:15
	 * @param graduates void    
	 * @since: 1.0.0   
	 */
	public void  transactionLogistics(Graduates graduates) {
		Logistics.checkingFoodCardID(graduates);
	}
}
