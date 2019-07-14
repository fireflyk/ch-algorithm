package com.codinghero.oj.leetcode;

import java.util.ArrayList;

public class SpiralMatrix {
	
	private static final int RIGHT = 0;
	private static final int DOWN = 1;
	private static final int LEFT = 2;
	private static final int UP = 3;
	
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return result;

		final int m = matrix.length;
		final int n = matrix[0].length;
		final int total = matrix.length * matrix[0].length;
		boolean[][] visited = new boolean[m][n];
		
		int toward = RIGHT;
		int i = 0, j = 0;
		result.add(matrix[i][j]);
		visited[i][j] = true;
		for (int k = 0; k < total - 1; k++) {
			if (toward == RIGHT) {
				if (++j < n && !visited[i][j]) {
					visited[i][j] = true;
					result.add(matrix[i][j]);
				} else {
					j--;
					k--;
					toward = DOWN;
				}
			} else if (toward == DOWN) {
				if (++i < m && !visited[i][j]) {
					visited[i][j] = true;
					result.add(matrix[i][j]);
				} else {
					i--;
					k--;
					toward = LEFT;
				}
			} else if (toward == LEFT) {
				if (--j >= 0 && !visited[i][j]) {
					visited[i][j] = true;
					result.add(matrix[i][j]);
				} else {
					j++;
					k--;
					toward = UP;
				}
			} else {
				if (--i >= 0 && !visited[i][j]) {
					visited[i][j] = true;
					result.add(matrix[i][j]);
				} else {
					i++;
					k--;
					toward = RIGHT;
				}
			}
		}
		return result;
	}
}
