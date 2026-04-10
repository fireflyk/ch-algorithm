package com.codinghero.oj.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class MergeKSortedLists {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists == null)
			return null;
		LinkedList<Node> curList = new LinkedList<Node>();
		ListNode result = new ListNode(0);
		for (int i = 0; i < lists.size(); i++) {
			ListNode list = lists.get(i);
			if (list != null) {
				lists.set(i, list.next);
				curList.add(new Node(list.val, i));
			}
		}
		
		while(cur)
		return result.next;
	}

	private void insert(LinkedList<Node> list, Node insertedNode) {
		ListIterator<Node> iter = list.listIterator();
		while (iter.hasNext()) {
			Node node = iter.next();
			if (insertedNode.val < node.val) {
				int temp = node.val;
				node.val = insertedNode.val;
				insertedNode.val = temp;
				iter.add(insertedNode);
				break;
			}
		}
	}

	private class Node {
		private int index;
		private int val;

		private Node(int val, int index) {
			this.val = val;
			this.index = index;
		}
	}
}
