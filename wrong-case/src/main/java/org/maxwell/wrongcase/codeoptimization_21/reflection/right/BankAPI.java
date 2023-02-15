package org.maxwell.wrongcase.codeoptimization_21.reflection.right;

import java.lang.annotation.*;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/15 09:40
 */
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BankAPI {

    String desc() default "";

    String url() default "";

}
