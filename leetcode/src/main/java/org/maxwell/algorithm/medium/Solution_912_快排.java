package org.maxwell.algorithm.medium;

import java.util.Random;

/**
 * @description: 排序数组
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/21 22:37
 */
public class Solution_912_快排 {


    /**
     *  快速排序
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        randomQuicksort(nums,0,nums.length-1);
        return nums;
    }


    public void randomQuicksort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = randomizedPartition(nums, l, r);
            randomQuicksort(nums,l,pos-1);
            randomQuicksort(nums,pos+1,r);
        }

    }

    public int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + 1;
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];  //主元
        int i = l - 1;
        for (int j = l; j < r; ++j){
            if (nums[j]<=pivot){
                i+=1;
                swap(nums,i,j);
            }
        }
        swap(nums,i+1,r);
        return i+1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

}
