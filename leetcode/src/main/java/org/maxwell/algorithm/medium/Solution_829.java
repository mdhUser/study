package org.maxwell.algorithm.medium;

import org.junit.Test;

/**
 * @description: 连续整数求和
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/20 0:40
 */
public class Solution_829 {

    public static void main(String[] args) {

        System.out.println(consecutiveNumbersSum(313653678));

    }

    /**
     *  我的屎山
     * @param n
     * @return
     */
    public static int consecutiveNumbersSum(int n) {
        int l = 1, r = 0, sum = 0, ans = 0;
        while (r < n) {
            if (sum < n) {
                r++;
                sum += r;
            } else if (sum > n) {
                sum -= l;
                l++;
            } else {
                ans++;
                sum -= l;
                l++;
            }
        }
        return ans + 1;

    }


    @Test
    public void test(){
        dl_consecutiveNumbersSum(313653678);
    }

    /**
     *  大佬 等差数列思想
     * @param N
     * @return
     */
    public int dl_consecutiveNumbersSum(int N) {

        int res = 1;
        for (int i = 2; i < Math.sqrt(2 * N); ++i) {
            if ((N - i * (i - 1) / 2) % i == 0) ++res;
        }
        return res;

    }




}
