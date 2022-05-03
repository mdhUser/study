package org.maxwell.algorithm.计数;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/3 22:01
 */
public class Solution_1512_好数对的数目 {


    /**
     * 指针思想解题
     *
     * @param nums
     * @return
     */
    public int numIdenticalPairs(int[] nums) {

        int len = nums.length, count = 0, l = 0, r = len - 1;
        while (l <= r) {
            if (l == r) {
                r = len - 1;
                l++;
                continue;
            }
            if (nums[l] == nums[r])
                count++;
            r--;
        }

        return count;
    }

}
