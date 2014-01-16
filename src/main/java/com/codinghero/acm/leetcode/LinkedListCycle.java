package com.codinghero.acm.leetcode;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		
		// node with 2 steps is prev, node with 1 step is follow
		ListNode prev = head, follow = head;
		while(true) {
			// go 2 step
			prev = prev.next;
			// to the end?
			if (prev == null)
				return false;
			// surpass the following node?
			else if (prev == follow)
				return true;
			
			prev = prev.next;
			if (prev == null)
				return false;
			else if (prev == follow)
				return true;
			
			// go 1 step
			follow = follow.next;
		}
	}
}
