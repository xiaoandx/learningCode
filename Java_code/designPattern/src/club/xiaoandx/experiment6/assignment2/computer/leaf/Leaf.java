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
package club.xiaoandx.experiment6.assignment2.computer.leaf;

import club.xiaoandx.experiment6.assignment2.abnormal.UNrealizationException;
import club.xiaoandx.experiment6.assignment2.computer.component.Component;

/**  
 * <p> 组件节点 </p> 
 * @ClassName:Leaf   
 * @author: WEI.ZHOU
 * @date: 2021-05-26 19:39
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Leaf extends Component{

	/**   
	 * @Title:  Leaf   
	 * @date: 2021-05-26 19:39
	 * @param name 
	 * @since: 1.0.0
	 */
	public Leaf(String name) {
		super(name);
	}

	/**   
	 * <p>Title: print</p> 
	 * @date: 2021-05-26 19:39       
	 * @see club.xiaoandx.experiment6.assignment2.computer.component.Component#print()   
	 */
	@Override
	public void print() {
		System.out.println(name);
	}

	/**   
	 * <p>Title: add</p> 
	 * @date: 2021-05-26 19:39    
	 * @param component   
	 * @see club.xiaoandx.experiment6.assignment2.computer.component.Component#add(club.xiaoandx.experiment6.assignment2.computer.component.Component)   
	 */
	@Override
	public void add(Component component) {
		throw new UNrealizationException();
	}

	/**   
	 * <p>Title: remove</p> 
	 * @date: 2021-05-26 19:39    
	 * @param component   
	 * @see club.xiaoandx.experiment6.assignment2.computer.component.Component#remove(club.xiaoandx.experiment6.assignment2.computer.component.Component)   
	 */
	@Override
	public void remove(Component component) {
		throw new UNrealizationException();
	}

}
