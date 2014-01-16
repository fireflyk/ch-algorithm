package com.codinghero.acm.leetcode;

import java.util.ArrayList;

public class InorderTraversal {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		if (root == null)
			return new ArrayList<Integer>();
		ArrayList<Integer> left = inorderTraversal(root.left);
		left.add(root.val);
		ArrayList<Integer> right = inorderTraversal(root.right);
		left.addAll(right);
		return left;
	}

}