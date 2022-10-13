package org.maxwell.se.jdk.jdk8.lambda;

import org.maxwell.se.jdk.jdk8.inter.Health;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/22 20:01
 */
public class LambdaDemo {

    public static void main(String[] args) {

        //线程实现1
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("lambda技能提升1");
            }
        };
        thread.start();
        //线程实现2
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("lambda技能提升2");
            }
        }).start();

        //lambda实现线程
        new Thread(() -> {
            System.out.println("lambda技能提升3");
        }).start();


        List<String> list = Arrays.asList("aaa", "ggg", "mmm", "ddd");

//        Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });

        //todo lambda实现排序
        Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
        for (String s : list) {
            System.out.println(s);
        }

        invoke(() -> System.out.println("dsafefewA"));


    }


    public static void invoke(Health health) {
        health.healthInfo();
    }



}