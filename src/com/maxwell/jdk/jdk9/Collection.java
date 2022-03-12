package com.maxwell.jdk.jdk9;

import java.util.*;

import static java.lang.System.out;

/**
 * @description: 只读集合
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/25 12:41
 */
public class Collection {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        set.add("45");
        set.add("小花");
        set.add("45");
        set.add("springboot");
        set.add("redis");
        set.add("git");
        set.add("netty");
        set.add("java");
        set.add("html");
        set.add("docker");
        //设置只读集合
        set = Collections.unmodifiableSet(set);
        set.parallelStream().forEach(out::println);
//        set.add("dsaf"); todo 无法添加只读集合

        Map<String, String> map = new HashMap<>();
        map.put("key1", "课程1");
        map.put("key2", "课程2");
        map.put("key3", "课程3");
        map.put("key4", "课程4");
        map.put("key5", "课程5");
        out.println("map = " + map);
//        map.forEach();

        map.forEach((k, v) -> out.println(k + "=" + v));

        List<String> list = List.of("java", "springcloud", "springboot", "html5"
                , "CSS3");
        list.stream().forEach(out::println);
        list.add("netty");

    }


}
