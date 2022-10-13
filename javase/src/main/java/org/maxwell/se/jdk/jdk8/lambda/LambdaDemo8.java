package org.maxwell.se.jdk.jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * @description: collector 收集器
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/23 16:43
 */
public class LambdaDemo8 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("dasv", "khx5646", "gfayy8yU", "hdauig","dasv");

//        收集成ArrayList
//        list.stream().collect(Collectors.toList());
//        收集LinkedList
//        List<String> result = list.stream().collect(Collectors.toCollection(LinkedList::new));

        Set<String> result = list.stream().collect(Collectors.toCollection(TreeSet::new));
//        Set<String> result = list.stream().collect(Collectors.toSet());
        List<String> strResult = list.stream().collect(Collectors.toCollection(CopyOnWriteArrayList::new));
        System.out.println("result = " + result);
        System.out.println("strResult = " + strResult);

    }
}
