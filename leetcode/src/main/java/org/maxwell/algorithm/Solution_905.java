package org.maxwell.algorithm;

import java.util.Arrays;

/**
 * @description: 按奇偶排序数组
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/20 16:47
 */
public class Solution_905 {


    /**
     *  lambda
     * @param nums
     * @return
     */
    public int[] sortArrayByParity(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .sorted((a, b) -> Integer.compare(a%2, b%2))
                .mapToInt(i -> i)
                .toArray();
    }


}
