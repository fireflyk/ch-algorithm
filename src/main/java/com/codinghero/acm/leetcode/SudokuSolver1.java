package com.codinghero.acm.leetcode;

public class SudokuSolver1 {
	private static final int N = 9;

	public void solveSudoku(char[][] board) {
		innerSolveSudoku(board);
	}
	
	private boolean innerSolveSudoku(char[][] board) {
		
		ValidSudoku validator = new ValidSudoku();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == '.') {
					for (int k = 1; k <= N; k++) {
						board[i][j] = (char) (k + '0');
						if (validator.isValidSudoku(board) && innerSolveSudoku(board))
							return true;
						board[i][j] = '.';
					}
					return false;
				}
			}
		}
		return true;
	}
	
	private class ValidSudoku {
		
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
