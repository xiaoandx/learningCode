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
package cn.xiaoandx.commons.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**  
 * <p> 
 *	统一日志记录配置，目前只记录的web端入口地方的日志
 * </p> 
 * @ClassName:AspectLog   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:31
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@Aspect
@Component
@Slf4j
public class AspectLog {

	@Pointcut("execution(public * cn.xiaoandx..controller..*Controller.*(..))")
    public void aspectLog(){}


    @Around("aspectLog()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            long starttime = System.currentTimeMillis();
            Object result = joinPoint.proceed();

            if(log.isDebugEnabled()) {
            	Object[] args = joinPoint.getArgs();
                log.debug("{} {} Params[{}] Response[{}] speed time:[{}]ms", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), Arrays.toString(args), result, (System.currentTimeMillis() - starttime));
            }
            return result;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    @AfterThrowing(pointcut = "aspectLog()",throwing= "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        log.warn("{} {} Params[{}] ,throws: [{}]", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()), error.getMessage());
    }
}