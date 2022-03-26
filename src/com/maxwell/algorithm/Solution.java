package com.maxwell.algorithm;

import java.math.BigDecimal;
import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {
        System.out.println(numberSummation(1.455, 2.2));

    }

    //todo 我的屎山
//    public static Double numberSummation(Number d1, Number d2) {
//
//        BigDecimal big = new BigDecimal(d1.toString());
//        BigDecimal big1 = new BigDecimal(d2.toString());
//        Double result = null;
//        if (big.scale() > big1.scale()) {
//            result = big.add(big1).setScale(big.scale()).doubleValue();
//        } else {
//            result = big.add(big1).setScale(big1.scale()).doubleValue();
//        }
//        return result;
//    }


    //todo 大佬编程思想
    public static <T> Double numberSummation(T t1, T t2) {

        BigDecimal sum = new BigDecimal(t1.toString()).add(new BigDecimal(t2.toString()));
        return sum.doubleValue();

    }


}

class Solution1 {

    public static void main(String[] args) {
        int n[] = {1, 5, 6};
        int[] ints = missingRolls(n, 3, 4);
        System.out.println(Arrays.toString(ints));

    }

    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = mean * (m + n);
        int missingSum = sum;
        for (int roll : rolls) {
            missingSum -= roll;
        }
        if (missingSum < n || missingSum > 6 * n) return new int[n];
        int[] ns = new int[n];
        int q = missingSum / n, mod = missingSum % n;
        for (int i = 0; i < ns.length; i++) {
            ns[i] = q + (i < mod ? 1 : 0);
        }
        return ns;
    }
}