package com.maxwell.jdk.jdk8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: limit&sorted  allMatch&anyMatch
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/23 13:53
 */
public class LambdaDemo4 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("springboot", "springcloud", "redis", "git", "netty", "java", "html", "docker");
        List<String> resultList = list.stream().sorted().collect(Collectors.toList());
        System.out.println(resultList);

        //todo 自定义升降序
//        List<String> result = list.stream().sorted(Comparator.comparing(o->o.length(),Comparator.reverseOrder())).collect(Collectors.toList());
//        List<String> result = list.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
//        System.out.println("result = " + result);


        List<String> resultLimit = list.stream().sorted(Comparator.comparing(String::length).reversed()).skip(2).limit(2).collect(Collectors.toList());
        List<String> result = list.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
        System.out.println("result = " + result);
        System.out.println("resultLimit = " + resultLimit);

    }
}
