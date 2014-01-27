package com.codinghero.acm.leetcode;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

public class LetterCombinationsOfAPhoneNumberTest {
	@Test
	public void test() {
		LetterCombinationsOfAPhoneNumber instance = new LetterCombinationsOfAPhoneNumber();
		ArrayList<String> result = instance.letterCombinations("223");
		Assert.assertEquals(27, result.size());
		
		result = instance.letterCombinations("");
		Assert.assertEquals(1, result.size());
	}
}
