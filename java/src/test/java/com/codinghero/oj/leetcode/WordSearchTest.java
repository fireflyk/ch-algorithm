package com.codinghero.oj.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class WordSearchTest {
	@Test
	public void test1() {
		WordSearch instance = new WordSearch();
		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' },
				{ 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		Assert.assertEquals(true, instance.exist(board, "ABCCED"));
	}

	@Test
	public void test2() {
		WordSearch instance = new WordSearch();
		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' },
				{ 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		Assert.assertEquals(true, instance.exist(board, "SEE"));
	}

	@Test
	public void test3() {
		WordSearch instance = new WordSearch();
		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' },
				{ 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		Assert.assertEquals(false, instance.exist(board, "ABCB"));
	}
}
