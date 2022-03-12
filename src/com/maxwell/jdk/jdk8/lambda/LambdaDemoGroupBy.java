package com.maxwell.jdk.jdk8.lambda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description: groupby f分组
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/23 20:00
 */
public class LambdaDemoGroupBy {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(new Student("⼴东", 23), new
                Student("⼴东", 24), new Student("⼴东", 23), new Student("北京", 22), new
                Student("北京", 20), new Student("北京", 20), new Student("海南", 25));


        //todo 分组
//        Map<String, List<Student>> listMap = students.stream().collect(Collectors.groupingBy(s -> s.getProvince()));

        //todo 分组统计
        Map<String, Long> listMap = students.stream().collect(Collectors.groupingBy(s -> s.getProvince(), Collectors.counting()));
        listMap.forEach((k, v) -> System.out.println(k + "省人数有" + v));

        //todo 内部汇总统计
        IntSummaryStatistics summaryStatistics = students.stream().collect(Collectors.summarizingInt(Student::getAge));

        System.out.println("平均值"+summaryStatistics.getAverage());
        System.out.println("人数"+summaryStatistics.getCount());
        System.out.println("最大值"+summaryStatistics.getMax());
        System.out.println("最小值"+summaryStatistics.getMin());
        System.out.println("总和"+summaryStatistics.getSum());


    }


}
