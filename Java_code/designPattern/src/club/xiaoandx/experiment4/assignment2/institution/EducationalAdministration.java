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
 * <p> 教务处 </p> 
 *	通过验证学生证然后领取毕业证、学位证
 * @ClassName:EducationalAdministration   
 * @author: WEI.ZHOU
 * @date: 2021-04-29 12:35
 * @since: JDK1.8
 * @version V1.0.0
 */
public class EducationalAdministration {
	
	/**
	 * <p> 大学毕业生验证学生证并获取毕业证，学位证 </p></br>
	 * @Title: checkingStudentID  
	 * @date: 2021-04-29 12:50
	 * @param graduates		（学生证）
	 * @return Graduates    （毕业证，学位证）
	 * @since: 1.0.0   
	 */
	public static Graduates checkingStudentID(Graduates graduates) {
		if(!graduates.getStudentID().isEmpty()) {
			return grantCertificate(graduates);
		}
		return notGrantCertificate(graduates);
	}
	
	/**
	 * <p> 教务处发放毕业证学生证 </p></br>
	 * @Title: grantCertificate  
	 * @date: 2021-04-29 12:57
	 * @param graduates
	 * @return Graduates    
	 * @since: 1.0.0   
	 */
	public static Graduates grantCertificate(Graduates graduates) {
		graduates.setDiploma("毕业证");
		graduates.setCertificateOfDegree("学位证");
		return graduates;
	}
	
	/**
	 * <p> 教务处不发放毕业证学生证 </p></br>
	 * @Title: notGrantCertificate  
	 * @date: 2021-04-29 12:57
	 * @param graduates
	 * @return Graduates    
	 * @since: 1.0.0   
	 */
	public static Graduates notGrantCertificate(Graduates graduates) {
		graduates.setDiploma("不给予毕业");
		graduates.setCertificateOfDegree("不给予毕业");
		return graduates;
	}
}
