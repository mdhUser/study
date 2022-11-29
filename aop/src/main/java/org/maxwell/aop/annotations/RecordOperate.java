package org.maxwell.aop.annotations;

import org.maxwell.aop.service.Convert;

import java.lang.annotation.*;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/27 17:46
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RecordOperate {

    String desc() default "";

    Class<? extends Convert<?>> convert();

}
