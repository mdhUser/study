package org.maxwell.algorithm.easy;

/**
 * @description: 一维数组变成二位
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/23 19:36
 */
public class Solution_2022 {


    public int[][] construct2DArray(int[] original, int m, int n) {

        int len = original.length;
        int[][] ret;
        int i, j;

        if (n * m != len)
            return new int[0][0];


        ret = new int[m][n];
        for (i = 0; i < m; ++i) {
            for (j = 0; j < n; ++j) {
                // 根据总数放入行列位置
                ret[i][j] = original[n * i + j];
            }

        }
        return ret;


    }


}
