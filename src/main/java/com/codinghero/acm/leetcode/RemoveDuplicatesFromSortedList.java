package com.codinghero.acm.leetcode;

public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		ListNode cur = head.next;
		
		ListNode pre = head;
		while (cur != null) {
			if (pre.val == cur.val) {
				pre.next = cur.next;
				cur = pre.next;
			} else {
				pre = cur;
				cur = cur.next;
			}
		}
		return head;
	}
}
