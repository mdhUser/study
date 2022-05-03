package org.maxwell.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 自除数
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/31 21:51
 */
public class Solution_728 {

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1, 22));
    }

    //     我的屎山
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList();
        while (left <= right) {
            if (left < 10) {
                list.add(left);
            } else if (left > 10 && left < 100) {
                int g = left % 10;
                if (g != 0) {
                    int s = left / 10;
                    if (left % g == 0 && left % s == 0) list.add(left);
                }
            } else if (left > 100 && left < 1000) {
                int g = left % 10;
                int s = left % 100 / 10;
                if (s != 0 && g != 0) {
                    int b = left / 100;
                    if (left % g == 0 && left % s == 0 && left % b == 0) list.add(left);
                }
            } else if (left > 1000 && left < 10000) {
                int g = left % 10;
                int s = left % 100 / 10;
                int b = left % 1000 / 100;
                if (s != 0 && g != 0 && b != 0) {
                    int q = left / 1000;
                    if (left % g == 0 && left % s == 0 && left % b == 0 && left % q == 0) list.add(left);
                }
            }
            left++;
        }
        return list;
    }

    /**
     *  题解
     * @param left
     * @param right
     * @return
     */
    public static List<Integer> selfDividingNumbers_tj(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        out:
        for (int i = left; i <= right; i++) {
            int cur = i;
            while (cur > 0) {
                int t = cur % 10;
                if (i % t != 0)
                    continue out;
                cur/=10;
            }
            ans.add(i);
        }
        return ans;
    }

}
