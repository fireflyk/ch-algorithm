package com.codinghero.acm.leetcode;

/**
 * TLE<br/>
 * Quick Sort is O(n^2) in the worst case
 * 
 * @author Tong Liu
 * 
 */
public class SortList2 {
	public ListNode sortList(ListNode head) {
		ListNode virtualHead = new ListNode(0);
		virtualHead.next = head;
		innerSortList(virtualHead);
		return virtualHead.next;
	}
	
	private ListNode innerSortList(ListNode head) {
		final ListNode pivot = head.next;
		if (pivot == null) {
			return head;
		}
		
		// put the node to left and right
		final ListNode leftHead = new ListNode(0);
		final ListNode rightHead = new ListNode(0);
		ListNode leftIter = leftHead;
		ListNode rightIter = rightHead;
		ListNode iter = pivot;
		while ((iter = iter.next) != null) {
			if (iter.val <= pivot.val) {
				leftIter.next = new ListNode(iter.val);
				leftIter = leftIter.next;
			} else {
				rightIter.next = new ListNode(iter.val);
				rightIter = rightIter.next;
			}
		}
		
		// invoke left and right recusively
		ListNode leftTail = innerSortList(leftHead);
		ListNode rightTail = innerSortList(rightHead);
		
		// left -> pivot -> right
		leftTail.next = pivot;
		pivot.next = rightHead.next;
		// change head
		head.next = leftHead.next;
		// return tail
		return rightHead.next == null ? pivot : rightTail;
	}
}
