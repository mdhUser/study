package org.maxwell.algorithm.easy;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/11 23:55
 */
public class Solution_203_移除链表元素 {

    public ListNode removeElements(ListNode head, int val) {
        if (head.next == null)
            return head;
        if (head.val == val)
            head = head.next;

        return removeElements(head.next, val);
    }


    /**
     *  超时。。。
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements1(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }


}
