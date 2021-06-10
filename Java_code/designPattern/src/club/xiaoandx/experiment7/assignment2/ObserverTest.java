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
package club.xiaoandx.experiment7.assignment2;

import club.xiaoandx.experiment7.assignment2.observer.impl.ColorPanel;
import club.xiaoandx.experiment7.assignment2.observer.impl.DynamicPanel;
import club.xiaoandx.experiment7.assignment2.pojo.Attribute;
import club.xiaoandx.experiment7.assignment2.subject.impl.RoleServer;

/**  
 * <p> 求职学生去中介公司进行求职质询-测试类 </p> 
 * @ClassName:ObserverTest   
 * @author: WEI.ZHOU
 * @date: 2021-06-03 11:08
 * @since: JDK1.8
 * @version V1.0.0
 */
public class ObserverTest {
	public static void main(String[] args) {
		/*
		 * 测试说明：
		 * 1.先实例化创建一个游戏角色服务器（初始化一个游戏角色）
		 * 2.创建几个显示数据的UI面板，并将面板注册到服务器中
		 * 3.更新服务器中游戏数据，通知所有的面板更新显示
		 */
		Attribute attribute = new Attribute("小周", "https://img.xiaoandx.club/open/head.png", 
				1000, 1000, 1000, 1000);
 		RoleServer roleServer = new RoleServer(attribute);
 		
 		ColorPanel blackPanel = new ColorPanel("黑色");
 		ColorPanel bluePanel = new ColorPanel("蓝色");
 		DynamicPanel dynamicPanel = new DynamicPanel("可视化面板");
 		roleServer.registerObserver(bluePanel);
 		roleServer.registerObserver(blackPanel);
 		roleServer.registerObserver(dynamicPanel);
 		
 		//	更新游戏人物数据
 		roleServer.updataRole(1487, 2383, 2494, 2342);
	}
}
