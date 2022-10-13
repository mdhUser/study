package org.maxwell.se.jdk.jdk8.function;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/22 21:36
 */
public class FunctionTest {


    public static void main(String[] args) {
        test("org/maxwell/se", o -> o + "经过apply处理拼接成功!");
        Function<Integer, Integer> func = a -> a * 100;
        int a = func.apply(10);
        System.out.println("a = " + a);
        System.out.println("===================");

        BiFunction<Integer, Integer, Integer> function = (x, y) -> x + y;
        int result = function.apply(45, 2);
        System.out.println("result = " + result);

    }

    public static Integer operator(Integer x, Integer y, BiFunction<Integer, Integer, Integer> function) {
        return function.apply(x, y);
    }

    public static void test(String input, Function demo) {
        System.out.println(demo.apply(input));
    }

}
