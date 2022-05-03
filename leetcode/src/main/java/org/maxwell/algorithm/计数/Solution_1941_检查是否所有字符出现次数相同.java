package org.maxwell.algorithm.计数;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/3 21:08
 */
public class Solution_1941_检查是否所有字符出现次数相同 {

    public static void main(String[] args) {
        System.out.println(areOccurrencesEqual("abacbc"));
    }

    public static boolean areOccurrencesEqual(String s) {

        int[] letter = new int[26];
        int len = s.length();

        for (int i = 0; i < len; ++i) {
            letter[s.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int l : letter) {
            if (l != 0 && count == 0)
                count = l;
            if (l != count && l != 0) {
                return false;
            }
        }

        return true;

    }


}
