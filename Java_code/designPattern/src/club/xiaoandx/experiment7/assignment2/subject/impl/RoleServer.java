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
package club.xiaoandx.experiment7.assignment2.subject.impl;

import java.util.ArrayList;

import club.xiaoandx.experiment7.assignment2.observer.PanelObserver;
import club.xiaoandx.experiment7.assignment2.pojo.Attribute;
import club.xiaoandx.experiment7.assignment2.subject.Subject;

/**  
 * <p> 游戏角色服务器 </p> 
 * @ClassName:RoleServer  
 * @author: WEI.ZHOU
 * @date: 2021-06-03 10:45
 * @since: JDK1.8
 * @version V1.0.0
 */
public class RoleServer implements Subject{
	
	/**
	 * 面板UI注册中心
	 */
	private ArrayList<PanelObserver> panelList;
	
	/**
	 * 游戏角色数据
	 */
	private Attribute attribute;
 
	/**
	 * <p> 构造器 初始化注册中心与角色数据 </p></br>
	 * @Title:  HeadHunter   
	 * @date: 2021-06-10 10:19
	 * @param attribute 		游戏人物角色
	 * @since: 1.0.0
	 */
	public RoleServer(Attribute attribute){
		panelList = new ArrayList<PanelObserver>();
		this.attribute = attribute;
	}

	/**   
	 * <p> 注册面板到服务器</p></br>
	 * <p>Title: registerObserver</p> 
	 * @date: 2021-06-03 10:46    
	 * @param o   		面板
	 * @see club.xiaoandx.experiment7.assignment1.subject.Subject#registerObserver(club.xiaoandx.experiment7.assignment1.observer.Observer)   
	 */
	@Override
	public void registerObserver(PanelObserver o) {
		int i = panelList.indexOf(o);
		if (null != o && i < 0) {
			panelList.add(o);
		}
	}

	/**   
	 * <p>从面板中移除面板</p></br>
	 * <p>Title: removeObserver</p> 
	 * @date: 2021-06-03 10:46    
	 * @param o  		面板
	 * @see club.xiaoandx.experiment7.assignment1.subject.Subject#removeObserver(club.xiaoandx.experiment7.assignment1.observer.Observer)   
	 */
	@Override
	public void removeObserver(PanelObserver o) {
		int i = panelList.indexOf(o);
		if (i >= 0) {
			panelList.remove(i);
		}
	}
	
	/**
	 * <p> 属性修改  </p></br>
	 * <p>修改说明：头像、名称都是进行替换修改；战斗力、经验、金币何钻石是根据传入的数据正负进行数据迭代更新</p> 
	 * @Title: updataRole  
	 * @date: 2021-06-10 10:23
	 * @param aname					角色新名称
	 * @param aheadUrl				角色新头像地址
	 * @param acombatEffectiveeness	战斗力
	 * @param aexperience			经验
	 * @param adiamonds				钻石数
	 * @param agoldCoin void    	金币数
	 * @since: 1.0.0   
	 */
	public void updataRole(String aname, String aheadUrl,
			Integer acombatEffectiveeness, Integer aexperience, Integer adiamonds,
			Integer agoldCoin) {
		this.attribute.setAname(aname);
		this.attribute.setAheadUrl(aheadUrl);
		this.attribute.setAcombatEffectiveeness(acombatEffectiveeness);
		this.attribute.setAexperience(aexperience);
		this.attribute.setAdiamonds(adiamonds);
		this.attribute.setAgoldCoin(agoldCoin);
		notifyAllObservers();
	}
	
	/**
	 * <p> 属性修改  </p></br>
	 * <p>修改说明：战斗力、经验、金币何钻石是根据传入的数据正负进行数据迭代更新</p> 
	 * @Title: updataRole  
	 * @date: 2021-06-10 10:23
	 * @param acombatEffectiveeness	战斗力
	 * @param aexperience			经验
	 * @param adiamonds				钻石数
	 * @param agoldCoin void    	金币数
	 * @since: 1.0.0   
	 */
	public void updataRole(Integer acombatEffectiveeness, Integer aexperience, 
			Integer adiamonds,Integer agoldCoin) {
		this.attribute.setAcombatEffectiveeness(acombatEffectiveeness);
		this.attribute.setAexperience(aexperience);
		this.attribute.setAdiamonds(adiamonds);
		this.attribute.setAgoldCoin(agoldCoin);
		notifyAllObservers();
	}

	/**
	 * <p> 通知注册中心的所有面板更新最新的游戏人物数据  </p></br>
	 * <p>Title: notifyAllObservers</p> 
	 * @date: 2021-06-03 10:53       
	 * @see club.xiaoandx.experiment7.assignment1.subject.Subject#notifyAllObservers()
	 */
	@Override
	public void notifyAllObservers() {
		if (null != panelList && panelList.size() > 0) {
			for (PanelObserver o : panelList) {
				o.update(attribute);
			}
		}
	}
}
