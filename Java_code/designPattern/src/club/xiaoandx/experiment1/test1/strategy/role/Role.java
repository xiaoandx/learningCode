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

import club.xiaoandx.experiment1.test1.strategy.commons.utils.ObjectUtil;
import club.xiaoandx.experiment1.test1.strategy.magic.MagicBehavior;
import club.xiaoandx.experiment1.test1.strategy.weapon.WeaponBehavior;

/**  
 * <p> 英雄人物抽象类，可以使用魔法或者物理技能进行攻击</p> 
 * @ClassName:Role   
 * @author: WEI.ZHOU
 * @date: 2021-03-18 17:23
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
public class Role {
	/**
	 * 英雄类型 完整英雄角色参考.commons.core.RoleType.java
	 */
	private String userType;
	
	/**
	 * 魔法技能接口
	 */
	private MagicBehavior magicBehavior = null;
	
	/**
	 * 物理技能接口
	 */
	private WeaponBehavior weaponBehavior = null;

	/**
	 * @Title: Role
	 * @Description: 同时拥有两种攻击技能
	 */
	public Role(String userType, MagicBehavior magicBehavior, WeaponBehavior weaponBehavior) {
		this.userType = userType;
		this.magicBehavior = magicBehavior;
		this.weaponBehavior = weaponBehavior;
	}

	/**
	 * @Title: Role
	 * @Description: 只拥有魔法攻击
	 */
	public Role(String userType, MagicBehavior magicBehavior) {
		this.userType = userType;
		this.magicBehavior = magicBehavior;
	}

	/**
	 * @Title: Role
	 * @Description: 只拥有物理攻击
	 */
	public Role(String userType, WeaponBehavior weaponBehavior) {
		this.userType = userType;
		this.weaponBehavior = weaponBehavior;
	}
	
	/**
	 * @Title: Role
	 * @Description: 
	 */
	public Role(String userType) {
		this.userType = userType;
	}
	
	/**
	 * 
	 * <p> 角色使用技能 </p></br>
	 * 
	 * <pre> 
	 * 	1.角色可以使用物理 + 魔法技能进行攻击
	 * 	2.角色只使用魔法技能
	 * 	3.角色只使用物理技能
	 * 	4.角色没有技能
	 * </pre></br>
	 * @Title: attack       
	 * @return: void 
	 * @since: 1.0      
	 */
	public void attack() {
		if(ObjectUtil.isNotNull(magicBehavior) && ObjectUtil.isNotNull(weaponBehavior)) {
			System.out.println(userType + "使用" + magicBehavior.play() + "与" 
								+ weaponBehavior.play() + "进行攻击");
		}else if (ObjectUtil.isNotNull(weaponBehavior)){
			System.out.println(userType + "使用" + weaponBehavior.play() + "进行攻击");
		}else if (ObjectUtil.isNotNull(magicBehavior)){
			System.out.println(userType + "使用" + magicBehavior.play() + "进行攻击");
		}else {
			System.out.println(userType + "没有任何攻击技能");
		}
	}

}
