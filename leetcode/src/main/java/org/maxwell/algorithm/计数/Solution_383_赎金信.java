package org.maxwell.algorithm.计数;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/10 23:33
 */
public class Solution_383_赎金信 {

    /**
     * 字符串计数
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) return false;

        int[] letter1 = new int[26];
        int[] letter2 = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            letter1[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            letter2[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < letter2.length; i++) {
            if (letter2[i] != 0 && letter2[i] > letter1[i]) return false;
        }
        return true;
    }


    public boolean canConstruct_leetcode(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if (cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }


}
