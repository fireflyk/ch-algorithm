package com.codinghero.interview.linkedin;

import junit.framework.Assert;

import org.junit.Test;

public class RearrangeLinkedListTest {

	private RearrangeLinkedList instance = new RearrangeLinkedList();
	
	@Test
	public void test1() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		instance.arrange(node1);
		
		Assert.assertEquals(1, node1.val);
		Assert.assertEquals(5, node1.next.val);
		Assert.assertEquals(2, node1.next.next.val);
		Assert.assertEquals(4, node1.next.next.next.val);
		Assert.assertEquals(3, node1.next.next.next.next.val);
		Assert.assertEquals(null, node1.next.next.next.next.next);
	}
	
	@Test
	public void test2() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		instance.arrange(node1);
		
		Assert.assertEquals(1, node1.val);
		Assert.assertEquals(4, node1.next.val);
		Assert.assertEquals(2, node1.next.next.val);
		Assert.assertEquals(3, node1.next.next.next.val);
		Assert.assertEquals(null, node1.next.next.next.next);
	}
	
	@Test
	public void test3() {
		ListNode node1 = new ListNode(1);
		
		instance.arrange(node1);
		
		Assert.assertEquals(1, node1.val);
		Assert.assertEquals(null, node1.next);
	}
}
