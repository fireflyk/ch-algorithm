package com.codinghero.oj.leetcode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null)
			return null;
		return buildTree(inorder, 0, inorder.length - 1, postorder, 0,
				postorder.length - 1);
	}
	
	private TreeNode buildTree(int[] inorder, int startI, int endI, int[] postorder, int startP, int endP) {
		if (startI == endI)
			return new TreeNode(inorder[startI]);
		else if (startI > endI)
			return null;
		
		TreeNode root = new TreeNode(postorder[endP]);
		
		int i = startI;
		for (; i <= endI; i++)
			if (inorder[i] == root.val)
				break;

		// inorder: 4, 2, 1, 6, 3, 7; postorder: 4, 2, 6, 7, 3, 1
		// 4, 2; 4, 2
		root.left = buildTree(inorder, startI, i - 1, postorder, startP, startP
				+ (i - 1 - startI));
		// 6, 3, 7; 6, 7, 3
		root.right = buildTree(inorder, i + 1, endI, postorder, startP
				+ (i - startI), endP - 1);
		return root;
	}
}
