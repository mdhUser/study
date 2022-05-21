package org.maxwell.algorithm.二分查找;

import java.util.Arrays;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/21 21:57
 */
public class Solution_436_寻找右区间 {

    /**
     * 排序二分查找解题
     */
    class Solution {
        public int[] findRightInterval(int[][] ivs) {
            int n = ivs.length;
            int[][] clone = new int[n][2];
            for (int i = 0; i < n; i++)
                clone[i] = new int[]{i, ivs[i][0]};
            Arrays.sort(clone, (a, b) -> a[1] - b[1]);
            int[] ret = new int[n];
            for (int i = 0; i < n; i++) {
                int l = 0, r = n - 1;
                while (l < r) {
                    int mid = l + r >> 1;
                    if (clone[mid][1] >= ivs[i][1]) r = mid;
                    else l = mid + 1;
                }
                ret[i] = clone[l][1] >= ivs[i][1] ? clone[l][0] : -1;
            }

            return ret;
        }
    }


}
