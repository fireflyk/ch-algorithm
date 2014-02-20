package com.codinghero.acm.leetcode;

import org.junit.Test;

public class ConstructBinaryTreeFromInorderAndPostorderTraversalTest {
	
	private ConstructBinaryTreeFromInorderAndPostorderTraversal instance = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
	
	@Test
	public void test1() {
		instance.buildTree(new int[] { -1 }, new int[] { -1 });
	}

	@Test
	public void test2() {
		instance.buildTree(new int[] { 1, 2 }, new int[] { 2, 1 });
	}

	@Test
	public void test3() {
		instance.buildTree(new int[] { 4, 2, 1, 6, 3, 7 }, new int[] { 4, 2, 6, 7, 3, 1 });
	}
}
