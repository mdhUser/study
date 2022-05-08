package org.maxwell.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/8 11:25
 */
public class Solution_442_数组中重复的数据 {

    /**
     *  技术思想
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        int[] cot = new int[100000];
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            cot[num]++;
        }
        for(int i=0;i<cot.length;++i){
            if(cot[i]==2){
                ans.add(i);
            }
        }
        return ans;
    }

}
