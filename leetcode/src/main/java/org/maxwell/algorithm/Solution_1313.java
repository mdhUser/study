package org.maxwell.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 解压缩编码列表
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/19 1:05
 */
public class Solution_1313 {



    public int[] decompressRLElist(int[] nums) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                list.add(nums[i + 1]);
            }
        }

        int ans[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }


}
