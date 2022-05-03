package org.maxwell.algorithm.easy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/3 12:42
 */
public class Solution_387_字符串中的第一个唯一字符 {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("aaaabrehhjhkds"));
    }

    /**
     * 方法一：使用哈希表存储频数
     * 空间复杂度过高效率低
     *
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {

        char[] cs = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < cs.length; i++) {
            if (map.containsKey(cs[i])) {
                map.put(cs[i], map.get(cs[i]) + 1);
            } else {
                map.put(cs[i], 1);
            }
        }

        for (int i = 0; i < cs.length; i++) {
            if (map.get(cs[i]) == 1)
                return i;
        }

        return -1;
    }

    /**
     * 方法二：使用哈希表存储索引
     *
     * @param s
     * @return
     */
    public int firstUniqChar_useIndex(String s) {
        Map<Character, Integer> position = new HashMap<Character, Integer>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (position.containsKey(ch)) {
                position.put(ch, -1);
            } else {
                position.put(ch, i);
            }
        }
        int first = n;
        for (Map.Entry<Character, Integer> entry : position.entrySet()) {
            int pos = entry.getValue();
            if (pos != -1 && pos < first) {
                first = pos;
            }
        }
        if (first == n) {
            first = -1;
        }
        return first;
    }

}

class Pair{

    char c;
    int index;

    public Pair(char c, int index) {
        this.c = c;
        this.index = index;
    }
}