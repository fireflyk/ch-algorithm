package com.codinghero.acm.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class SudokuSolverTest {
	@Test
	public void test() throws InterruptedException {
		Thread.sleep(1000);
		
		SudokuSolver1 instance1 = new SudokuSolver1();
		char[][] board = new char[][] {
				{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		long startTime = System.currentTimeMillis();
		instance1.solveSudoku(board);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		Assert.assertEquals('1', board[0][7]);
		Assert.assertEquals('9', board[3][2]);
		
		SudokuSolver2 instance2 = new SudokuSolver2();
		board = new char[][] {
				{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		startTime = System.currentTimeMillis();
		instance2.solveSudoku(board);
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}
