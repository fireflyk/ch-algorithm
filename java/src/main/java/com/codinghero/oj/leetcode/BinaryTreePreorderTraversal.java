package com.codinghero.oj.leetcode;

import java.util.ArrayList;

public class BinaryTreePreorderTraversal {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		preorderTraversal(root, result);
		return result;
	}
	
	private void preorderTraversal(TreeNode root, ArrayList<Integer> result) {
		if (root == null)
			return;
		result.add(root.val);
		preorderTraversal(root.left, result);
		preorderTraversal(root.right, result);
	}
}
