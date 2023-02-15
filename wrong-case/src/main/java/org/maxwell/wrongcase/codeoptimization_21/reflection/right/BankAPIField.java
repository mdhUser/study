package org.maxwell.wrongcase.codeoptimization_21.reflection.right;

import java.lang.annotation.*;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/15 09:46
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Inherited
public @interface BankAPIField {

    int order() default -1;

    int length() default -1;

    BankAPIFieldType type();

}
