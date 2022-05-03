package org.maxwell.algorithm.计数;

import java.util.*;

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


    /**
     * 队列解法
     *
     * @param s
     * @return
     */
    public int firstUniqChar_queue(String s) {
        Map<Character, Integer> position = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (!position.containsKey(ch)) {
                position.put(ch, i);
                queue.offer(new Pair(ch, i));
            } else {
                position.put(ch, -1);
                while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) {
                    queue.poll();
                }
            }
        }
        return queue.isEmpty() ? -1 : queue.poll().pos;
    }


    /**
     * 最快
     *
     * @param s
     * @return
     */
    public static int firstUniqChar_fast(String s) {

        int len = s.length();
        int[] array = new int[26];
        for (int i = 0; i < len; ++i) {
            array[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < array.length; ++i) {
            if (array[i] == 1) {
                return s.indexOf((char) (i + 'a'));
            }
        }

        return -1;

    }

}

class Pair {
    char ch;
    int pos;

    Pair(char ch, int pos) {
        this.ch = ch;
        this.pos = pos;
    }
}