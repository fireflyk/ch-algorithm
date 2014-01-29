package com.codinghero.acm.leetcode;

public class SudokuSolver2 {

	private static final int N = 9;
	
	private static final ValidSudoku validator = new ValidSudoku();

	public void solveSudoku(char[][] board) {
		solveSudoku(board, 0, 0);
	}
	
	private boolean solveSudoku(char[][] board, int startI, int startJ) {
		for (int i = startI, j = startJ; j < N; j++) {
			if (board[i][j] == '.') {
				return try1To9(board, i, j);
			}
		}
		
		for (int i = startI + 1; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == '.') {
					return try1To9(board, i, j);
				}
			}
		}
		// there is no '.' cell
		return true;
	}
	
	private boolean try1To9(char[][] board, int i, int j) {
		for (char k = '1'; k <= '9'; k++) {
			board[i][j] = k;
			if (validator.isValidSudoku(board) && solveSudoku(board, i, j))
				return true;
			board[i][j] = '.';
		}
		return false;
	}
	
	private static class ValidSudoku {
		
		private static final int N = 9;
		
		private static final int CELL_N = 3;
		
		public boolean isValidSudoku(char[][] board) {
			for (int i = 0; i < N; i++) {
				if (!isValidRow(board, i))
					return false;
				if (!isValidColumn(board, i))
					return false;
			}
			for (int i = 0; i < N; i += CELL_N) {
				for (int j = 0; j < N; j += CELL_N) {
					if (!isValidBlock(board, i, j))
						return false;
				}
			}
			return true;
		}
		
		private boolean isValidCell(char[][] board, boolean[] data, int i, int j) {
			if (board[i][j] == '.')
				return true;
			else if (data[board[i][j] - '0'])
				return false;
			else {
				data[board[i][j] - '0'] = true;
				return true;
			}
		}
		
		private boolean isValidRow(char[][] board, int i) {
			boolean[] data = new boolean[N + 1];
			for (int k = 0; k < N; k++) {
				if (!isValidCell(board, data, i, k))
					return false;
			}
			return true;
		}
		
		private boolean isValidColumn(char[][] board, int j) {
			boolean[] data = new boolean[N + 1];
			for (int k = 0; k < N; k++) {
				if (!isValidCell(board, data, k, j))
					return false;
			}
			return true;
		}

		private boolean isValidBlock(char[][] board, int i, int j) {
			boolean[] data = new boolean[N + 1];
			for (int k = 0; k < CELL_N; k++) {
				for (int l = 0; l < CELL_N; l++) {
					if (!isValidCell(board, data, i + k, j + l))
						return false;
				}
			}
			return true;
		}
	}

}
