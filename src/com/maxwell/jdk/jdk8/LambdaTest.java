package com.maxwell.jdk.jdk8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/23 21:00
 */
public class LambdaTest {

    static List<VideoOrder> videoOrders1 = Arrays.asList(
            new VideoOrder("20190242812", "springboot教程", 3),
            new VideoOrder("20194350812", "微服务SpringCloud", 5),
            new VideoOrder("20190814232", "Redis教程", 9),
            new VideoOrder("20190523812", "⽹⻚开发教程", 9),
            new VideoOrder("201932324", "百万并发实战Netty", 9));


    static List<VideoOrder> videoOrders2 = Arrays.asList(
            new VideoOrder("2019024285312", "springboot教程", 3),
            new VideoOrder("2019081453232", "Redis教程", 9),
            new VideoOrder("20190522338312", "⽹⻚开发教程", 9),
            new VideoOrder("2019435230812", "Jmeter压⼒测试", 5),
            new VideoOrder("2019323542411", "Git+Jenkins持续集成", 7),
            new VideoOrder("2019323542424", "Idea全套教程", 21));


    public static void main(String[] args) {

        //交集
        List<VideoOrder> intersectionList = videoOrders1.stream().filter(videoOrders2::contains).collect(Collectors.toList());
        intersectionList.forEach(i -> out.println(i.getTitle()));
        out.println("================");

        //差集1
        List<VideoOrder> diffList1 = videoOrders1.stream().filter(v -> !videoOrders2.contains(v)).collect(Collectors.toList());
        out.println("差集1 = " + diffList1);
        //差集2
        List<VideoOrder> diffList2 = videoOrders2.stream().filter(v -> !videoOrders1.contains(v)).collect(Collectors.toList());
        out.println("差集2 = " + diffList2);

        //并集
        List<VideoOrder> all = videoOrders1.parallelStream().collect(Collectors.toList());
        List<VideoOrder> all1 = videoOrders1.stream().collect(Collectors.toList());
        all1.addAll(videoOrders2);
        out.println("all1 = " + all1);
        all.addAll(videoOrders2);
        out.println("all = " + all);
        //去重并集
        List<VideoOrder> distinct = all.stream().distinct().collect(Collectors.toList());
        distinct.forEach(out::println);

        //两个人的平均价格
        out.println("================================");
        IntSummaryStatistics ints1 = videoOrders1.stream().collect(Collectors.summarizingInt(VideoOrder::getMoney));
        //方法二
//        double avg=videoOrders1.stream().collect(Collectors.averagingDouble(VideoOrder::getMoney)).intValue();
//        out.println("avg = " + avg);
        out.println("videoOrders1平均价格：" + ints1.getAverage());
        IntSummaryStatistics ints2 = videoOrders2.stream().collect(Collectors.summarizingInt(VideoOrder::getMoney));
        out.println("videoOrders2平均价格：" + ints2.getAverage());

        //两个人的总价
        int sum2 = videoOrders2.stream().map(v -> v.getMoney()).reduce((x, y) -> x + y).get();
        //法二
//        int count = videoOrders2.stream().collect(Collectors.summingInt(VideoOrder::getMoney)).intValue();
//        out.println("count = " + count);
        out.println("sum2 = " + sum2);
        int sum1 = videoOrders1.stream().map(v -> v.getMoney()).reduce((x, y) -> x + y).get();
        out.println("sum1 = " + sum1);



    }

}