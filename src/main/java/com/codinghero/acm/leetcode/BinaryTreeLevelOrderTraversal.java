package com.codinghero.acm.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		// save the node by level with queue
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		if (root != null)
			queue.add(root);
		
		// scan level by level
		while (!queue.isEmpty()) {
			Queue<TreeNode> nextQueue = new ArrayDeque<TreeNode>();
			ArrayList<Integer> line = new ArrayList<Integer>();
			// scan a level
			while(!queue.isEmpty()) {
				TreeNode node = queue.poll();
				line.add(node.val);
				if (node.left != null)
					nextQueue.add(node.left);
				if (node.right != null)
					nextQueue.add(node.right);
			}
			result.add(line);
			queue = nextQueue;
		}
		
		return result;
	}
}
