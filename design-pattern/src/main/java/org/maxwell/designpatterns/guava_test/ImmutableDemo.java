package org.maxwell.designpatterns.guava_test;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/28 16:33
 */
public class ImmutableDemo {


    public static void main(String[] args) {
        List<String> originalList = new ArrayList<>();
        originalList.add("a");
        originalList.add("b");
        originalList.add("c");

        List<String> jdkUnmodifiableList = Collections.unmodifiableList(originalList);
        List<String> guavaImmutableList = ImmutableList.copyOf(originalList);

        originalList.add("d");
        //直接引用源
        jdkUnmodifiableList.forEach(System.out::print);
        System.out.println();
        //新建数组
        guavaImmutableList.forEach(System.out::print);

    }


}
