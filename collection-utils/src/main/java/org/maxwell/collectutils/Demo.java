package org.maxwell.collectutils;

import org.apache.commons.collections.CollectionUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @description: 测试集合工具类
 * @author: maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/8/23 14:56
 */
public class Demo {

    public static void main(String[] args) {

        List<String> A = Arrays.asList("a", "b", "b", "c");
        List<String> B = Arrays.asList("a", "e", "f");

        System.out.println("集合A:" + A);
        System.out.println("集合B:" + B);
        System.out.println("------------------------");

        //并集
        Collection union = CollectionUtils.union(A, B);
        System.out.println("并集   :" + union);

        //交集
        Collection intersection = CollectionUtils.intersection(A, B);
        System.out.println("交集 =    :" + intersection);

        //交集的补集
        Collection<String> disjunction = CollectionUtils.disjunction(A, B);
        System.out.println("交集的补集   ：" + disjunction);
        //差集(集合相减)
        Collection<String> subtract = CollectionUtils.subtract(A, B);
        System.out.println("差集(集合相减)   ：" + subtract);


    }


}
