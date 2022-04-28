package org.maxwell.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 杨辉三角
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/28 17:17
 */
public class Solution_118 {


    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();

        if (numRows == 1) {
            res.add(Arrays.asList(1));
            return res;
        }

        int[][] ans = new int[numRows][];
        for (int i = 0, clo = 2; i < numRows; i++) {
            if (i == 0) {
                ans[i][0] = 1;
                continue;
            } else if (i == 1) {
                ans[i][0] = 1;
                ans[i][1] = 1;
                continue;
            }

            for (int j = 0; j < clo; j++) {
                if (j == 0) {
                    ans[i][j] = 1;
                    continue;
                }
                if (j == clo - 1) {
                    ans[i][j] = 1;
                    break;
                }
                ans[i][j] = ans[i - 1][j - 1] + ans[i - 1][j];
            }

            clo++;
        }

        for (int i = 0; i < numRows; i++) {
            List<Integer> collect = Arrays.stream(ans[i]).boxed().collect(Collectors.toList());
            res.add(collect);
        }
        return res;
    }

}
