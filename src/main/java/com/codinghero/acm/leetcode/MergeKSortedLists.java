package com.codinghero.acm.leetcode;

import java.util.ArrayList;

public class MergeKSortedLists {
	
	private static int NO_DATA = -1;
	
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists == null)
			return null;
		
		ListNode resultHead = new ListNode(NO_DATA), resultCur = resultHead;
		int minIndex;
		while (true) {
			minIndex = NO_DATA;
			// find minimum
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < lists.size(); i++) {
				ListNode node = lists.get(i);
				if (node != null) {
					if (node.val <= min) {
						min = node.val;
						minIndex = i;
					}
				}
			}
			
			if(minIndex != NO_DATA) {
				// remove node from list
				ListNode minNode = lists.get(minIndex);
				lists.set(minIndex, minNode.next);

				// add node to result
				resultCur.next = minNode;
				resultCur = minNode;
				minNode.next = null;
			} else {
				break;
			}
		}
		
		return resultHead.next;
	}
}
