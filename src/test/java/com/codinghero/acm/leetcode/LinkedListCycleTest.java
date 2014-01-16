package com.codinghero.acm.leetcode;

import org.junit.*;

public class LinkedListCycleTest {

	@Test
	public void test() {
		Assert.assertEquals(false, new LinkedListCycle().hasCycle(null));
		
		ListNode node0 = new ListNode(0);
		node0.next = node0;
		Assert.assertEquals(true, new LinkedListCycle().hasCycle(node0));
		
		ListNode node1 = new ListNode(1);
		node0.next = node1;
		Assert.assertEquals(false, new LinkedListCycle().hasCycle(node0));
		
		node1.next = node0;
		Assert.assertEquals(true, new LinkedListCycle().hasCycle(node0));
		
		node1.next = node1;
		Assert.assertEquals(true, new LinkedListCycle().hasCycle(node0));
		
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		node0.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node2;
		Assert.assertEquals(true, new LinkedListCycle().hasCycle(node0));
		
		node7.next = null;
		Assert.assertEquals(false, new LinkedListCycle().hasCycle(node0));
	}
}
