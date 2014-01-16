package com.codinghero.acm.leetcode;

public class CopyList {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;

		// copy node & set next
		RandomListNode origCur = head;
		RandomListNode destCur = null;
		while (origCur != null) {
			destCur = new RandomListNode(origCur.label);
			// next
			RandomListNode temp = origCur.next;
			origCur.next = destCur;
			origCur = destCur.next = temp;
		}
		RandomListNode destHead = head.next;
		
		
		// set random
		origCur = head;
		while (origCur != null) {
			destCur = origCur.next;
			if (origCur.random != null)
				destCur.random = origCur.random.next;
			origCur = destCur.next;
		}
		
		// split two list
		origCur = head;
		while (origCur != null) {
			destCur = origCur.next;
			origCur.next = destCur.next;
			origCur = origCur.next;
			destCur.next = origCur != null ? origCur.next : null;
		}
		
		return destHead;
	}
}
