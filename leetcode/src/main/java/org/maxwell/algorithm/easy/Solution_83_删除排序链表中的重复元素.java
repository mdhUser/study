package org.maxwell.algorithm.easy;

import org.maxwell.algorithm.ListNode;

import java.util.ArrayList;
import java.util.List;

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

    public static ListNode deleteDuplicates(ListNode head) {

        List<Integer> record = new ArrayList<>();
        ListNode pre = new ListNode(0);
        ListNode tmp = head;
        pre.next = tmp;
        while (tmp != null) {
            record.add(tmp.val);
            if (tmp.next != null && record.contains(tmp.next.val)) {
               tmp.next=tmp.next.next;
            }
            tmp = tmp.next;
        }
        return pre.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }



}
