package com.codinghero.interview.tango;

import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicateTest {

	@Test
	public void testRemoveDuplicate() {
		Integer[] arr = new Integer[] { 1, 5, 4, 2, 1, 6, 2, null, 7, 5 };
		new RemoveDuplicate().removeDuplicate(arr);
		Assert.assertEquals(10, arr.length);
		Assert.assertArrayEquals(new Integer[] { 1, 5, 4, 2, 6, 7, null, null,
				null, null }, arr);
	}
}
