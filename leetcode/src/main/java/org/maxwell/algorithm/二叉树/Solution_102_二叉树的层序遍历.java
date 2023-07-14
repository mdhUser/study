package org.maxwell.algorithm.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/7/13 17:21
 */
public class Solution_102_二叉树的层序遍历 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int levelNum = queue.size();
            //遍历当前层节点
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll();
                TreeNode left = node.left;
                if (left != null) {
                    queue.add(left);
                }
                TreeNode right = node.right;
                if (right != null) {
                    queue.add(right);
                }
                level.add(node.val);
            }
            result.add(level);
        }
        return result;
    }

}
