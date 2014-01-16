package com.codinghero.acm.leetcode;

public class ConvertSortedListToBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		ListNode cur = head;
		int length = 0;
		while (cur != null) {
			cur = cur.next;
			length++;
		}
		return this.sortedListToBST(head, 0, length - 1).childRoot;
	}

	private Result sortedListToBST(ListNode head, int start, int end) {
		if (start > end)
			return new Result(head, null);
		int mid = start + (end - start) / 2;
		
		// left
		Result leftResult = sortedListToBST(head, start, mid - 1);
		
		// root
		ListNode curListNode = leftResult.curListNode;
		TreeNode root = new TreeNode(curListNode.val);
		root.left = leftResult.childRoot;
		curListNode = curListNode.next;
		
		// right
		Result rightResult = sortedListToBST(curListNode, mid + 1, end);
		root.right = rightResult.childRoot;
		
		return new Result(rightResult.curListNode, root);
	}

	private class Result {
		private ListNode curListNode;
		private TreeNode childRoot;

		private Result(ListNode curListNode, TreeNode childRoot) {
			this.curListNode = curListNode;
			this.childRoot = childRoot;
		}
	}
}
