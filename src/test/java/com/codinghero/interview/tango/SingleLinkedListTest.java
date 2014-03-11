package com.codinghero.interview.tango;

import junit.framework.Assert;

import org.junit.Test;

public class SingleLinkedListTest {

	@Test
	public void test1() {
		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
		list.addTail(list.createNode(1));
		Assert.assertEquals(1, list.size());
		list.removeHead();
		Assert.assertEquals(0, list.size());
	}
}
