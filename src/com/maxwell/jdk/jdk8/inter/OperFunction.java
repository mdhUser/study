package com.maxwell.jdk.jdk8.inter;

/**
 * @description:自定义函数式接口
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/22 20:56
 */
@FunctionalInterface
public interface OperFunction <R,T>{

    R operator(T t1,T t2);


}
