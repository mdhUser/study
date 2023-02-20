package org.maxwell.wrongcase;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/18 16:39
 */
@Slf4j
public class Utils {

    /**
     * 打印线程池状态
     *
     * @param threadPool
     */
    public static void printStats(ThreadPoolExecutor threadPool) {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            log.info("=========================");
            log.info("Pool Size: {}", threadPool.getPoolSize());
            log.info("Active Threads: {}", threadPool.getActiveCount());
            log.info("Number of Tasks Completed: {}", threadPool.getCompletedTaskCount());
            log.info("Number of Tasks in Queue: {}", threadPool.getQueue().size());
            log.info("=========================");
        }, 0, 1, TimeUnit.SECONDS);
    }


    /**
     * 加载配置资源文件
     *
     * @param clazz
     * @param fileName
     */
    public static void loadPropertySource(Class<?> clazz, String fileName) {
        try {
            Properties p = new Properties();
            p.load(clazz.getResourceAsStream(fileName));
            p.forEach((k, v) -> {
                log.info("{}={}", k, v);
                System.setProperty(k.toString(), v.toString());
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        System.out.println(formatter.format(LocalDateTime.now()));

        LocalDateTime parse = LocalDateTime.parse("20230217211649252", formatter);
        System.out.println(parse);

        Date date = Date.from(parse.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(date);

    }

}
