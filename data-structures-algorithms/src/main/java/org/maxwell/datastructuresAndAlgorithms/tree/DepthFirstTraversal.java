package org.maxwell.datastructuresAndAlgorithms.tree;

import java.util.Stack;

/**
 * 深度优秀遍历
 *
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/7/13 15:42
 */
public class DepthFirstTraversal {



    /**
     * 递归实现深度优先遍历
     * 如果层级过深，很容易导致栈溢出
     *
     * @param treeNode
     */
    public static void dfs(Node treeNode) {
        if (treeNode == null) {
            return;
        }
        // 遍历节点
        process(treeNode);
        // 遍历左节点
        dfs(treeNode.left);
        // 遍历右节点
        dfs(treeNode.right);
    }


    /**
     * 使用栈来实现dfs
     *
     * @param root
     */
    public static void dfsWithStack(Node root) {
        if (root == null)
            return;
        Stack<Node> stack = new Stack<>();
        //先把根节点压栈
        stack.push(root);
        while (!stack.isEmpty()) {
            Node treeNode = stack.pop();
            process(treeNode);
            //先压右节点 符合深度优先遍历条件 （弹栈的时候先出左节点）
            if (treeNode.right != null)
                stack.push(treeNode.right);

            if (treeNode.left != null)
                stack.push(treeNode.left);
        }

    }


    private static void process(Node treeNode) {
        System.out.println("------遍历结果-----");
        System.out.println(treeNode.value);
    }


}
