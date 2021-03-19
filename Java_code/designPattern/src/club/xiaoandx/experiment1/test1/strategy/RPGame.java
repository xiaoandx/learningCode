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
package club.xiaoandx.experiment1.test1.strategy;

import club.xiaoandx.experiment1.test1.strategy.commons.core.RoleType;
import club.xiaoandx.experiment1.test1.strategy.magic.MagicBehavior;
import club.xiaoandx.experiment1.test1.strategy.magic.imp.FireballMagic;
import club.xiaoandx.experiment1.test1.strategy.role.Role;
import club.xiaoandx.experiment1.test1.strategy.weapon.WeaponBehavior;
import club.xiaoandx.experiment1.test1.strategy.weapon.imp.Axe;

class King extends Role {

	/**
	 * @Title: King RPG 游戏人物 国王 @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param: @param userType @param: @param
	 * magicBehavior @param: @param weaponBehavio @throws
	 */
	public King(MagicBehavior magicBehavior, WeaponBehavior weaponBehavio) {
		super(RoleType.GAME_USER_TYPE_KIND, magicBehavior, weaponBehavio);
	}

}

/**
 * <p>
 * 角色发生攻击技能测试方法
 * </p>
 * 
 * @ClassName:RPGame
 * @author: WEI.ZHOU
 * @date: 2021-03-18 16:32
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
public class RPGame {
	public static void main(String[] args) {
		King king = new King(new FireballMagic(), new Axe());
		king.attack();
	}

}