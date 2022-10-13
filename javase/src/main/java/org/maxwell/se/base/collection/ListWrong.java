package org.maxwell.se.base.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: list常见问题
 * @author: maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/10/13 09:19
 */
public class ListWrong {

    public static void main(String[] args) {


    }



    /**
     * Arrays数组转换问题
     */
    private static void question1() {
        int[] a = {1, 2, 3};
        // 不能转化为list 参数是T...
        List<int[]> ints = Arrays.asList(a);

        //实现转换
        //方法一
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        System.out.println(list);
    }

}