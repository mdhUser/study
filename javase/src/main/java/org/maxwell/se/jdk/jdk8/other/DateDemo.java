package org.maxwell.se.jdk.jdk8.other;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @description: jdk8 日期
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/21 23:17
 */
public class DateDemo {

    public static void main(String[] args) {


        LocalDate today = LocalDate.now();

        System.out.println("今天日期:" + today);

        System.out.println("现在是哪年:" + today.getYear());

        System.out.println("现在是哪月:" + today.getMonth());
        System.out.println("现在是哪月（数字）:" + today.getMonthValue());
        System.out.println("现在是几号:" + today.getDayOfMonth());
        System.out.println("现在是周几:" + today.getDayOfWeek());

        //加减年份,todo 加后返回的对象才是修改的
        LocalDate changeDate = today.plusYears(1);
        LocalDate changeDate1 = changeDate.plusMonths(1);
        System.out.println("加后是哪年：" + changeDate.getYear());
        System.out.println("加年加月之后："+changeDate1);
        System.out.println("没加是哪年：" + today.getYear());

        //日期比较
        System.out.println("isAfter:" + changeDate.isAfter(today));

        //日期格式化
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String ldtStr =dtf.format(ldt);
        System.out.println(ldtStr);

        //指定时间方式
        LocalDateTime before = LocalDateTime.of(2021,5,31,12,25,5);
        System.out.println(dtf.format(before));


        LocalDateTime changedate = LocalDateTime.of(2023,9,11,9,22,44);
        Duration duration =Duration.between(ldt,changedate);//第二个减去第一个参数
        System.out.println(duration.toDays());//两个时间差的天数
        System.out.println(duration.toHours());//两个时间差的⼩时数
        System.out.println(duration.toMinutes());//两个时间差的分钟数
        System.out.println(duration.toMillis());//两个时间差的毫秒数
        System.out.println(duration.toNanos());//两个时间差的纳秒数
    }
}