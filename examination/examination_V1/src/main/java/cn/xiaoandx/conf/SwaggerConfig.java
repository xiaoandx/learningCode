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
package cn.xiaoandx.conf;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;


/**  
 * <p> 
 *	swagger 接口配置
 * </p> 
 * @ClassName:SwaggerConfig   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:28
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@SuppressWarnings("unchecked")
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Value("${sys.version}")
	private String systemPublish;
	
	
	
	@Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("用户登录注册相关API")
                .pathMapping("/")
                .select()
                .paths(or(regex("/v1/open/user/.*")))//过滤的接口
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title("用户登录注册相关API")
                        .version(systemPublish)
                        .build());
    }
	
	@Bean
    public Docket examApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("用户答题操作相关API")
                .pathMapping("/")
                .select()
                .paths(or(regex("/v1/open/exam/.*")))//过滤的接口
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title("用户答题操作相关API")
                        .version(systemPublish)
                        .build());
    }
	
	@Bean
    public Docket examPoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("管理员试题操作相关API")
                .pathMapping("/")
                .select()
                .paths(or(regex("/v1/open/examPo/.*")))//过滤的接口
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title("管理员试题操作相关API")
                        .version(systemPublish)
                        .build());
    }
}