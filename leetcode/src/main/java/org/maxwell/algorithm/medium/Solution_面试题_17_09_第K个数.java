package org.maxwell.algorithm.medium;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @description:
 * @author: maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/9/30 10:22
 */
public class Solution_面试题_17_09_第K个数 {


    /**
     * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/get-kth-magic-number-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param k
     * @return
     */
    public int getKthMagicNumber(int k) {

        int f0 = 1, f1 = 3, f2 = 5, f3 = 7;


        if (k == 1) return 1;


        return 0;
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/get-kth-magic-number-lcci/solution/di-k-ge-shu-by-leetcode-solution-vzp7/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param k
     * @return
     */
    public int getKthMagicNumberLeetcode(int k) {
        int[] factors = {3, 5, 7};
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int magic = 0;
        for (int i = 0; i < k; i++) {
            long curr = heap.poll();
            magic = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return magic;
    }

    /**
     * 方法二：动态规划
     * <p>
     * 三指针
     *
     * @param k
     * @return
     */
    public int getKthMagicNumberLeetcodeDynamic(int k) {
        int[] dp = new int[k + 1];
        dp[1] = 1;
        int p3 = 1, p5 = 1, p7 = 1;
        for (int i = 2; i <= k; i++) {
            int num3 = dp[p3] * 3, num5 = dp[p5] * 5, num7 = dp[p7] * 7;
            dp[i] = Math.min(Math.min(num3, num5), num7);
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
            if (dp[i] == num7) {
                p7++;
            }
        }
        return dp[k];
    }


}
