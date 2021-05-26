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
package club.xiaoandx.experiment6.assignment2.computer.composite;

import java.util.ArrayList;
import java.util.List;

import club.xiaoandx.experiment6.assignment2.computer.component.Component;

/**  
 * <p> 计算机组件根 </p> 
 * @ClassName:Composite   
 * @author: WEI.ZHOU
 * @date: 2021-05-26 19:33
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Composite extends Component{
	
	/**
	 * 根组件集合，用于保存下面的节点组件
	 */
	private List<Component> child;

	/**   
	 * @Title:  Composite   
	 * @date: 2021-05-26 19:34
	 * @param name 
	 * @since: 1.0.0
	 */
	public Composite(String name) {
		super(name);
		child = new ArrayList<Component>();
	}

	/**   
	 * <p>Title: print</p> 
	 * @date: 2021-05-26 19:34       
	 * @see club.xiaoandx.experiment6.assignment2.computer.component.Component#print()   
	 */
	@Override
	public void print() {
		System.out.println(name);
		for(Component component : child) {
			component.print();
		}
	}

	/**   
	 * <p>Title: add</p> 
	 * @date: 2021-05-26 19:34    
	 * @param component   
	 * @see club.xiaoandx.experiment6.assignment2.computer.component.Component#add(club.xiaoandx.experiment6.assignment2.computer.component.Component)   
	 */
	@Override
	public void add(Component component) {
		child.add(component);
	}

	/**   
	 * <p>Title: remove</p> 
	 * @date: 2021-05-26 19:34    
	 * @param component   
	 * @see club.xiaoandx.experiment6.assignment2.computer.component.Component#remove(club.xiaoandx.experiment6.assignment2.computer.component.Component)   
	 */
	@Override
	public void remove(Component component) {
		child.remove(component);
	}

}
