package org.maxwell.algorithm.easy;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/8 1:35
 */
public class Solution_121_买卖股票的最佳时机 {

    public static void main(String[] args) {
        System.out.println(maxProfit_violence(new int[]{7, 1, 5, 3, 6, 4}));
    }

    /**
     * 动态规划解法
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int max = 0, min = prices[0];
        for (int price : prices) {
            max = Math.max(max, price - min);
            min = Math.min(min, price);
        }
        return max;
    }

    /**
     * 暴力(超时)
     *
     * @param prices
     * @return
     */
    public static int maxProfit_violence(int[] prices) {

        int len = prices.length, max = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int diff = prices[j] - prices[i];
                if (diff > 0) {
                    max = Math.max(max, diff);
                }
            }
        }
        return max;
    }






}
