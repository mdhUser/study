package org.maxwell.algorithm.矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/10 22:37
 */
public class Solution_73_矩阵置零 {

    public static void main(String[] args) {
        setZeroes(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}});
    }


    /**
     * 标记下标清零
     *
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        List<IndexMap> cot = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 0) {
                    cot.add(new IndexMap(i, j));
                }
            }
        }
        cot.forEach(entry -> {
            for (int i = 0; i < rows; i++) {
                matrix[i][entry.col] = 0;
            }
            for (int i = 0; i < columns; i++) {
                matrix[entry.row][i] = 0;
            }
        });

    }

    /**
     * 官方题解 空间复杂的（m+n）
     */
    public void setZeroes_leetcode(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


}

class IndexMap {

    int row;
    int col;

    public IndexMap(int row, int col) {
        this.row = row;
        this.col = col;
    }

}