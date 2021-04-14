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
package club.xiaoandx.structure.adapter.interfa.impl;

import club.xiaoandx.structure.adapter.interfa.Duck;
import club.xiaoandx.structure.adapter.interfa.Turkey;

/**  
 * <p> 鸭子 </p> 
 * @ClassName:TurkeyAdapter   
 * @author: WEI.ZHOU
 * @date: 2021-04-14 17:19
 * @since: JDK1.8
 * @version V1.0.0
 */
public class TurkeyAdapter implements Duck {

	Turkey turkey ;
	
	/**   
	 * <p>  </p></br>
	 * @Title:  TurkeyAdapter   
	 * @date: 2021-04-14 17:24 
	 * @since: 1.0.0
	 */
	public TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}
	
	/**   
	 * <p> 火鸡叫 </p></br>
	 * <p>Title: quack</p> 
	 * @date: 2021-04-14 17:19       
	 * @see club.xiaoandx.structure.adapter.interfa.Duck#quack()   
	 */
	@Override
	public void quack() {
		//	火鸡冒充鸭子叫
		turkey.gobble();
	}

}
