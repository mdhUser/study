package org.maxwell.wrongcase.apidesign_22.apiversion;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/20 11:15
 */
public class APIVersionHandlerMapping extends RequestMappingHandlerMapping {

    @Override
    protected boolean isHandler(Class<?> beanType) {
        return AnnotatedElementUtils.hasAnnotation(beanType, Controller.class);
    }

    @Override
    protected void registerHandlerMethod(Object handler, Method method, RequestMappingInfo mapping) {
        Class<?> clazz = method.getDeclaringClass();
        //类上的ApiVersion注解
        APIVersion apiVersion = AnnotationUtils.findAnnotation(clazz, APIVersion.class);
        //方法上的APIVersion注解
        APIVersion methodVersion = AnnotationUtils.findAnnotation(method, APIVersion.class);
        //以方法上的注解优先
        if (methodVersion != null)
            apiVersion = methodVersion;

        String[] urlPatterns = apiVersion == null ? new String[0] : apiVersion.value();

        PatternsRequestCondition apiPattern = new PatternsRequestCondition(urlPatterns);
        PatternsRequestCondition oldPattern = mapping.getPatternsCondition();
        PatternsRequestCondition updatedFinalPattern = apiPattern.combine(oldPattern);
        //重新构建RequestMappingInfo
        mapping = new RequestMappingInfo(mapping.getName(),
                updatedFinalPattern,
                mapping.getMethodsCondition(),
                mapping.getParamsCondition(),
                mapping.getHeadersCondition(),
                mapping.getConsumesCondition(),
                mapping.getProducesCondition(),
                mapping.getCustomCondition());
        super.registerHandlerMethod(handler, method, mapping);
    }
}
