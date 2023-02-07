package org.maxwell.wrongcase.oop_18.annotation;

import java.lang.annotation.*;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/6 20:59
 */

@Inherited //可继承该注解 （限类上）
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface My {
    String value();
}
