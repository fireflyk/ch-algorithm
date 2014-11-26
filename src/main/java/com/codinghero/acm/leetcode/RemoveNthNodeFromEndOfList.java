package com.codinghero.acm.leetcode;

/**
 * Consider multi special case<br/>
 * length < n, result null; length==n, remove head; length>n, common case<br/>
 * 
 * @author Tong Liu
 *
 */
public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return null;
		
		ListNode prev = null, last = head;
		int i = 0;
		for (; i < n; i++) {
			last = last.next;
			if (last == null)
				break;
		}
		// n is greater than the length
		if (i < n - 1) {
			return null;
		}
		// n equals the length, so remove the head
		else if (i == n - 1) {
			ListNode newHead = head.next;
			head.next = null;
			return newHead;
		}
		// prev & last go right together
		else if (i == n) {
			prev = head;
			while (last.next != null) {
				prev = prev.next;
				last = last.next;
			}
			
			// remove
			ListNode removed = prev.next;
			prev.next = prev.next.next;
			removed.next = null;
			
			return head;
		}
		// won't happen
		else {
			throw new IllegalStateException();
		}
	}
}
