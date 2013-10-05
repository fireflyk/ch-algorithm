package com.codinghero.algorithm;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

public class SortedLinkedListToBSTTest {
	
	private LinkedList<Integer> list = new LinkedList<Integer>();
	
	public SortedLinkedListToBSTTest() {
		list.addAll(Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7 }));
	}
	
	@Test
	public void testConvert() {
		new SortedLinkedListToBST<Integer>().convert(list);
	}
}
