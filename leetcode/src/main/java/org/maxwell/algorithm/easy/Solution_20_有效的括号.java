package org.maxwell.algorithm.easy;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/15 1:54
 */
public class Solution_20_有效的括号 {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {

        int len = s.length();
        if ((len & 1) == 1) return false;

        Map<Character, Character> pairs = new HashMap<>() {{
                put(')', '(');
                put(']', '[');
                put('}', '{');
        }};

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (pairs.containsKey(c)){
                if (stack.isEmpty()||stack.peek()!=pairs.get(c))
                    return false;
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}
