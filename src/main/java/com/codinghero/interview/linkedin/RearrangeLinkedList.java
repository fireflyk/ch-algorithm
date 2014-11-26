package com.codinghero.interview.linkedin;

/**
 * <pre>
 * 1->2->3->4->5 => 1->5->2->4->3
 * (1(2(3)4)5) => 1->5->(2(3)4) => 1->5->2->4->(3) => 1->5->2->4->3
 * </pre>
 * 
 * @author Tong Liu
 * 
 */
public class RearrangeLinkedList {
	public void arrange(final ListNode head) {
		innerArrange(head, length(head));
	}

	private int length(ListNode head) {
		int length = 0;
		while (head != null) {
			length++;
			head = head.next;
		}
		return length;
	}
	
	/**
	 * return outer tail node
	 * 
	 * @param head
	 * @param length
	 * @return
	 */
	private ListNode innerArrange(final ListNode head, final int length) {
		if (length == 1) {
			ListNode outerTail = head.next;
			head.next = null;
			return outerTail;
		} else if (length == 2) {
			ListNode outerTail = head.next.next;
			head.next.next = null;
			return outerTail;
		}

		ListNode innerHead = head.next;
		ListNode tail = innerArrange(innerHead, length - 2);
		ListNode outerTail = tail.next;

		head.next = tail;
		tail.next = innerHead;

		return outerTail;
	}
}
