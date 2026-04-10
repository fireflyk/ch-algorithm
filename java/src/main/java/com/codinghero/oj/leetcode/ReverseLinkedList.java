package com.codinghero.oj.leetcode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        ListNode next = head.next;
        next.next = head;
        head.next = null;
        return newHead;
    }

}
