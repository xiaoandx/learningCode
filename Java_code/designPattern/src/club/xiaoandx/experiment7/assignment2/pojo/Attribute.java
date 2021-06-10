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
package club.xiaoandx.experiment7.assignment2.pojo;

/**  
 * <p> 主角属性 </p> 
 * @ClassName:Attribute   
 * @author: WEI.ZHOU
 * @date: 2021-06-10 09:28
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Attribute {
	
	/**
	 * 姓名
	 */
	private String aname;
	
	/**
	 * 头像
	 */
	private String aheadUrl;
	
	/**
	 * 等级
	 */
	private Integer agrade = 0;
	
	/**
	 * 战斗力
	 */
	private Integer acombatEffectiveeness = 0;
	
	/**
	 * 经验数
	 */
	private Integer aexperience = 0;
	
	/**
	 * 钻石数
	 */
	private Integer adiamonds = 0;
	
	/**
	 * 金币数
	 */
	private Integer agoldCoin = 0;
	
	/**   
	 * <p> 构造器（快速赋值） </p></br>
	 * @Title:  Attribute   
	 * @date: 2021-06-10 09:35
	 * @param aname
	 * @param aheadUrl
	 * @param acombatEffectiveeness
	 * @param aexperience
	 * @param adiamonds
	 * @param agoldCoin 
	 * @since: 1.0.0
	 */
	public Attribute(String aname, String aheadUrl,
			Integer acombatEffectiveeness, Integer aexperience, Integer adiamonds,
			Integer agoldCoin) {
		this.aname = aname;
		this.aheadUrl = aheadUrl;
		this.acombatEffectiveeness = acombatEffectiveeness;
		this.aexperience = aexperience;
		this.adiamonds = adiamonds;
		this.agoldCoin = agoldCoin;
		calculationLevel();
	}

	/**
	 * @Title:  getAname </br>  
	 * @Description: GET方法 </br>
	 * @return: String </br>  
	 * @return: aname
	 */
	public String getAname() {
		return aname;
	}

	/**
	 * @Title:  setAname </br>  
	 * @Description: 属性的SET方法 </br>  
	 * @return: String </br> 
	 * @param: aname 要设置的 aname
	 */
	public void setAname(String aname) {
		this.aname = aname;
	}

	/**
	 * @Title:  getAheadUrl </br>  
	 * @Description: GET方法 </br>
	 * @return: String </br>  
	 * @return: aheadUrl
	 */
	public String getAheadUrl() {
		return aheadUrl;
	}

	/**
	 * @Title:  setAheadUrl </br>  
	 * @Description: 属性的SET方法 </br>  
	 * @return: String </br> 
	 * @param: aheadUrl 要设置的 aheadUrl
	 */
	public void setAheadUrl(String aheadUrl) {
		this.aheadUrl = aheadUrl;
	}

	/**
	 * @Title:  getAgrade </br>  
	 * @Description: GET方法 </br>
	 * @return: Integer </br>  
	 * @return: agrade
	 */
	public Integer getAgrade() {
		return agrade;
	}

	/**
	 * @Title:  setAgrade </br>  
	 * @Description: 属性的SET方法 </br>  
	 * @return: Integer </br> 
	 * @param: agrade 要设置的 agrade
	 */
	public void setAgrade(Integer agrade) {
		this.agrade = agrade;
	}

	/**
	 * @Title:  getAcombatEffectiveeness </br>  
	 * @Description: GET方法 </br>
	 * @return: Integer </br>  
	 * @return: acombatEffectiveeness
	 */
	public Integer getAcombatEffectiveeness() {
		return acombatEffectiveeness;
	}

	/**
	 * @Title:  setAcombatEffectiveeness </br>  
	 * @Description: 属性的SET方法 </br>  
	 * @return: Integer </br> 
	 * @param: acombatEffectiveeness 要设置的 acombatEffectiveeness
	 */
	public void setAcombatEffectiveeness(Integer acombatEffectiveeness) {
		this.acombatEffectiveeness += acombatEffectiveeness;
	}

	/**
	 * @Title:  getAexperience </br>  
	 * @Description: GET方法 </br>
	 * @return: Integer </br>  
	 * @return: aexperience
	 */
	public Integer getAexperience() {
		return aexperience;
	}

	/**
	 * @Title:  setAexperience </br>  
	 * @Description: 属性的SET方法 </br>  
	 * @return: Integer </br> 
	 * @param: aexperience 要设置的 aexperience
	 */
	public void setAexperience(Integer aexperience) {
		this.aexperience += aexperience;
		calculationLevel();
	}

	/**
	 * @Title:  getAdiamonds </br>  
	 * @Description: GET方法 </br>
	 * @return: Integer </br>  
	 * @return: adiamonds
	 */
	public Integer getAdiamonds() {
		return adiamonds;
	}

	/**
	 * @Title:  setAdiamonds </br>  
	 * @Description: 属性的SET方法 </br>  
	 * @return: Integer </br> 
	 * @param: adiamonds 要设置的 adiamonds
	 */
	public void setAdiamonds(Integer adiamonds) {
		this.adiamonds += adiamonds;
	}

	/**
	 * @Title:  getAgoldCoin </br>  
	 * @Description: GET方法 </br>
	 * @return: Integer </br>  
	 * @return: agoldCoin
	 */
	public Integer getAgoldCoin() {
		return agoldCoin;
	}

	/**
	 * @Title:  setAgoldCoin </br>  
	 * @Description: 属性的SET方法 </br>  
	 * @return: Integer </br> 
	 * @param: agoldCoin 要设置的 agoldCoin
	 */
	public void setAgoldCoin(Integer agoldCoin) {
		this.agoldCoin += agoldCoin;
	}

	/**   
	 * <p>Title: toString</p> 
	 * @date: 2021-06-10 09:34    
	 * @return   
	 * @see java.lang.Object#toString()   
	 */
	@Override
	public String toString() {
		return "Attribute [aname=" + aname + ", aheadUrl=" + aheadUrl + ", agrade="
				+ agrade + ", acombatEffectiveeness=" + acombatEffectiveeness
				+ ", aexperience=" + aexperience + ", adiamonds=" + adiamonds
				+ ", agoldCoin=" + agoldCoin + "]";
	}
	
	/**
	 * <p> 计算英雄等级 </p></br>
	 *	计算说明：等级  = 英雄经验 /1000 +(英雄经验%1000 != 0 ? 1 : 0)
	 * @Title: calculationLevel  
	 * @date: 2021-06-10 09:37 void    
	 * @since: 1.0.0   
	 */
	protected void calculationLevel() {
		this.agrade = (this.aexperience / 1000) + (this.aexperience % 1000 != 0 ? 1 : 0);
	}
}
