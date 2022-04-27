package org.maxwell.algorithm;

/**
 * @description: 二进制矩阵中的特殊位置
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/27 11:33
 */
public class Solution_1582 {

    public int numSpecial(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    boolean flag = true;
                    for (int k = 0; k < m; k++) {
                        if (mat[i][k] == 1 && k != j) {
                            flag = false;
                            break;
                        }
                    }
                    for (int k = 0; k < n; k++) {
                        if (mat[k][j] == 1 && k != i) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag)
                        ans++;
                }
            }
        }
        return ans;
    }

}
