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
package club.xiaoandx.experiment4.assignment2.facade;

import club.xiaoandx.experiment4.assignment2.Graduates;

/**  
 * <p> 毕业生手续代办Facade接口 </p> 
 *	只需提供，学生证、身份证、饭卡、借书证；</br>
 *	代办中心，会进行代办，毕业证、学位证、派遣证、饭卡余额、借书证押金
 * @ClassName:GraduateProceduresFacade   
 * @author: WEI.ZHOU
 * @date: 2021-04-29 13:20
 * @since: JDK1.8
 * @version V1.0.0
 */
public interface GraduateProceduresFacade {

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
	Graduates transaction(Graduates graduates);
	
	/**
	 * <p> 教务处代办 </p></br>
	 * @Title: transactionEducational  
	 * @date: 2021-04-29 17:15
	 * @param graduates void    
	 * @since: 1.0.0   
	 */
	void  transactionEducational(Graduates graduates);
	
	/**
	 * <p> 公安处派遣证代办 </p></br>
	 * @Title: transactionEducational  
	 * @date: 2021-04-29 17:15
	 * @param graduates void    
	 * @since: 1.0.0   
	 */
	void  transactionPublicSecurity(Graduates graduates);
	
	/**
	 * <p> 借书证押金代办 </p></br>
	 * @Title: transactionEducational  
	 * @date: 2021-04-29 17:15
	 * @param graduates void    
	 * @since: 1.0.0   
	 */
	void  transactionLibrary(Graduates graduates);
	
	/**
	 * <p> 饭卡余额代办 </p></br>
	 * @Title: transactionEducational  
	 * @date: 2021-04-29 17:15
	 * @param graduates void    
	 * @since: 1.0.0   
	 */
	void  transactionLogistics(Graduates graduates);
}
