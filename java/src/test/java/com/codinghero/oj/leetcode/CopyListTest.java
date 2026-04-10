package com.codinghero.oj.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class CopyListTest {

	@Test
	public void testCopyRandomList() {
		Assert.assertEquals(null, new CopyList().copyRandomList(null));
	}

	@Test
	public void testCopyRandomList2() {
		RandomListNode n1 = new RandomListNode(1);
		RandomListNode n2 = new RandomListNode(2);
		RandomListNode n3 = new RandomListNode(3);
		RandomListNode n4 = new RandomListNode(4);
		RandomListNode n5 = new RandomListNode(5);
		RandomListNode n6 = new RandomListNode(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n1.random = n3;
		n2.random = n5;
		n4.random = n2;
		n5.random = n1;
		RandomListNode backup = new CopyList().copyRandomList(n1);
		Assert.assertEquals(3, backup.next.next.label);
		Assert.assertEquals(5, backup.next.random.label);
	}

	@Test
	public void testCopyRandomList3() {
		RandomListNode n1 = new RandomListNode(-1);
		RandomListNode n2 = new RandomListNode(-1);
		n1.next = n2;
		n1.random = n2;
		n2.random = n1;
		RandomListNode backup = new CopyList().copyRandomList(n1);
		Assert.assertEquals(-1, backup.label);
		Assert.assertEquals(-1, backup.next.label);
		Assert.assertEquals(-1, backup.random.label);
		Assert.assertEquals(-1, backup.random.random.label);
		Assert.assertEquals(null, backup.next.next);
	}
}
