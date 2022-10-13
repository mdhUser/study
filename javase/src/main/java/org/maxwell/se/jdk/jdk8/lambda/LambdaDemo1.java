package org.maxwell.se.jdk.jdk8.lambda;

import org.maxwell.se.jdk.jdk8.inter.OperFunction;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/22 20:54
 */
public class LambdaDemo1 {

    public static void main(String[] args) {
        int num = operator(20, 5, (x, y) -> x * y);
        System.out.println(num);
    }


    public static Integer operator(Integer x, Integer y, OperFunction<Integer, Integer> op) {
        return op.operator(x, y);
    }
}
