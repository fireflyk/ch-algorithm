package com.codinghero.oj.leetcode;

public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null)
			return null;
		return sortedArrayToBST(num, 0, num.length - 1);
	}
	
	private TreeNode sortedArrayToBST(int[] num, int start, int end) {
		if (start > end)
			return null;
		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = sortedArrayToBST(num, start, mid - 1);
		root.right = sortedArrayToBST(num, mid + 1, end);
		return root;
	}
}
