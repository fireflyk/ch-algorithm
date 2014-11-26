package com.codinghero.acm.leetcode;

import org.junit.Test;

public class ConstructBinaryTreeFromInorderAndPreorderTraversalTest {
	
	private ConstructBinaryTreeFromInorderAndPreorderTraversal instance = new ConstructBinaryTreeFromInorderAndPreorderTraversal();
	
	@Test
	public void test1() {
		instance.buildTree(new int[] { -1 }, new int[] { -1 });
	}

	@Test
	public void test2() {
		instance.buildTree(new int[] { 1, 2, 3 }, new int[] { 3, 2, 1 });
	}

	@Test
	public void test3() {
		instance.buildTree(new int[] { 1, 2, 4, 3, 6, 7 }, new int[] { 4, 2, 1, 6, 3, 7 });
	}
}
