package org.maxwell.algorithm.二叉树;


import org.maxwell.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/28 23:25
 */
public class Solution_144_二叉树的前中后序遍历 {

    /**
     * 递归法
     */
    class Solution {

        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null)
                return new ArrayList<>();
            List<Integer> res = new ArrayList<>();
            branch(root, res);
            return res;
        }

        public void branch(TreeNode root, List<Integer> res) {
            if (root == null)
                return;
            res.add(root.val);
            branch(root.left, res);
            branch(root.right, res);
        }

    }

    


}
