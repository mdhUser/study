package org.maxwell.juc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/6/4 19:56
 */
public class Utils {

    public static void main(String[] args) {

        System.out.println(findOne(new int[]{4,1,2,1,2}));

    }


    public static int findOne(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    private static void map() {
        int[] arr1 = {1, 2, 2, 3, 3, 3, 4, 5, 5};

        Map<Integer, Integer> result = new HashMap<>();
        Arrays.stream(arr1).boxed().forEach(it -> {
            result.merge(it, 1, Integer::sum);
        });

        result.forEach((k, v) -> {
            System.out.println("k=" + k + " " + "v=" + v);
        });
    }

    public static void sleep(int t, TimeUnit u) {
        try {
            u.sleep(t);
        } catch (InterruptedException e) {
        }
    }
}
