package com.codinghero.acm.leetcode;

import org.junit.*;

public class ReorderListTest {

	@Test
	public void testReorderList() {
		// empty
		new ReorderList().reorderList(null);
		
		// one
		ListNode node0 = new ListNode(0);
		new ReorderList().reorderList(node0);
		Assert.assertEquals(null, node0.next);
		
		// odd number size
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node0.next = node1;
		node1.next = node2;
		new ReorderList().reorderList(node0);
		Assert.assertEquals(node2, node0.next);
		Assert.assertEquals(node1, node2.next);
		Assert.assertEquals(null, node1.next);
		
		// even number size
		ListNode node3 = new ListNode(3);
		node0.next = node1;
		node1.next = node2;
		node2.next = node3;
		new ReorderList().reorderList(node0);
		Assert.assertEquals(node3, node0.next);
		Assert.assertEquals(node1, node3.next);
		Assert.assertEquals(node2, node1.next);
		Assert.assertEquals(null, node2.next);
	}
}
