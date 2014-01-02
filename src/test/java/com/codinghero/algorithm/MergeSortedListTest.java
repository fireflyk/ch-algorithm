package com.codinghero.algorithm;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortedListTest {
	
	@Test
	public void testMerge() {
		List<Integer> list1 = Arrays.asList(new Integer[] { 1, 5, 21, 25 });
		List<Integer> list2 = Arrays.asList(new Integer[] { 2, 7, 8, 23 });
		new MergeSortedList().merge(list1, list2);
		Assert.assertArrayEquals(new Integer[] { 1, 2, 5, 7 }, list1.toArray());
		Assert.assertArrayEquals(new Integer[] { 8, 21, 23, 25 }, list2.toArray());
	}
}
