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
package club.xiaoandx.experiment6.assignment2;

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
		Composite root = new Composite("玩“绝地求生”游戏电脑的配置：");
		Leaf keyboard = new Leaf("\t键盘：阿米洛VA87M");
		Leaf monitor = new Leaf("\t显示器：明基PD3220U");
		Leaf mouse = new Leaf("\t鼠标：罗技G903无线鼠标");
		Composite chassis = new Composite("\t机箱：Tt Level 20");
		root.add(keyboard);
		root.add(monitor);
		root.add(mouse);
		root.add(chassis);
		Leaf disk = new Leaf("\t\t硬盘：东芝RC500 100T");
		Leaf powerSupply = new Leaf("\t\t电源：1200W");
		Composite mainBoard = new Composite("\t\t主板：B450M");
		chassis.add(disk);
		chassis.add(powerSupply);
		chassis.add(mainBoard);
		Leaf cpu = new Leaf("\t\t\tcpu：AMD Ryzen ThreadRipper 3990X");
		Leaf graphicsCard = new Leaf("\t\t\t显卡：NVIDIA GeForce RTX 3090");
		Leaf networkCard = new Leaf("\t\t\t网卡：Intel X710-T4");
		mainBoard.add(cpu);
		mainBoard.add(graphicsCard);
		mainBoard.add(networkCard);
		root.print();
	}
}
