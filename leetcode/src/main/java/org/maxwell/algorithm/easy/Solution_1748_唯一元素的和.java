package org.maxwell.algorithm.easy;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/30 0:04
 */
public class Solution_1748_唯一元素的和 {

    public static void main(String[] args) {
        System.out.println(sumOfUnique(new int[]{1, 2, 3, 2}));
    }

    public static int sumOfUnique(int[] nums) {

        int max = nums[0];
        for (int num : nums) {
            if (num > max)
                max = num;
        }

        int[] cot = new int[max+1];
        for (int i = 0; i < nums.length; i++) {
            cot[nums[i]]++;
        }

        int sum=0;
        for (int i = 0; i < cot.length; i++) {
            if (cot[i]==1)
                sum+=i;
        }

        return sum;
    }


}
