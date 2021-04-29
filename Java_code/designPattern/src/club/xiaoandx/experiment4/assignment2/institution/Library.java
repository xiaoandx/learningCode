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
 * <p> 图书馆 </p> 
 *	图书馆根据学生的借书证，退还押金
 * @ClassName:Library   
 * @author: WEI.ZHOU
 * @date: 2021-04-29 13:09
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Library {
	
	/**
	 * <p> 验证借书证，退还押金 </p></br>
	 * @Title: checkingLibraryCardDeposit  
	 * @date: 2021-04-29 13:08
	 * @param graduates
	 * @return Graduates    
	 * @since: 1.0.0   
	 */
	public static Graduates checkingLibraryCardDeposit(Graduates graduates) {
		if(!graduates.getLibraryCard().isEmpty()) {
			return grantLibraryCardDeposit(graduates);	
		}
		return notGrantLibraryCardDeposit(graduates);
	}
	
	/**
	 * <p> 完整退还押金100 </p></br>
	 * @Title: grantLibraryCardDeposit  
	 * @date: 2021-04-29 13:06
	 * @param graduates
	 * @return Graduates    
	 * @since: 1.0.0   
	 */
	public static Graduates grantLibraryCardDeposit(Graduates graduates) {
		graduates.setLibraryCardDeposit(100.00);
		return graduates;
	}
	
	/**
	 * <p> 押金退还为0 </p></br>
	 * @Title: notGrantLibraryCardDeposit  
	 * @date: 2021-04-29 13:06
	 * @param graduates
	 * @return Graduates    
	 * @since: 1.0.0   
	 */
	public static Graduates notGrantLibraryCardDeposit(Graduates graduates) {
		graduates.setLibraryCardDeposit(0.00);
		return graduates;
	}
}
