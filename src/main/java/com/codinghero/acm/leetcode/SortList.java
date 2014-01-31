package com.codinghero.acm.leetcode;

/**
 * TLE<br/>
 * Quick Sort is O(n^2) in the worst case
 * 
 * @author Tong Liu
 * 
 */
public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null)
			return null;
		int length = 0;
		ListNode iter = head;
		while (iter != null) {
			length++;
			iter = iter.next;
		}
		return mergeSort(head, length);
	}
	
	private ListNode mergeSort(ListNode head, int length) {
		if (length == 1) {
			return head;
		}
		ListNode iter = head;
		for (int i = 0; i < length / 2 - 1; i++) {
			iter = iter.next;
		}
		ListNode rightHead = iter.next;
		iter.next = null;
		
		ListNode newLeftHead = mergeSort(head, length / 2);
		ListNode newRightHead = mergeSort(rightHead, length - length / 2);
		ListNode newHead = merge(newLeftHead, newRightHead);
		
		return newHead;
				
//		for (; i < length; i++) {
//			if (right != null) {
//				right.next = iter;
//				right = right.next;
//			} else {
//				right = iter;
//			}
//			iter = iter.next;
//		}
	}
	
	private ListNode merge(ListNode head1, ListNode head2) {
		ListNode head = new ListNode(-1), result = head;
		while (head1 != null && head2 != null) {
			if (head1.val <= head2.val) {
				// add head1 to result
				result.next = head1;
				// head1 right move
				head1 = head1.next;
				// result iter move to tail
				result = result.next;
				// result tail to null
				result.next = null;
			} else {
				result.next = head2;
				head2 = head2.next;
				result = result.next;
				result.next = null;
			}
		}
		while (head1 != null) {
			result.next = head1;
			head1 = head1.next;
			result = result.next;
			result.next = null;
		}
		while (head2 != null) {
			result.next = head2;
			head2 = head2.next;
			result = result.next;
			result.next = null;
		}
		return head.next;
	}
	
//	private class ListNodeResult {
//		private ListNode head;
//		private ListNode tail;
//		
//		public ListNodeResult(ListNode head, ListNode tail) {
//			this.head = head;
//			this.tail = tail;
//		}
//	}
}
