package com.codinghero.acm.leetcode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode s = new ListNode(0);
		ListNode head = s;
		int plus = 0;
		while (l1 != null || l2 != null) {
			// get number from list1 and list2
			int n1 = 0, n2 = 0;
			if (l1 != null)
				n1 = l1.val;
			if (l2 != null)
				n2 = l2.val;
			
			// add 2 numbers
			int sum = n1 + n2 + plus;
			plus = sum / 10;
			sum = sum % 10;
			
			// add node and move to next
			s.next = new ListNode(sum);
			s = s.next;
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		if (plus > 0) {
			s.next = new ListNode(plus);
		}
		
		return head.next;
	}
}
