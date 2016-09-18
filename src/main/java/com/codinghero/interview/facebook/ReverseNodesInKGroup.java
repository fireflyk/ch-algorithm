package com.codinghero.interview.facebook;

/**
 * 1->2->3->4->5->6<br/>
 * reverseKGroup(node1, 4)<br/>
 * 4->3->2->1->6->5
 * 
 * @author tliu
 *
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;
        return reverseKGroup(head, null, k, k);
    }

    public ListNode reverseKGroup(ListNode head, ListNode tail, int k, int curK) {
        if (head == null) {
            return null;
        }
        // 2, 3, 6
        if (k > curK && curK > 1) {
            ListNode result = reverseKGroup(head.next, tail, k, curK - 1);
            // 2, 3
            if (result != null)
                head.next.next = head;
            // 2, 3, 6
            return result;
        }
        // 1, 5
        else if (curK == k) {
            ListNode next = head.next;
            ListNode result = reverseKGroup(head.next, head, k, curK - 1);
            // 1
            if (result != null) {
                next.next = head;
                return result;
            }
            // 5
            else {
                return head;
            }

        }
        // 4
        else {
            ListNode result = reverseKGroup(head.next, null, k, k);
            tail.next = result;
            return head;
        }
    }
}
