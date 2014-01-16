package com.codinghero.acm.leetcode;

import java.util.ArrayList;

public class BinaryTreeInorderTraversal {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		inorderTraversal(root, result);
		return result;
	}
	
	private void inorderTraversal(TreeNode root, ArrayList<Integer> result) {
		if (root == null)
			return;
		inorderTraversal(root.left, result);
		result.add(root.val);
		inorderTraversal(root.right, result);
	}
}
