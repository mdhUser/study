package org.maxwell.algorithm.easy;

/**
 * @description: 重塑矩阵
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/23 19:45
 */
public class Solution_566 {

    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int n = mat.length;
        int m = mat[0].length;
        int[][] ret;
        int i, j, index;

        if (n * m != r * c)
            return mat;

        ret = new int[r][c];
        for (i = 0; i < r; ++i) {
            for (j = 0; j < c; ++j) {
                // 轮到的总元素个数位置
                index = i * c + j;
                //除以列数确定行数（商） 余数为列数
                ret[i][j] = mat[index / m][index % m];
            }

        }
        return ret;


    }

}
