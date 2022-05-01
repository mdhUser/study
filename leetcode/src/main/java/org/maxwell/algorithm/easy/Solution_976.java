package org.maxwell.algorithm.easy;

import java.util.Arrays;

/**
 * @description: 三角形的最大周长
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/21 16:14
 */
public class Solution_976 {


    public static void main(String[] args) {

        System.out.println(largestPerimeter(new int[]{1, 2, 1}));
    }


    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length - 1;
        for (int i = len; i >= 2; --i)
            if (nums[i - 1] + nums[i - 2] > nums[i]) return nums[i] + nums[i - 1] + nums[i - 2];
        return 0;
    }


}
