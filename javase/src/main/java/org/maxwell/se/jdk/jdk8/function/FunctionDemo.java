package org.maxwell.se.jdk.jdk8.function;

import java.util.function.Function;

/**
 * @description:Function掌握
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/22 21:30
 */

/**
 * 无意义
 */
public class FunctionDemo implements Function {

    @Override
    public Object apply(Object o) {
        return o+"经过apply处理拼接成功!";
    }



}