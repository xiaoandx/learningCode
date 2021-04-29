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
package club.xiaoandx.experiment4.assignment2;

/**  
 * <p> 大学生毕业生 </p> 
 * @ClassName:Graduates   
 * @author: WEI.ZHOU
 * @date: 2021-04-29 12:28
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Graduates {
	
	/**
	 * 学生证
	 */
	private String studentID;
	
	/**
	 * 毕业证
	 */
	private String diploma;
	
	/**
	 * 学位证
	 */
	private String certificateOfDegree;
	
	/**
	 * 身份证
	 */
	private String identityCard;
	
	/**
	 * 派遣证
	 */
	private String dispatch;
	
	/**
	 * 饭卡
	 */
	private String foodCardID;
	
	/**
	 * 饭卡余额
	 */
	private Double foodCardSurplus;
	
	/**
	 * 借书证
	 */
	private String libraryCard;
	
	/**
	 * 借书证押金
	 */
	private Double libraryCardDeposit;

	/**
	 * @Title:  getStudentID </br>  
	 * @Description: 学生证GET方法 </br>
	 * @return: String </br>  
	 * @return: studentID
	 */
	public String getStudentID() {
		return studentID;
	}

	/**
	 * @Title:  setStudentID </br>  
	 * @Description: 学生证属性的SET方法 </br>  
	 * @return: String </br> 
	 * @param: studentID 要设置的 studentID
	 */
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	/**
	 * @Title:  getDiploma </br>  
	 * @Description: 毕业证GET方法 </br>
	 * @return: String </br>  
	 * @return: diploma
	 */
	public String getDiploma() {
		return diploma;
	}

	/**
	 * @Title:  setDiploma </br>  
	 * @Description: 毕业证属性的SET方法 </br>  
	 * @return: String </br> 
	 * @param: diploma 要设置的 diploma
	 */
	public void setDiploma(String diploma) {
		this.diploma = diploma;
	}

	/**
	 * @Title:  getCertificateOfDegree </br>  
	 * @Description: 学位证GET方法 </br>
	 * @return: String </br>  
	 * @return: certificateOfDegree
	 */
	public String getCertificateOfDegree() {
		return certificateOfDegree;
	}

	/**
	 * @Title:  setCertificateOfDegree </br>  
	 * @Description: 学位证属性的SET方法 </br>  
	 * @return: String </br> 
	 * @param: certificateOfDegree 要设置的 certificateOfDegree
	 */
	public void setCertificateOfDegree(String certificateOfDegree) {
		this.certificateOfDegree = certificateOfDegree;
	}

	/**
	 * @Title:  getIdentityCard </br>  
	 * @Description: 省份证GET方法 </br>
	 * @return: String </br>  
	 * @return: identityCard
	 */
	public String getIdentityCard() {
		return identityCard;
	}

	/**
	 * @Title:  setIdentityCard </br>  
	 * @Description: 身份证属性的SET方法 </br>  
	 * @return: String </br> 
	 * @param: identityCard 要设置的 identityCard
	 */
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	/**
	 * @Title:  getDispatch </br>  
	 * @Description: 派遣证GET方法 </br>
	 * @return: String </br>  
	 * @return: dispatch
	 */
	public String getDispatch() {
		return dispatch;
	}

	/**
	 * @Title:  setDispatch </br>  
	 * @Description: 派遣证属性的SET方法 </br>  
	 * @return: String </br> 
	 * @param: dispatch 要设置的 dispatch
	 */
	public void setDispatch(String dispatch) {
		this.dispatch = dispatch;
	}

	/**
	 * @Title:  getFoodCardID </br>  
	 * @Description: 饭卡GET方法 </br>
	 * @return: String </br>  
	 * @return: foodCardID
	 */
	public String getFoodCardID() {
		return foodCardID;
	}

	/**
	 * @Title:  setFoodCardID </br>  
	 * @Description: 饭卡属性的SET方法 </br>  
	 * @return: String </br> 
	 * @param: foodCardID 要设置的 foodCardID
	 */
	public void setFoodCardID(String foodCardID) {
		this.foodCardID = foodCardID;
	}

	/**
	 * @Title:  getFoodCardSurplus </br>  
	 * @Description: 饭卡余额GET方法 </br>
	 * @return: Double </br>  
	 * @return: foodCardSurplus
	 */
	public Double getFoodCardSurplus() {
		return foodCardSurplus;
	}

	/**
	 * @Title:  setFoodCardSurplus </br>  
	 * @Description: 饭卡余额属性的SET方法 </br>  
	 * @return: Double </br> 
	 * @param: foodCardSurplus 要设置的 foodCardSurplus
	 */
	public void setFoodCardSurplus(Double foodCardSurplus) {
		this.foodCardSurplus = foodCardSurplus;
	}

	/**
	 * @Title:  getLibraryCard </br>  
	 * @Description: 借书证GET方法 </br>
	 * @return: String </br>  
	 * @return: libraryCard
	 */
	public String getLibraryCard() {
		return libraryCard;
	}

	/**
	 * @Title:  setLibraryCard </br>  
	 * @Description: 借书证属性的SET方法 </br>  
	 * @return: String </br> 
	 * @param: libraryCard 要设置的 libraryCard
	 */
	public void setLibraryCard(String libraryCard) {
		this.libraryCard = libraryCard;
	}

	/**
	 * @Title:  getLibraryCardDeposit </br>  
	 * @Description: 借书证押金GET方法 </br>
	 * @return: Double </br>  
	 * @return: libraryCardDeposit
	 */
	public Double getLibraryCardDeposit() {
		return libraryCardDeposit;
	}

	/**
	 * @Title:  setLibraryCardDeposit </br>  
	 * @Description: 借书证押金属性的SET方法 </br>  
	 * @return: Double </br> 
	 * @param: libraryCardDeposit 要设置的 libraryCardDeposit
	 */
	public void setLibraryCardDeposit(Double libraryCardDeposit) {
		this.libraryCardDeposit = libraryCardDeposit;
	}

	/**   
	 * <p>Title: toString</p> 
	 * @date: 2021-04-29 12:45    
	 * @return   
	 * @see java.lang.Object#toString()   
	 */
	@Override
	public String toString() {
		return "Graduates [学生证=" + studentID + ", 毕业证=" + diploma
				+ ", 学位证=" + certificateOfDegree + ", 身份证="
				+ identityCard + ", 派遣证=" + dispatch + "\n 饭卡=" + foodCardID
				+ ", 饭卡余额=" + foodCardSurplus + ", 借书证=" + libraryCard
				+ ", 借书卡押金=" + libraryCardDeposit + "]";
	}
	
	
}
