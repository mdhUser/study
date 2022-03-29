package com.maxwell.algorithm;

import java.util.Arrays;
import java.util.function.BiFunction;

public class BinarySearch {


    static int[] arry = {12, 48, 79, 156, 78, 67, 456};

    public static void main(String[] args) {

        Arrays.sort(arry);
        Arrays.stream(arry).forEach(a -> System.out.print(a + ","));
        System.out.println();
//        System.out.println(BinaryFind(arry, 67));

        //todo function函数实现二分查找
        int index = BinaryFindFunction(arry, 67, (a, b) ->
                {
                    int min = 0;
                    int max = a.length - 1;
                    int mid = 0;
                    while (min <= max) {
                        mid = (min + max) / 2;
                        if (b == a[mid])
                            return mid;
                        else if (b < a[mid]) {
                            max = mid - 1;
                        } else if (b > a[mid]) {
                            min = mid + 1;
                        }
                    }
                    return mid;
                }
        );
        System.out.println(index);

    }

    public static int BinaryFindFunction(int[] arry, int num, BiFunction<int[], Integer, Integer> function) {
        return function.apply(arry, num);
    }


    public static int BinaryFind(int[] arry, int num) {
        int min = 0;
        int max = arry.length - 1;
        int mid = 0;
        while (min <= max) {
            mid = (min + max) / 2;
            if (num == arry[mid])
                return mid;
            else if (num < arry[mid]) {
                max = mid - 1;
            } else if (num > arry[mid]) {
                min = mid + 1;
            }
        }
        return mid;
    }


}