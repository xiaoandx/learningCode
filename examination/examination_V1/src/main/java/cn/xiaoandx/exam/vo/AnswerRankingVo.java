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
package cn.xiaoandx.exam.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**  
 * <p> 
 *	服务段返回排名数据实体VO
 * </p> 
 * @ClassName:AnswerRankingVo   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:21
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@ApiModel(value = "答题排名")
@Data
public class AnswerRankingVo {
	
	@ApiModelProperty(value =  "用户id",name = "id")
	private Integer user_id;
	@ApiModelProperty(value =  "用户总成绩",name = "total_fraction")
	private Integer total_fraction;
	@ApiModelProperty(value =  "微信昵称",name = "nickname")
	private String nickname;
	@ApiModelProperty(value =  "头像地址",name = "head_portrait")
	private String head_portrait;
	@ApiModelProperty(value =  "城市",name = "city")
	private String city;
}
