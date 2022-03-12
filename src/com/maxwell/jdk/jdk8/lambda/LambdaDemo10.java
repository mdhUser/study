package com.maxwell.jdk.jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.partitioningBy;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/23 19:50
 */
public class LambdaDemo10 {

    public static void main(String[] args) {


        //partitioningBy 划分区
        List<String> list = Arrays.asList("java", "springcloud", "springboot", "html5"
                , "CSS3");
        Map<Boolean, List<String>> result = list.stream().
                collect(partitioningBy(o -> o.length() > 4));
        System.out.println("result = " + result);

    }
}
