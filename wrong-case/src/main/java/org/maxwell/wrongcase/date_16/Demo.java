package org.maxwell.wrongcase.date_16;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.ThreadLocalRandom;

import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoField.MONTH_OF_YEAR;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/31 16:51
 */
//@Component
public class Demo {


    //jdk8 常用日期格式化器
    private static final DateTimeFormatter datetimeformatter = new DateTimeFormatterBuilder()
            .appendValue(ChronoField.YEAR) //年
            .appendLiteral("/")
            .appendValue(MONTH_OF_YEAR) //月
            .appendLiteral("/")
            .appendValue(DAY_OF_MONTH) //日
            .appendLiteral(" ")
            .appendValue(ChronoField.HOUR_OF_DAY) //时
            .appendLiteral(":")
            .appendValue(ChronoField.MINUTE_OF_HOUR) //分
            .appendLiteral(":")
            .appendValue(ChronoField.SECOND_OF_MINUTE) //秒
            .appendLiteral(".")
            .appendValue(ChronoField.MILLI_OF_SECOND) //毫秒
            .toFormatter();


    private static Boolean isFamilyBirthday(TemporalAccessor date) {
        int month = date.get(MONTH_OF_YEAR);
        int day = date.get(DAY_OF_MONTH);
        if (month == Month.FEBRUARY.getValue() && day == 17)
            return Boolean.TRUE;
        if (month == Month.SEPTEMBER.getValue() && day == 21)
            return Boolean.TRUE;
        if (month == Month.MAY.getValue() && day == 22)
            return Boolean.TRUE;
        return Boolean.FALSE;
    }

    public static void main(String[] args) {
        //test();
        //java8DateTime();
        //addDays();
        //jdk8DateCalculation();
        //LocalDateTime dateTime = LocalDateTime.parse("2023/2/1 10:35:25.989", datetimeformatter);
        //System.out.println(dateTime);
        //System.out.println("//查询是否是今天要举办生日");
        //System.out.println(LocalDate.now().query(Demo::isFamilyBirthday));
        //jdk8Datediff();
        date2LocalDateTime();
    }

    private static void date2LocalDateTime() {
        Date date = new Date();
        LocalDateTime ldf = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        System.out.println(ldf);
        Date out = Date.from(ldf.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(out);
    }

    private static void jdk8Datediff() {
        System.out.println("//计算日期差");
        LocalDate today = LocalDate.of(2019, 12, 12);
        LocalDate specifyDate = LocalDate.of(2019, 10, 1);
        System.out.println(Period.between(specifyDate, today).getDays());
        System.out.println(Period.between(specifyDate, today));
        System.out.println(ChronoUnit.DAYS.between(specifyDate, today));

        System.out.println(Instant.now());
    }

    private static void jdk8DateCalculation() {
        System.out.println("//测试操作日期");
        System.out.println(LocalDate.now()
                .minus(Period.ofDays(1))
                .plus(1, ChronoUnit.DAYS)
                .minusMonths(1)
                .plus(Period.ofMonths(1)));


        System.out.println("//本月的第一天");
        System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()));

        System.out.println("//今年的程序员日");
        System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfYear()).plusDays(255));

        System.out.println("//今天之前的一个周六");
        System.out.println(LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.SATURDAY)));

        System.out.println("//本月最后一个工作日");
        System.out.println(LocalDate.now().with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY)));

        System.out.println("//增加N天后的日期");
        System.out.println(LocalDate.now().with(temporal -> temporal.plus(ThreadLocalRandom.current().nextInt(100),
                ChronoUnit.DAYS)));
    }

    private static void addDays() {
        //直接用Date
        Date today = new Date();
        Date nextMonth = new Date(today.getTime() + 30 * 1000 * 60 * 60 * 24L);
        System.out.println(today);
        System.out.println(nextMonth);

        //jdk8 之前
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        System.out.println(calendar.getTime());

        //jdk8
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.plusDays(30));
    }

    private static void java8DateTime() {
        //一个时间表示
        String stringDate = "2020-01-02 22:00:00";
        //初始化三个时区
        ZoneId timeZoneSH = ZoneId.of("Asia/Shanghai");
        ZoneId timeZoneNY = ZoneId.of("America/New_York");
        ZoneId timeZoneJST = ZoneOffset.ofHours(10);
        //格式化器
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZonedDateTime date = ZonedDateTime.of(LocalDateTime.parse(stringDate, dateTimeFormatter), timeZoneJST);
        //使用DateTimeFormatter格式化时间，可以通过withZone方法直接设置格式化使用的时区
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");
        System.out.println(timeZoneSH.getId() + outputFormat.withZone(timeZoneSH).format(date));
        System.out.println(timeZoneNY.getId() + outputFormat.withZone(timeZoneNY).format(date));
        System.out.println(timeZoneJST.getId() + outputFormat.withZone(timeZoneJST).format(date));
    }

    private static void test() {
        //月 0-11 年份从1900年开始
        System.out.println(new Date(2023 - 1900, 0, 31, 16, 51, 24));
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 11, 31, 11, 12, 14);
        System.out.println(calendar.getTime());
        Calendar calendar1 = Calendar.getInstance(TimeZone.getTimeZone("American/New_York"));
        calendar1.set(2019, 11, 31, 11, 12, 14);
        System.out.println(calendar1.getTime());

        //元年和时区
        System.out.println(new Date(0));
        System.out.println(TimeZone.getDefault().getID() + ":" + TimeZone.getDefault().getRawOffset() / 3600000);
    }

}
