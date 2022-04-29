package org.maxwell.algorithm.easy;

import java.util.*;
import java.util.function.Function;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/17 17:49
 */
public class Solution_819 {


    public static void main(String[] args) {

        System.out.println(mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"}));

    }


    /**
     * 是否是2的倍数
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {

        if (n == 1) return true;
        int k = 2;
        for (int i = 1; i <= 31; i++) {
            k *= 2;
            if (k == Math.abs(n)) {
                return true;
            }
            if (k > Math.abs(n)) {
                return false;
            }
        }

        return false;
    }

    /**
     *  我的杰作
     * @param paragraph
     * @param banned
     * @return
     */
    public static String mostCommonWord(String paragraph, String[] banned) {

        String str = paragraph.toLowerCase();
        Map<String, Integer> map = new TreeMap<>();
        Comparator<Map.Entry<String, Integer>> comparator = (o1, o2) -> o2.getValue() - o1.getValue();

        String[] strs = str.split(" ");
        for (String s : strs) {
            char c = s.charAt(s.length() - 1);
            String words;
            if (c > 'z' || c < 'a') {
                words = s.substring(0, s.length() - 1);
            } else {
                words = s;
            }

            String[] split = words.split(",");
            if (split.length > 1) {
                for (String s1 : split) {
                    getTreeMap(banned,map,s1);
                }
            }else {
                getTreeMap(banned, map, words);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, comparator);

        return list.get(0).getKey();

    }

    private static Map<String,Integer> getTreeMap(String[] banned, Map<String, Integer> map, String words) {

        Function<String[], Boolean> ass = a -> {
            for (String s1 : a) {
                if (s1.equals(words))
                    return false;
            }
            return true;
        };

        if (ass.apply(banned)) {
            if (map.containsKey(words)) {
                map.put(words, map.get(words) + 1);
            } else {
                map.put(words, 1);
            }
        }
        return map;
    }

}
