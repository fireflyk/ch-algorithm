package com.codinghero.acm.leetcode;

public class ConstructBinaryTreeFromInorderAndPreorderTraversal {
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (inorder == null || preorder == null)
			return null;
		return buildTree(inorder, 0, inorder.length - 1, preorder, 0,
				preorder.length - 1);
	}
	
	private TreeNode buildTree(int[] inorder, int startI, int endI, int[] preorder, int startP, int endP) {
		if (startI == endI)
			return new TreeNode(inorder[startI]);
		else if (startI > endI)
			return null;
		
		TreeNode root = new TreeNode(preorder[startP]);
		
		int i = startI;
		for (; i <= endI; i++)
			if (inorder[i] == root.val)
				break;

		// inorder: 4, 2, 1, 6, 3, 7; preorder: 1, 2, 4, 3, 6, 7
		// 4, 2; 2, 4
		root.left = buildTree(inorder, startI, i - 1, preorder, startP + 1, startP
				+ (i - startI));
		// 6, 3, 7; 3, 6, 7
		root.right = buildTree(inorder, i + 1, endI, preorder, startP
				+ (i - startI) + 1, endP);
		return root;
	}
}
