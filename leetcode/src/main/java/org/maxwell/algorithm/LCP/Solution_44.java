package org.maxwell.algorithm.LCP;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 开幕式焰火
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/25 1:03
 */
public class Solution_44 {

    Set<Integer> set = new HashSet<>();

    static TreeNode treeNode;

    static {
        treeNode = new TreeNode(1);
        treeNode.left=new TreeNode(3);
        treeNode.right=new TreeNode(2);
        treeNode.left.left=new TreeNode(1);
        treeNode.right.left=new TreeNode(2);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void checkNode(TreeNode root) {
        if (root != null) {
            set.add(root.val);
            checkNode(root.left);
            checkNode(root.right);
        }
    }

    public int numColor(TreeNode root) {
        checkNode(root);
        return set.size();
    }


    public static void main(String[] args) {

        int result = new Solution_44().numColor(treeNode);
        System.out.println("结果:"+result);

    }

}


