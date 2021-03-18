/*
 * Copyright 2019-2021 the original WEI.ZHOU.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package club.xiaoandx.experiment1.test1.strategy.role;

import club.xiaoandx.experiment1.test1.strategy.magic.MagicBehavior;
import club.xiaoandx.experiment1.test1.strategy.weapon.WeaponBehavior;

/**  
 * <p> 
 *
 * </p> 
 * @ClassName:Role   
 * @author: WEI.ZHOU
 * @date: 2021-03-18 17:23
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
public class Role {
	private String userType;
	private MagicBehavior magicBehavior = null;
	private WeaponBehavior weaponBehavio = null;

	/**
	 * @Title: Role
	 * @Description: TODO(同时拥有两种攻击技能)
	 */
	public Role(String userType, MagicBehavior magicBehavior, WeaponBehavior weaponBehavio) {
		// TODO 自动生成的构造函数存根
		this.userType = userType;
		this.magicBehavior = magicBehavior;
		this.weaponBehavio = weaponBehavio;
	}

	/**
	 * @Title: Role
	 * @Description: TODO(只拥有魔法攻击)
	 */
	public Role(String userType, MagicBehavior magicBehavior) {
		// TODO 自动生成的构造函数存根
		this.userType = userType;
		this.magicBehavior = magicBehavior;
	}

	/**
	 * @Title: Role
	 * @Description: TODO(只拥有物理攻击)
	 */
	public Role(String userType, WeaponBehavior weaponBehavio) {
		// TODO 自动生成的构造函数存根
		this.userType = userType;
		this.weaponBehavio = weaponBehavio;
	}
	
	/**
	 * @Title: Role
	 * @Description: TODO(只拥有物理攻击)
	 */
	public Role(String userType) {
		// TODO 自动生成的构造函数存根
		this.userType = userType;
	}

	public void attack() {
		if (magicBehavior != null && weaponBehavio != null) {
			System.out.println(userType + "使用" + magicBehavior.play() + "与" + weaponBehavio.play() + "进行攻击");
		}else if (weaponBehavio != null){
			System.out.println(userType + "使用" + weaponBehavio.play() + "进行攻击");
		}else if (magicBehavior != null){
			System.out.println(userType + "使用" + magicBehavior.play() + "进行攻击");
		}else {
			System.out.println(userType + "没有攻击技能");
		}
	}

}
