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

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**  
 * <p> 
 *	用户答题统计VO (分天进行统计)
 * </p> 
 * @ClassName:UserDayAnswer   
 * @author: WEI.ZHOU
 * @date: 2020-12-07 20:15
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@ApiModel(value = "xx用户答题统计分天进行统计")
@Data
public class UserDayAnswer {
	
	@ApiModelProperty(value = "答题时间",name = "answerTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd ")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date answerTime;
	@ApiModelProperty(value = "答题总数",name = "subTotal")
	private Integer subTotal;
	@ApiModelProperty(value = "答对总数",name = "correctNumber")
	private Integer correctNumber;
	@ApiModelProperty(value = "答错总数",name = "errorNUmber")
	private Integer errorNUmber;
	@ApiModelProperty(value = "当天总分",name = "dayScore")
	private Integer dayScore;
}
