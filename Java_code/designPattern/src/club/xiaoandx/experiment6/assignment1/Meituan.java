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
package club.xiaoandx.experiment6.assignment1;

import club.xiaoandx.experiment6.assignment1.business.MenuItem;
import club.xiaoandx.experiment6.assignment1.business.dinerMenu.DinerMenu;
import club.xiaoandx.experiment6.assignment1.business.drypan.DryPanMenu;
import club.xiaoandx.experiment6.assignment1.business.hotpot.HotPotMenu;
import club.xiaoandx.experiment6.assignment1.business.pancakeHouse.PancakeHouseMenu;
import club.xiaoandx.experiment6.assignment1.iterator.Iterator;

/**  
 * <p> 美团商店菜单整合 </p> 
 * @ClassName:Meituan   
 * @author: WEI.ZHOU
 * @date: 2021-05-26 18:11
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Meituan {
	DinerMenu dinerMenu;
	DryPanMenu dryPanMenu;
	HotPotMenu hotPotMenu;
	PancakeHouseMenu pancakeHouseMenu;
	
	/**   
	 * @Title:  Meituan   
	 * @date: 2021-05-26 18:13
	 * @param dinerMenu
	 * @param dryPanMenu
	 * @param hotPotMenu
	 * @param pancakeHouseMenu 
	 * @since: 1.0.0
	 */
	public Meituan(DinerMenu dinerMenu, DryPanMenu dryPanMenu, HotPotMenu hotPotMenu,
			PancakeHouseMenu pancakeHouseMenu) {
		this.dinerMenu = dinerMenu;
		this.dryPanMenu = dryPanMenu;
		this.hotPotMenu = hotPotMenu;
		this.pancakeHouseMenu = pancakeHouseMenu;
	}

	/**   
	 * @Title:  Meituan   
	 * @date: 2021-05-26 18:14
	 * @param dryPanMenu 
	 * @since: 1.0.0
	 */
	public Meituan(DryPanMenu dryPanMenu) {
		this.dryPanMenu = dryPanMenu;
	}

	/**   
	 * @Title:  Meituan   
	 * @date: 2021-05-26 18:14
	 * @param dinerMenu 
	 * @since: 1.0.0
	 */
	public Meituan(DinerMenu dinerMenu) {
		this.dinerMenu = dinerMenu;
	}

	/**   
	 * @Title:  Meituan   
	 * @date: 2021-05-26 18:15
	 * @param hotPotMenu 
	 * @since: 1.0.0
	 */
	public Meituan(HotPotMenu hotPotMenu) {
		this.hotPotMenu = hotPotMenu;
	}

	/**   
	 * @Title:  Meituan   
	 * @date: 2021-05-26 18:15
	 * @param pancakeHouseMenu 
	 * @since: 1.0.0
	 */
	public Meituan(PancakeHouseMenu pancakeHouseMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
	}
	
	/**
	 * <p> 美团对外提供的输出代理商店的全部菜单 </p></br>
	 * @Title: printMenus  
	 * @date: 2021-05-26 18:54 void    
	 * @since: 1.0.0   
	 */
	public void printMenus() {
		Iterator dryPanMenuItertor = dryPanMenu.createIterator();
		Iterator dinerMenuItertor = dinerMenu.createIterator();
		Iterator hotPotMenuItertor = hotPotMenu.createIterator();
		Iterator pancakeHouseMenuItertor = pancakeHouseMenu.createIterator();
		printMenuItem(dryPanMenuItertor);
		printMenuItem(dinerMenuItertor);
		printMenuItem(hotPotMenuItertor);
		printMenuItem(pancakeHouseMenuItertor);
	}

	/**
	 * <p> 循环遍历输出每家店的菜单 </p></br>
	 * @Title: printMenuItem  
	 * @date: 2021-05-26 18:55
	 * @param menuItertor void    
	 * @since: 1.0.0   
	 * @throws
	 */
	private void printMenuItem(Iterator menuItertor) {
		while (menuItertor.hasNext()) {
			MenuItem next = (MenuItem) menuItertor.next();
			System.out.print(next.getName() + " " + next.getDescription() + " 价格："
					+ next.getPrice() + "\n");
		}
		System.out.println();
	}
	
}
