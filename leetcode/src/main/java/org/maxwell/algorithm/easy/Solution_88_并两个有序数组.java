package org.maxwell.algorithm.easy;

import java.util.Arrays;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/6 17:50
 */
public class Solution_88_并两个有序数组 {

    /**
     * 直接排序
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int len = nums1.length;
        for (int i = m; i < len; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);

    }

    /**
     * 双指针
     */
    public void merge_pointer(int[] nums1, int m, int[] nums2, int n) {
                int p1 = 0, p2 = 0;
                int[] sorted = new int[m + n];
                int cur;
                while (p1 < m || p2 < n) {
                    if (p1 == m) {
                        cur = nums2[p2++];
                    } else if (p2 == n) {
                        cur = nums1[p1++];
                    } else if (nums1[p1] < nums2[p2]) {
                        cur = nums1[p1++];
                    } else {
                        cur = nums2[p2++];
                    }
                    sorted[p1 + p2 - 1] = cur;
                }
                for (int i = 0; i != m + n; ++i) {
                    nums1[i] = sorted[i];
                }
        }


}
