package com.codinghero.oj.leetcode;

/**
 * <pre>
 * 0->1(pre==cur)
 * 0->2(pre!=cur)
 * 
 * 1->1(pre=cur)
 * 1->3(pre!=cur)
 * 
 * 2->1(pre=cur)
 * 2->2(pre!=cur)
 * 
 * 3->1(pre=cur)
 * 3->2(pre!=cur)
 * </pre>
 * 
 * @author liutong01
 * 
 */
public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		final ListNode emptyHead = new ListNode(0);
		ListNode tail = emptyHead;
		int state = 0;
		
		if (head == null)
			return head;
		ListNode pre = head;
		ListNode cur = head.next;
		while (cur != null) {
			if (pre.val == cur.val) {
				state = 1;
			} else {
				if (state == 0) {
					state = 2;
				} else if (state == 1) {
					state = 3;
				} else if (state == 2) {
					state = 2;
				} else if (state == 3) {
					state = 2;
				}
			}
			if (state == 2) {
				tail = addTail(tail, pre);
			}
			pre = rightMove(pre);
			cur = rightMove(cur);
		}
		if (state == 0 || state == 2 || state == 3) {
			tail = addTail(tail, pre);
		}
		tail.next = null;
		
		return emptyHead.next;
	}
	
	private ListNode rightMove(ListNode node) {
		return node.next;
	}
	
	private ListNode addTail(ListNode tail, ListNode node) {
		tail.next = node;
		return rightMove(tail);
	}
}
