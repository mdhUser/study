package org.maxwell.algorithm.字符串;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/10 23:54
 */
public class Solution_242_有效的字母异位词 {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

        int[] letter = new int[26];

        for (char c : s.toCharArray()) {
            letter[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            letter[c - 'a']--;
        }

        for (int i : letter) {
            if (i != 0)
                return false;
        }

        return true;
    }

}
