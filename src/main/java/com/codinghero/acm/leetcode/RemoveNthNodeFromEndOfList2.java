package com.codinghero.acm.leetcode;

public class RemoveNthNodeFromEndOfList2 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return null;

		ListNode emptyHead = new ListNode(0);
		emptyHead.next = head;

		ListNode prev = null, last = emptyHead;
		int i = 0;
		for (; i < n; i++) {
			last = last.next;
			if (last == null)
				return null;
		}
		// right move to end
		prev = emptyHead;
		while (last.next != null) {
			prev = prev.next;
			last = last.next;
		}

		// remove
		ListNode removed = prev.next;
		prev.next = prev.next.next;
		removed.next = null;

		return emptyHead.next;
	}
}
