package org.maxwell.se.base.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * @description:自定义注解
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/21 14:28
 */

@Target({METHOD, TYPE}) //表示这个注解可以用用在类/接口上，还可以用在方法上
@Retention(RetentionPolicy.RUNTIME)//表示这是一个运行时注解，即运行起来之后，才获取注解中的相关信息
@Inherited //表示这个注解可以被子类继承
@Documented //表示当执行javadoc的时候，本注解会生成相关文档
public @interface JDBCConfigs {

    JDBCConfig[] value();

}
