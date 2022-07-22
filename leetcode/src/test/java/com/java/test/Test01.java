package com.java.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/7/22 19:17
 */

public class Test01 implements Cloneable {

    public String name;
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Test01{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Test
    public void testStr() throws Exception {


        Test01 test01 = Test01.class.getConstructor().newInstance();
        test01.setAge(20);
        test01.setName("mdh");

        Test01 clone = (Test01) test01.clone();
        System.out.println(clone);
        System.out.println(test01);


    }

    @Test
    public void testColl() {

//        Set<Integer> set = new LinkedHashSet<>();

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
//        list.sort((x, y) -> x - y);

        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext())
            System.out.print("\n" + listIterator.next());
        while (listIterator.hasPrevious()) {
            System.out.print("\n" + listIterator.previous());
        }

//        Set<Integer> set = new TreeSet<>((x, y) -> x - y);

    }

}