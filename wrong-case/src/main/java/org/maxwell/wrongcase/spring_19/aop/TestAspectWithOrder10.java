package org.maxwell.wrongcase.spring_19.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(10)
@Slf4j
public class TestAspectWithOrder10 {
    @Before("execution(* org.maxwell.wrongcase.spring_19.aop.TestController.*(..))")
    public void before(JoinPoint joinPoint) throws Throwable {
        log.info("TestAspectWithOrder10 @Before");
    }

    @After("execution(* org.maxwell.wrongcase.spring_19.aop.TestController.*(..))")
    public void after(JoinPoint joinPoint) throws Throwable {
        log.info("TestAspectWithOrder10 @After");
    }

    @Around("execution(* org.maxwell.wrongcase.spring_19.aop.TestController.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("TestAspectWithOrder10 @Around before");
        Object o = pjp.proceed();
        log.info("TestAspectWithOrder10 @Around after");
        return o;
    }
}
