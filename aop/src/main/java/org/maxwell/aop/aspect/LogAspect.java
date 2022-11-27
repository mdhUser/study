package org.maxwell.aop.aspect;

import com.alibaba.fastjson2.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.maxwell.aop.annotations.RecordOperate;
import org.maxwell.aop.service.Convert;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/27 17:49
 */
@Aspect
@Component
public class LogAspect {

    //定义切入点
    @Pointcut("@annotation(org.maxwell.aop.annotations.RecordOperate)")
    public void pointcut() {
    }

    private final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            1, 2, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100)
    );

    @Around("pointcut()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        threadPoolExecutor.execute(() -> {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            OperateLogDO operateLogDO;
            RecordOperate recordOperate = method.getAnnotation(RecordOperate.class);
            try {
                Convert convert = recordOperate.convert().getConstructor().newInstance();
                operateLogDO = convert.convert(joinPoint.getArgs()[0]);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            operateLogDO.setDesc(recordOperate.desc());
            operateLogDO.setResult(result.toString());
            System.out.println("insert operateLog :" + JSON.toJSONString(operateLogDO));
        });
        return result;
    }

}