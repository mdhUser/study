package org.maxwell.algorithm.动态规划;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/6 0:01
 */
public class Solution_53_最大子数组和 {


    /**
     * 动态规划:
     * 之前数与当前和比较取最大pre
     * pre与最大和比较取max
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {


        int pre = 0, maxAns = nums[0];
        for (int num : nums) {
            pre = Math.max(num + pre, pre);
            maxAns = Math.max(maxAns, pre);
        }

        return maxAns;


    }

}
