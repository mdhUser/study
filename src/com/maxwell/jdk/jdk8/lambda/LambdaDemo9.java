package com.maxwell.jdk.jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description: joining函数
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/23 19:21
 */
public class LambdaDemo9 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("springboot教程"
                , "springcloud教程", "java高级", "架构教程");
        String result = list.stream().collect(Collectors.joining());
        System.out.println("result = " + result);

        String result1 = list.stream().collect(Collectors.joining("||"));
        System.out.println("result1 = " + result1);


        String result2 = list.stream().collect(Collectors.joining("||", "[", "]"));
        System.out.println("result2 = " + result2);

        String result3 = Stream.of("springboot教程"
                , "springcloud教程", "java高级", "架构教程").collect(Collectors.joining("||", "[", "]"));
        System.out.println("result3 = " + result3);


    }

}