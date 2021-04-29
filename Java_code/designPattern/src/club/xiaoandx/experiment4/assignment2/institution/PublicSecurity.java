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
package club.xiaoandx.experiment4.assignment2.institution;

import club.xiaoandx.experiment4.assignment2.Graduates;

/**  
 * <p> 公安处 </p> 
 *	负责办理派遣证
 * @ClassName:publicSecurity   
 * @author: WEI.ZHOU
 * @date: 2021-04-29 13:01
 * @since: JDK1.8
 * @version V1.0.0
 */
public class PublicSecurity {
	
	/**
	 * <p> 验证学生信息发放派遣证 </p></br>
	 * @Title: checkingStudent  
	 * @date: 2021-04-29 13:08
	 * @param graduates
	 * @return Graduates    
	 * @since: 1.0.0   
	 */
	public static Graduates checkingStudent(Graduates graduates) {
		if(!graduates.getStudentID().isEmpty() && !graduates.getIdentityCard().isEmpty()) {
			return grantDispatch(graduates);	
		}
		return notGrantDispatch(graduates);
	}
	
	/**
	 * <p> 公安发放派遣证 </p></br>
	 * @Title: grantDispatch  
	 * @date: 2021-04-29 13:06
	 * @param graduates
	 * @return Graduates    
	 * @since: 1.0.0   
	 */
	public static Graduates grantDispatch(Graduates graduates) {
		graduates.setDispatch("派遣证");
		return graduates;
	}
	
	/**
	 * <p> 公安不发放派遣证 </p></br>
	 * @Title: notGrantDispatch  
	 * @date: 2021-04-29 13:06
	 * @param graduates
	 * @return Graduates    
	 * @since: 1.0.0   
	 */
	public static Graduates notGrantDispatch(Graduates graduates) {
		graduates.setDispatch("信息有误，不发派遣证");
		return graduates;
	}
}
