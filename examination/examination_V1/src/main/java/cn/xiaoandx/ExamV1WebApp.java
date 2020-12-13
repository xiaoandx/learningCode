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
package cn.xiaoandx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**  
 * <p> 
 *	examination_V1项目启动
 * </p> 
 * @ClassName:ExamV1WebApp   
 * @author: WEI.ZHOU
 * @date: 2020-12-07 20:09
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@SpringBootApplication
@EnableSwagger2
public class ExamV1WebApp extends SpringBootServletInitializer  {

	public static void main(String[] args) {
		SpringApplication.run(ExamV1WebApp.class, args);
	}
	
	/**   
	 * <p>Title: configure</p>   
	 * <p>Description: </p>   
	 * @param builder
	 * @return   
	 * @see org.springframework.boot.web.servlet.support.SpringBootServletInitializer
	 * 		#configure(org.springframework.boot.builder.SpringApplicationBuilder)   
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ExamV1WebApp.class);
	}

}
