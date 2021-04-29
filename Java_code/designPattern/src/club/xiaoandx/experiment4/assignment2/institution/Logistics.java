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
 * <p> 后勤部门 </p> 
 * 根据学生饭卡剩余余额，退补余额
 * @ClassName:Logistics   
 * @author: WEI.ZHOU
 * @date: 2021-04-29 13:15
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Logistics {

	/**
	 * <p> 查看饭卡余额，退还余额 </p></br>
	 * @Title: checkingfoodCardID  
	 * @date: 2021-04-29 13:08
	 * @param graduates
	 * @return Graduates    
	 * @since: 1.0.0   
	 */
	public static Graduates checkingFoodCardID(Graduates graduates) {
		if(!graduates.getFoodCardID().isEmpty()) {
			return grantFoodCardIDDeposit(graduates);	
		}
		return notGrantFoodCardIDDeposit(graduates);
	}
	
	/**
	 * <p> 完整退还饭卡余额100(100测试数据) </p></br>
	 * @Title: grantFoodCardIDDeposit  
	 * @date: 2021-04-29 13:06
	 * @param graduates
	 * @return Graduates    
	 * @since: 1.0.0   
	 */
	public static Graduates grantFoodCardIDDeposit(Graduates graduates) {
		graduates.setLibraryCardDeposit(100.00);
		return graduates;
	}
	
	/**
	 * <p> 饭卡余额退还为0 </p></br>
	 * @Title: notGrantFoodCardIDDeposit  
	 * @date: 2021-04-29 13:06
	 * @param graduates
	 * @return Graduates    
	 * @since: 1.0.0   
	 */
	public static Graduates notGrantFoodCardIDDeposit(Graduates graduates) {
		graduates.setLibraryCardDeposit(0.00);
		return graduates;
	}
}
