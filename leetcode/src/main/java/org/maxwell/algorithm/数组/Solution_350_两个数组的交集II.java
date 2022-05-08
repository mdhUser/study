package org.maxwell.algorithm.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/8 1:07
 */
public class Solution_350_两个数组的交集II {

    /**
     * 计数思想
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] len1 = new int[1001];
        int[] len2 = new int[1001];
        for (int i : nums1) {
            len1[i]++;
        }
        for (int i : nums2) {
            len2[i]++;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1001; i++) {
            if (len1[i] != 0 && len2[i] != 0) {
                int min = Math.min(len1[i], len2[i]);
                while (min != 0) {
                    list.add(i);
                    min--;
                }
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
