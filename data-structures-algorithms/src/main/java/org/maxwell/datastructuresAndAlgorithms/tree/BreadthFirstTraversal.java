package org.maxwell.datastructuresAndAlgorithms.tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.logging.Level;

/**
 * 广度优先遍历
 *
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/7/13 16:30
 */
public class BreadthFirstTraversal {


    /**
     * 使用队列实现 bfs
     *
     * @param root
     */
    public static void bfs(Node root) {

        if (Objects.isNull(root))
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println("value" + node.value);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }


}
