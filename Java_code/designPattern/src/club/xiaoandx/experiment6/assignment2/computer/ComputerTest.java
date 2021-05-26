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
package club.xiaoandx.experiment6.assignment2.computer;

import club.xiaoandx.experiment6.assignment2.computer.composite.Composite;
import club.xiaoandx.experiment6.assignment2.computer.leaf.Leaf;

/**  
 * <p>	组装电脑测试  </p> 
 * @ClassName:ComputerTest   
 * @author: WEI.ZHOU
 * @date: 2021-05-26 19:42
 * @since: JDK1.8
 * @version V1.0.0
 */
public class ComputerTest {
	
	public static void main(String[] args) {
		Composite root = new Composite("xiaoandx电脑");
		Leaf keyboard = new Leaf("键盘");
		Leaf monitor = new Leaf("显示器");
		Leaf mouse = new Leaf("鼠标");
		Composite chassis = new Composite("机箱");
		root.add(keyboard);
		root.add(monitor);
		root.add(mouse);
		root.add(chassis);
		Leaf disk = new Leaf("硬盘");
		Leaf powerSupply = new Leaf("电源");
		Composite mainBoard = new Composite("主板");
		chassis.add(disk);
		chassis.add(powerSupply);
		chassis.add(mainBoard);
		Leaf cpu = new Leaf("CPU");
		Leaf graphicsCard = new Leaf("显卡");
		Leaf networkCard = new Leaf("网卡");
		mainBoard.add(cpu);
		mainBoard.add(graphicsCard);
		mainBoard.add(networkCard);
		root.print();
	}
}
