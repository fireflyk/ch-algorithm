package com.codinghero.oj.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ListToTree {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		
		TreeNode root = new TreeNode(head.val);
		ListNode cur = head.next;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while (cur != null) {
			TreeNode father = queue.poll();
			
			TreeNode leftSon = new TreeNode(cur.val);
			father.left = leftSon;
			queue.offer(leftSon);
			cur = cur.next;
			
			if (cur == null)
				break;
			TreeNode rightSon = new TreeNode(cur.val);
			father.right = rightSon;
			queue.offer(rightSon);
			cur = cur.next;
		}
		
		return root;
	}
}
