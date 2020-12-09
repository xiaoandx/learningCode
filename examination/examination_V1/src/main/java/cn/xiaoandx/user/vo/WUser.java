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
package cn.xiaoandx.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**  
 * <p> 
 *	用户注册VO视图
 * </p> 
 * @ClassName:WUser   
 * @author: WEI.ZHOU
 * @date: 2020-12-07 20:10
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@ApiModel(value = "用户基本信息")
@Data
public class WUser {
	@ApiModelProperty(value = "用户临时code",name = "code")
	private String code;
	@ApiModelProperty(value = "用户微信头像地址",name = "headPortrait")
	private String headPortrait;
	@ApiModelProperty(value = "用户微信昵称",name = "nickname")
	private String nickname;
	@ApiModelProperty(value = "用户微信的国家",name = "country")
	private String country;
	@ApiModelProperty(value = "用户微信的省份",name = "province")
	private String province;
	@ApiModelProperty(value = "用户微信的城市",name = "city")
	private String city;
	 
}
