package org.maxwell.algorithm.medium;

import java.util.Arrays;
import java.util.Random;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/19 23:40
 */
public class Solution_462_最少移动次数使数组元素相等II {


    public int minMoves2(int[] nums) {

        int len = nums.length;
        //排序数组（目标数在范围内最快到达）
        Arrays.sort(nums);

        // 最大最小数到达target次数恒定，不断取中间值到达（奇数为中位数，偶数为任一中间值）
        int target = nums[len / 2], ret = 0;
        for (int num : nums) {
            ret += Math.abs(num - target);
        }
        return ret;

    }


    /**
     * 官方快排题解
     */
    class Solution {
        Random random = new Random();

        public int minMoves2(int[] nums) {
            int n = nums.length, x = quickSelect(nums, 0, n - 1, n / 2), ret = 0;
            for (int i = 0; i < n; ++i) {
                ret += Math.abs(nums[i] - x);
            }
            return ret;
        }

        public int quickSelect(int[] nums, int left, int right, int index) {
            int q = randomPartition(nums, left, right);
            if (q == index) {
                return nums[q];
            } else {
                return q < index ? quickSelect(nums, q + 1, right, index) : quickSelect(nums, left, q - 1, index);
            }
        }

        public int randomPartition(int[] nums, int left, int right) {
            int i = random.nextInt(right - left + 1) + left;
            swap(nums, i, right);
            return partition(nums, left, right);
        }

        public int partition(int[] nums, int left, int right) {
            int x = nums[right], i = left - 1;
            for (int j = left; j < right; ++j) {
                if (nums[j] <= x) {
                    ++i;
                    swap(nums, i, j);
                }
            }
            swap(nums, i + 1, right);
            return i + 1;
        }

        public void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }


}
