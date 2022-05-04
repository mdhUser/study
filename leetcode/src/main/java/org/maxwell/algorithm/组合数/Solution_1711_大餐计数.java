package org.maxwell.algorithm.组合数;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/4 12:21
 */
public class Solution_1711_大餐计数 {

    public static void main(String[] args) {
        System.out.println(countPairs(new int[]{2160, 1936, 3, 29, 27, 5, 2503, 1593, 2, 0, 16, 0, 3860, 28908, 6, 2, 15, 49, 6246, 1946,
                23, 105, 7996, 196, 0, 2, 55, 457, 5, 3, 924, 7268, 16, 48, 4, 0, 12, 116, 2628, 1468}));
    }

    /**
     *  朴素思想
     * @param deliciousness
     * @return
     */
    public static int countPairs(int[] deliciousness) {
        int n = deliciousness.length, count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int and = deliciousness[i] + deliciousness[j];
                while (and % 2 == 0) {
                    and /= 2;
                }
                if (and == 1) count++;
            }
        }
        return count;
    }


    /**
     *  hash解法
     * @param deliciousness
     * @return
     */
    public int countPairs_useHash(int[] deliciousness) {
        final int MOD = 1000000007;
        int maxVal = 0;
        for (int val : deliciousness) {
            maxVal = Math.max(maxVal, val);
        }
        int maxSum = maxVal * 2;
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : deliciousness) {
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) % MOD;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return pairs;
    }



}
