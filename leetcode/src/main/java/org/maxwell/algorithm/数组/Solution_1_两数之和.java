package org.maxwell.algorithm.数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: hash
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/6 16:33
 */
public class Solution_1_两数之和 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) return new int[]{i, map.get(nums[i])};
            map.put(nums[i], i);
        }
        return null;
    }


}
