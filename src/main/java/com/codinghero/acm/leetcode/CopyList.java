package com.codinghero.acm.leetcode;

public class CopyList {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;

		RandomListNode origHead = head;
		
		// copy first node
		RandomListNode backupHead = new RandomListNode(head.label);
		// set random
		RandomListNode temp = head.random;
		if (temp != null) {
			head.random = backupHead;
			backupHead.random = temp;
		}
		// next
		RandomListNode prevNode = backupHead, curNode = backupHead.next;
		head = head.next;
		
		while (head != null) {
			// copy
			curNode = new RandomListNode(head.label);
			prevNode.next = curNode;

			// set random
			temp = head.random;
			if (temp != null) {
				head.random = curNode;
				curNode.random = temp;
			}

			// next
			prevNode = curNode;

			// next
			head = head.next;
		}

		curNode = backupHead;
		head = origHead;
		while (curNode != null) {
			if (curNode.random != null) {
				temp = curNode.random;
				curNode.random = curNode.random.random;
				temp.random = head;
			}
			head = head.next;
			curNode = curNode.next;
		}
		return backupHead;
	}
}
