package org.maxwell.se.jdk.jdk9;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 新增流式编程
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/25 13:17
 */
public class StreamAPI {

    public static void main(String[] args) {
       /* 从 Stream 中获取⼀部分数据, 返回从头开始的尽可能多的元素, 直到遇到第⼀
         个false结果，如果第⼀个值不满⾜断⾔条件，将返回⼀个空的 Stream*/
        List<String> list = List.of("springboot", "java", "html", "", "git").stream().takeWhile(obj -> !obj.isEmpty()).collect(Collectors.toList());
//        list.forEach(System.out::println);

        //返回剩余
        List<String> listRes = List.of("springboot", "java", "html", "", "git").stream().dropWhile(obj -> !obj.isEmpty()).collect(Collectors.toList());
        listRes.forEach(System.out::println);


    }


}
