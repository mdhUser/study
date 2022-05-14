package org.maxwell.algorithm.链表;

import org.maxwell.algorithm.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/11 12:22
 */
public class Solution_141_环形链表 {
    /**
     * hashset解决
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> history = new HashSet<>();
        while (head != null) {
            if (!history.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public boolean hasCycle_pointer(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != slow) {
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }


}