/*
 * Copyright 2019-2020 the original WEI.ZHOU.
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
package cn.xiaoandx.user.entity;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**  
 * <p> 
 *	用户实体
 * </p> 
 * @ClassName:User   
 * @author: WEI.ZHOU
 * @date: 2020-12-07 20:13
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@ApiModel("用户实体类")
@Data
public class User {
	@ApiModelProperty(dataType = "Integer",name = "id",value = "用户id")
	private Integer id;
	
	@ApiModelProperty(dataType = "String",name = "openId",value = "微信用户唯一标识id")
	private String openId;
	
	@ApiModelProperty(dataType = "String",name = "headPortrait",value = "微信头像地址")
	private String headPortrait;
	
	@ApiModelProperty(dataType = "String",name = "nickname",value = "微信用户昵称")
	private String nickname;
	
	@ApiModelProperty(dataType = "String",name = "country",value = "用户所在的国家")
	private String country;
	
	@ApiModelProperty(dataType = "String",name = "province",value = "用户所在的省份")
	private String province;
	
	@ApiModelProperty(dataType = "String",name = "city",value = "用户所在的城市")
	private String city;
	
	@ApiModelProperty(dataType = "Date",name = "creationTime",value = "用户注册时间")
	private Date creationTime;
	
	@ApiModelProperty(dataType = "String",name = "token",value = "人脸识别用户唯一id")
	private String token;
	
	@ApiModelProperty(dataType = "Integer", value =  "权限等级，1为管理员，0为用户",name = "sumSubjectNamber")
	private Integer jurisdiction;
	
}
