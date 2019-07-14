package com.codinghero.oj.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class ConvertSortedListToBinarySearchTreeTest {
	
	@Test
	public void test1() {
		ListNode node0 = new ListNode(0);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node0.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		TreeNode root = new ConvertSortedListToBinarySearchTree().sortedListToBST(node0);
		Assert.assertArrayEquals(new Integer[]{0,1,2,3,4,5}, 
				new BinaryTreeInorderTraversal().inorderTraversal(root).toArray());
	}

	@Test
	public void test2() {
		Assert.assertEquals(null, new ConvertSortedListToBinarySearchTree().sortedListToBST(null));
		Assert.assertEquals(null, new ConvertSortedListToBinarySearchTree().sortedListToBST(new ListNode(0)).left);
	}
}
