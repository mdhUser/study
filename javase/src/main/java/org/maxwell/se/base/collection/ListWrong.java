package org.maxwell.se.base.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.Collectors;

/**
 * @description: list常见问题
 * @author: maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/10/13 09:19
 */
public class ListWrong {

    public static void main(String[] args) {

        asListAdd();

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

    private static void asListAdd() {
        String[] arr = {"1", "2", "3"};
        List<String> strings = new ArrayList<>(Arrays.asList(arr));
        arr[2] = "4";
        System.out.println(strings.toString());
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            if ("4".equals(iterator.next())) {
                iterator.remove();
            }
        }
        //modCount不一致会抛出并发修改异常
//        strings.forEach(val ->{
//            strings.remove("4");
//            strings.add("3");
//        });

        //转化ConcurrentLinkedDeque 可对list进行增删操作
        ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<>(strings);
        deque.forEach(val -> {
            if ("1".equals(val)) deque.remove(val);
        });
        System.out.println(deque);

        System.out.println(Arrays.asList(arr).toString());
    }

}