package org.maxwell.algorithm.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @description: 剑指 Offer 57 - II. 和为s的连续正数序列
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/19 9:43
 */
public class SolutionOffer57_2 {

    public static void main(String[] args) {
        int[][] continuousSequence = findContinuousSequence(15);
        for (int i = 0; i < continuousSequence.length; i++) {
            System.out.println(Arrays.toString(continuousSequence[i]));
        }

    }


    /**
     *  我的屎山
     * @param target
     * @return
     */
    public static int[][] findContinuousSequence(int target) {

        int[] line = new int[target];
        for (int i = 0; i < line.length; i++) {
            line[i] = i + 1;
        }

        List<int[]> arr = new ArrayList<>();
        int count = 0, l = 0, r = 0;
        int[] res;
        while (line[r] + line[l] <= target) {

            for (int i = l; i <= r; i++) {
                count += line[i];
            }

            if (count == target && r - l + 1 >= 2) {
                res = new int[r - l + 1];
                for (int i = 0, j = l; i < res.length; i++, j++) {
                    res[i] = line[j];
                }
                arr.add(res);
            }
            if (count > target) {
                int cot = count;
                while (cot > target && r >= l) {
                    l += 1;
                    cot = 0;
                    for (int i = l; i <= r; i++) {
                        cot += line[i];
                    }
                    if (cot == target) {
                        res = new int[r - l + 1];
                        for (int i = 0, j = l; i < res.length; i++, j++) {
                            res[i] = line[j];
                        }
                        arr.add(res);
                    }
                }
            }
            count = 0;
            r++;
        }

        return arr.toArray(new int[arr.size()][]);
    }


    /**
     *  滑动窗口思想
     * @param target
     * @return
     */
    public static int[][] daolao_findContinuousSequence(int target) {
        int left = 1, right = 1;
        List<int[]> res = new ArrayList<>();
        int sum = 0;

        while(left <= target / 2)
        {
            if(sum < target)
            {
                sum += right;
                right++;
            }
            else if(sum > target)
            {
                sum -= left;
                left++;
            }
            else{
                int[] arr = new int[right - left];
                for(int k = left; k < right; k++)
                    arr[k - left] = k;
                res.add(arr);

                sum-= left;
                left++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }



}
