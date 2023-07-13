package org.maxwell.datastructuresAndAlgorithms.tree;

public class Node {
    /**
     * 节点值
     */
    public int value;
    /**
     * 左节点
     */
    public Node left;
    /**
     * 右节点
     */
    public Node right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}