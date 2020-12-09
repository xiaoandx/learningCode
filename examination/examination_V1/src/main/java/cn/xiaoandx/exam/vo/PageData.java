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
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**  
 * <p> 
 *	分页数据对象
 * </p> 
 * @ClassName:PageData   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:18
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@SuppressWarnings("serial")
@ApiModel(description="分页数据对象")
@ToString
public class PageData<T> implements java.io.Serializable{
    @ApiModelProperty(value = "分页数据")
    @Getter @Setter private PageDomain page = new PageDomain();
    @ApiModelProperty(value = "数据内容")
    @Getter @Setter private List<T> data = new ArrayList<T>();
}
