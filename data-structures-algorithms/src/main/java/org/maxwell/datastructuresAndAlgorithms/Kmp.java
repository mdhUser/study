package org.maxwell.datastructuresAndAlgorithms;

import java.util.Arrays;

public class Kmp {

    // 改进后的KMP算法不变
    public static int kmp(String s, String t) {
        int m = s.length(), n = t.length();
        int[] nextVal = new int[n];
        getNextVal(t, nextVal);
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (j == -1 || s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else j = nextVal[j];
        }
        if (j >= n) return i - n;
        else return -1;
    }

    // 计算nextVal数组变化了
    public static void getNextVal(String t, int[] nextVal) {
        int n = t.length();
        nextVal[0] = -1;
        for (int j = 0, k = -1; j < n - 1; ) {
            if (k == -1 || t.charAt(j) == t.charAt(k)) {
                j++;
                k++;
                if (t.charAt(j) != t.charAt(k)) nextVal[j] = k;
                else nextVal[j] = nextVal[k];
            } else k = nextVal[k];
        }
        System.out.println(Arrays.toString(t.toCharArray()));
        System.out.println(Arrays.toString(nextVal));
    }


    public static void main(String[] args) {
        String str = "abcabdabcabdc";
        System.out.println(kmp("dhsaodhabaabackajshdjsadh", str) > 0);
    }




}