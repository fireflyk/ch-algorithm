package com.codinghero.acm.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class SurroundedRegions {
	
	private static int RIGHT = 0;
	private static int DOWN = 1;
	private static int LEFT = 2;
	private static int UP = 3;
	private static int END = 4;
	
	public void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0)
			return;
		boolean[][] visited = new boolean[board.length][board[0].length];
		final int maxX = board.length;
		final int maxY = board[0].length;
		
		Queue<Axis> queue = init(board);
		while (!queue.isEmpty()) {
			Axis axis = queue.poll();
			if (isValid(axis.x, axis.y, maxX, maxY) 
					&& !visited[axis.x][axis.y]
					&& board[axis.x][axis.y] == 'O') {
				visited[axis.x][axis.y] = true;
				queue.add(new Axis(axis.x - 1, axis.y));
				queue.add(new Axis(axis.x + 1, axis.y));
				queue.add(new Axis(axis.x, axis.y - 1));
				queue.add(new Axis(axis.x, axis.y + 1));
			}
		}
		
		for (int i = 0; i < maxX; i++) {
			for (int j = 0; j < maxY; j++) {
				if (!visited[i][j] && board[i][j] == 'O')
					board[i][j] = 'X';
			}
		}
	}

	Queue<Axis> init(char[][] board) {
		final int maxX = board.length;
		final int maxY = board[0].length;
		boolean[][] visited = new boolean[maxX][maxY];
		Queue<Axis> queue = new ArrayDeque<Axis>();
		
		for (int i = 0, j = 0, toward = RIGHT; toward < END;) {
			if (board[i][j] == 'O')
				queue.add(new Axis(i, j));
			visited[i][j] = true;
			if (toward == RIGHT) {
				if (j < maxY - 1)
					j++;
				else {
					toward = DOWN;
				}
			}
			if (toward == DOWN) {
				if (i < maxX - 1)
					i++;
				else {
					toward = LEFT;
				}
			}
			if (toward == LEFT) {
				if (j > 0)
					j--;
				else {
					toward = UP;
				}
			}
			if (toward == UP) {
				if (i > 0)
					i--;
				else {
					toward = END;
				}
			}
		}
		return queue;
	}
	
	private boolean isValid(int x, int y, int maxX, int maxY) {
		if (x >= 0 && x < maxX && y >= 0 && y < maxY)
			return true;
		else
			return false;
	}

	private class Axis {
		private int x;
		private int y;

		Axis(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
