package org.maxwell.se.jdk.jdk8.lambda;


import org.maxwell.se.jdk.jdk8.other.Hero;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @description:调用函数方法
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/21 9:15
 */
public class LambdaDemo2 {


    public static void main(String[] args) {

        //使用双冒号::来构造静态函数的引用
        Function<String, Integer> fun = Integer::parseInt;
        int i = fun.apply("15");
        System.out.println("i = " + i);

        //使用双冒号::来构造非静态函数引用
        String content = "欢迎来到小滴课堂学习";
        BiFunction<Integer, Integer, String> function = content::substring;
        String result = function.apply(5, 7);
        System.out.println("result = " + result);

        BiFunction<String, Integer, Hero> biFunction = Hero::new;
        Hero h = biFunction.apply("李白", 500);
        System.out.println(h);
        sayHello("org/maxwell/se", a -> "hello," + a);


    }

    public static void sayHello(String args, Function<String, String> function) {
//        String result = function.apply(args);
        System.out.println(function.apply(args));
    }


}

