package com.codinghero.interview.facebook;

/**
 * 1->2->3->4->5->6<br/>
 * reverseKGroup(node1, 4)<br/>
 * 4->3->2->1->6->5
 * 
 * @author tliu
 *
 */
public class ReverseNodesInKGroup2 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head;
        int tempK = k;
        // find the kth node
        while (--tempK > 0 && tail != null) {
            tail = tail.next;
        }
        if (tail == null) {
            return head;
        }

        // find next k nodes recursively
        ListNode result = reverseKGroup(tail.next, k);
        
        // reverse 1~k nodes
        ListNode cur = head.next, prev = head;
        while (++tempK < k) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = result;
        return tail;
    }
}
