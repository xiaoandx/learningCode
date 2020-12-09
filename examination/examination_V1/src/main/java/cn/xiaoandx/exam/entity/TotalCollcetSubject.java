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
package cn.xiaoandx.exam.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**  
 * <p> 
 *	用户答题汇总数据库实体
 * </p> 
 * @ClassName:TotalCollcetSubject   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:25
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@ApiModel(value = "汇总表")
@Data
public class TotalCollcetSubject{
	@ApiModelProperty(value =  "id",name = "id")
	private Integer id;
	@ApiModelProperty(value =  "用户id",name = "userId")
	private Integer userId;
	@ApiModelProperty(value =  "当前累计总分",name = "totalFraction")
	private Integer totalFraction;
	@ApiModelProperty(value =  "累计答对题目总数",name = "sumCorrectSubjectNumber")
	private Integer sumCorrectSubjectNumber;
	@ApiModelProperty(value =  "累计答错题目总数",name = "sumWrongSubjectNumber")
	private Integer sumWrongSubjectNumber;
	@ApiModelProperty(value =  "累计答题总数",name = "sumSubjectNamber")
	private Integer sumSubjectNamber;
	@ApiModelProperty(value =  "权限等级，1为管理员，0为用户",name = "sumSubjectNamber")
	private Integer jurisdiction;

}
