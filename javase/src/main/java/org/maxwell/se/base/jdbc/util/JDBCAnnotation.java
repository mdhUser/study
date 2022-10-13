package org.maxwell.se.base.jdbc.util;

import java.lang.annotation.*;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/27 16:17
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JDBCAnnotation {

    String url() default "";

    String username() default "";

    String password()default "";
}
