package org.maxwell.algorithm.链表;

import org.maxwell.algorithm.ListNode;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/14 16:45
 */
public class Solution_83_删除排序链表中的重复元素 {

    public static void main(String[] args) {

        ListNode node = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode())));
        deleteDuplicates(node);
    }


    /**
     * 迭代法
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode tmp = head;
        while (tmp.next != null) {
            if (tmp.val == tmp.next.val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return head;
    }


}
