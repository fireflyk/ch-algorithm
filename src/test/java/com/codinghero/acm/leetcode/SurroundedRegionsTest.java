package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class SurroundedRegionsTest {
	
	@Test
	public void test1() {
		int[][] arr = new int[2][3];
		Assert.assertEquals(2, arr.length);
		Assert.assertEquals(3, arr[0].length);
//		
//		SurroundedRegions surroundedRegions = new SurroundedRegions();
//		boolean[][] visited = new boolean[1][1];
//		surroundedRegions.init(new char[1][1], visited);
//		Assert.assertEquals(true, visited[0][0]);
//		
//		visited = new boolean[2][2];
//		surroundedRegions.init(new char[2][2], visited);
//		Assert.assertEquals(true, visited[0][0]);
//		Assert.assertEquals(true, visited[1][1]);
//		Assert.assertEquals(true, visited[0][1]);
//		Assert.assertEquals(true, visited[1][0]);
//		
//		visited = new boolean[1][2];
//		surroundedRegions.init(new char[1][2], visited);
//		Assert.assertEquals(true, visited[0][0]);
//		Assert.assertEquals(true, visited[0][1]);
//		
//		visited = new boolean[2][1];
//		surroundedRegions.init(new char[2][1], visited);
//		Assert.assertEquals(true, visited[0][0]);
//		Assert.assertEquals(true, visited[1][0]);
	}
	
	@Test
	public void test2() {
		char[][] board = {
				{ 'X', 'X', 'X', 'X' }, 
				{ 'X', 'O', 'X', 'X' },
				{ 'X', 'X', 'O', 'O' }, 
				{ 'X', 'O', 'X', 'X' } };
		SurroundedRegions surroundedRegions = new SurroundedRegions();
		surroundedRegions.solve(board);
		Assert.assertEquals('X', board[0][0]);
		Assert.assertEquals('X', board[1][1]);
		Assert.assertEquals('O', board[2][2]);
		Assert.assertEquals('O', board[2][3]);
		Assert.assertEquals('O', board[3][1]);
	}
	
	@Test
	public void test3() {
		char[][] board = {
				{ 'O' }};
		SurroundedRegions surroundedRegions = new SurroundedRegions();
		surroundedRegions.solve(board);
		Assert.assertEquals('O', board[0][0]);
	}
}
