package org.maxwell.algorithm.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 杨辉三角
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/28 17:17
 */
public class Solution_118_杨辉三角 {


    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();

        if (numRows == 1) {
            res.add(Arrays.asList(1));
            return res;
        }

        for (int i = 0, clo = 2; i < numRows; i++) {
            if (i == 0) {
                res.add(List.of(1));
                continue;
            } else if (i == 1) {
                res.add(Arrays.asList(1, 1));
                continue;
            }

            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= clo; j++) {
                if (j == 0) {
                    list.add(1);
                    continue;
                }
                if (j == clo) {
                    list.add(1);
                    break;
                }
                list.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            res.add(list);
            clo++;
        }

        return res;
    }

}
