package org.maxwell.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/1 23:55
 */
public class Solution_1305_两棵二叉搜索树中的所有元素 {

    /**
     * 不讲武德版
     *
     * @param root1
     * @param root2
     * @return
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();
        inorder(root1, nums1);
        inorder(root2, nums2);

        nums1.addAll(nums2);
        nums1.sort((a, b) -> a - b);
        return nums1;
    }


    public void inorder(TreeNode node, List<Integer> list) {
        if (node != null) {
            inorder(node.left, list);
            list.add(node.val);
            inorder(node.right, list);
        }
    }

}

class TreeNode {

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