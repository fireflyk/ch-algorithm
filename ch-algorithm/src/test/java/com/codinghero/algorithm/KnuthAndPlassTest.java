package com.codinghero.algorithm;

import junit.framework.Assert;

import org.junit.Test;

import com.codinghero.algorithm.KnuthAndPlass;

public class KnuthAndPlassTest {
	@Test
	public void testPrint() {
		String[] words = new String[] {
			"aaa", "bb", "cc", "ddddd"
		};
		KnuthAndPlass knuthAndPlass = new KnuthAndPlass(words, 6);
		int[] result = knuthAndPlass.cal();
		Assert.assertEquals(result[0], 0);
		Assert.assertEquals(result[1], 1);
		Assert.assertEquals(result[2], 3);
		knuthAndPlass.print();
		
		System.out.println();
		knuthAndPlass = new KnuthAndPlass(
				"I'm a good guy, and I know what I should not to do!"
						.split("[ ]+"), 25);
		knuthAndPlass.print();
	}
}
