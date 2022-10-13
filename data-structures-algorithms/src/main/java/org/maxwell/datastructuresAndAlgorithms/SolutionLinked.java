package org.maxwell.datastructuresAndAlgorithms;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/30 21:06
 */
public class SolutionLinked {


    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        //当到达尾部，则停止递归
        if(head == null || head.next == null){
            //这里head是尾部
            return head;
        }
        ListNode tail = reverseList(head.next);
        //回溯过程，翻转。这里head是当前节点
        head.next.next = head;
        head.next = null;
        return tail;

    }


    /**
     * 反转链表值
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        //计数就完事=-=
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }

        int[] arr = new int[count];

        cur = head;
        count--;
        while (cur != null && count >= 0) {
            arr[count--] = cur.val;
            cur = cur.next;
        }
        return arr;
    }


}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}