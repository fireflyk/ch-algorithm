package com.codinghero.acm.leetcode;

import org.junit.Test;

public class TextJustificationTest {
	
	@Test
	public void test1() {
		String[] words = new String[] { "What","must","be","shall","be." };
		new TextJustification().fullJustify(words, 12);
	}
	
	@Test
	public void test2() {
		String[] words = new String[] { "" };
		new TextJustification().fullJustify(words, 0);
	}
}
