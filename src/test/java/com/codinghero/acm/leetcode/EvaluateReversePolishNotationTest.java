package com.codinghero.acm.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class EvaluateReversePolishNotationTest {
	
	@Test
	public void testEvalRPN() {
		Assert.assertEquals(
				9,
				new EvaluateReversePolishNotation().evalRPN(new String[] { "2","1", "+", "3", "*" }));
		Assert.assertEquals(
				6,
				new EvaluateReversePolishNotation().evalRPN(new String[]{"4", "13", "5", "/", "+"}));
	}
}
