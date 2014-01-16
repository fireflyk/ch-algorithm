package com.codinghero.acm.leetcode;

import java.util.ArrayList;

public class BinaryTreePostorderTraversal {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		postorderTraversal(root, result);
		return result;
	}

	private void postorderTraversal(TreeNode root, ArrayList<Integer> result) {
		if (root == null)
			return;
		postorderTraversal(root.left, result);
		postorderTraversal(root.right, result);
		result.add(root.val);
	}
}
