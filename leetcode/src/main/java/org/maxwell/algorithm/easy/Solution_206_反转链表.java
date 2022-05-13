package org.maxwell.algorithm.easy;

import org.maxwell.algorithm.ListNode;

import java.util.LinkedList;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/13 20:02
 */
public class Solution_206_反转链表 {


    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        System.out.println(reverseList(node));


    }

    public static ListNode reverseList(ListNode head) {

        LinkedList<ListNode> stack = new LinkedList<>();

        while (head != null) {
            stack.addFirst(head);
            head = head.next;
        }

        ListNode pre = new ListNode(0);
        ListNode tmp = pre;
        while (!stack.isEmpty()) {
            tmp.next = stack.removeFirst();
            tmp = tmp.next;
        }
        tmp.next = null;
        return pre.next;
    }

}
