package org.maxwell.designpatterns.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/22 16:32
 */
public class Demo {

    public static void main(String[] args) {
        //demo1();
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(8);
        list.add(2);
        Iterator<Integer> iter1 = list.iterator();//snapshot: 3, 8, 2
        list.remove(Integer.valueOf(2));
        //list：3, 8
        Iterator<Integer> iter2 = list.iterator();//snapshot: 3, 8
        list.remove(Integer.valueOf(3));//list：8
        Iterator<Integer> iter3 = list.iterator();//snapshot: 3

        // 输出结果：3 8 2
        while (iter1.hasNext()) {
            System.out.print(iter1.next() + " ");
        }
        System.out.println();
        // 输出结果：3 8
        while (iter2.hasNext()) {
            System.out.print(iter1.next() + " ");
        }
        System.out.println();
        // 输出结果：8
        while (iter3.hasNext()) {
            System.out.print(iter1.next() + " ");
        }
        System.out.println();
    }

    private static void demo1() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        Iterator<String> iterator = list.iterator();
        Iterator<String> iterator1 = list.iterator();
        iterator.next();
        list.add(0, "x");
        iterator.next();
    }

}
