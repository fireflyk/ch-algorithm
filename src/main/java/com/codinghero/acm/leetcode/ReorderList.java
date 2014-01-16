package com.codinghero.acm.leetcode;

import java.util.Stack;

public class ReorderList {
	public void reorderList(ListNode head) {
		Stack<ListNode> s = new Stack<ListNode>();
		int size = 0;
		ListNode cur = head;
		
		// push elements to a stack
		while (cur != null) {
			size++;
			s.push(cur);
			cur = cur.next;
		}
		
		// head0->tail0->head1, do iteratively
		while (size >= 2) {
			ListNode tailNode = s.pop();
			tailNode.next = head.next;
			head.next = tailNode;
			head = head.next.next;
			size -= 2;
		}
		
		// set the last pointer to null
		if (head != null)
			head.next = null;
	}
}
