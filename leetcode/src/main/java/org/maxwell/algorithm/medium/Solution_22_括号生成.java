package org.maxwell.algorithm.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/7/20 19:21
 */
public class Solution_22_括号生成 {

    private List<String> pathList = new ArrayList<>();
    private int maxPairCount = 0;

    public List<String> generateParenthesis(int n) {
        maxPairCount = n;
        backTracking("", 0, 0);
        return pathList;
    }

    private void backTracking(String path, int leftCount, int rightCount) {
        if (path.length() == maxPairCount * 2) {
            pathList.add(path);
            return;
        }
        if (leftCount < maxPairCount) {
            backTracking(path + "(", leftCount + 1, rightCount);
        }
        if (rightCount < leftCount) {
            backTracking(path + ")", leftCount, rightCount + 1);
        }
    }

    @Test
    public void test() {
        List<String> pathList = generateParenthesis(3);
        System.out.println(pathList);
    }
}
