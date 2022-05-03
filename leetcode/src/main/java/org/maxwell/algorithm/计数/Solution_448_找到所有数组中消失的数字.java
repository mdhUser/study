package org.maxwell.algorithm.计数;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/3 21:54
 */
public class Solution_448_找到所有数组中消失的数字 {

    /**
     * 一条过！
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;
        int[] arr = new int[n];
        for (int num : nums) arr[num - 1]++;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                res.add(i + 1);
        }
        return res;
    }

}
