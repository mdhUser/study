package org.maxwell.wrongcase.spring_20;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/9 15:54
 */
@Slf4j
@Aspect
@Component
public class WrongAspect {


    @Before("within(feign.Client+)")
    //可以切到但是不符合要求
    //@Before("@within(org.springframework.cloud.openfeign.FeignClient)")
    public void before(JoinPoint pjp) {
        log.info("within(feign.Client+) pjp {}, args:{}", pjp, pjp.getArgs());
    }


}
