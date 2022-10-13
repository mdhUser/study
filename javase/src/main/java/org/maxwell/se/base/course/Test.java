package org.maxwell.se.base.course;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/24 9:04
 */
public class Test {


    public static void main(String[] args) {


        int[] arry = {33, 22, 11, 55, 44};

//        System.out.println("请输入数字：");
//        Scanner input = new Scanner(System.in);
//        int in = input.nextInt();
//
//        OptionalInt num = Arrays.stream(arry).filter(a -> a == in).findAny();
//
//        if (num.isPresent()) {
//            System.out.println("数字在数组中");
//        }
//        else
//            System.out.println("不在！");

        int[] newArry = Arrays.copyOf(arry, 10);
        Arrays.stream(newArry).forEach(out::println);

        Integer obj = 43;
        List<Integer> list = Arrays.asList(1, obj, 2, 43, 54, 65, 4, 5, 6, 8);
        out.println(list.get(obj));

        Integer a = new Integer(4);
        String str = a.toString();
        Integer b = Integer.parseInt(str);
        out.println("b = " + b);



    }

}
