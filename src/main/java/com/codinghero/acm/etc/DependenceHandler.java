package com.codinghero.acm.etc;

/**
 * DFS to handle dependence relation
 * 
 * @author liutong
 * 
 */
public class DependenceHandler {

	private boolean[] visited;
	
	public void execute(int[][] array) {
		visited = new boolean[array.length];
		int N = array.length;		// row
		for (int i = 0; i < N; i++) {
			doExecute(array, i);
		}
	}
	
	private void doExecute(int[][] array, int i) {
		if (visited[i])
			return;
		else {
			int N = array.length;		// row
			for (int j = 0; j < N && array[i][j] != -1; j++) {
				int item = array[i][j];
				doExecute(array, item);
			}
			visit(i);
		}
	}
	
	private void visit(int i) {
		System.out.println(i);
		visited[i] = true;
	}
	
	public static void main(String[] args) {
		int[][] array = new int[][] { 
				{ 2, 4, -1, -1, -1, -1 },
				{ 2, -1, -1, -1, -1, -1 }, 
				{ -1, -1, -1, -1, -1, -1 },
				{ 0, -1, -1, -1, -1, -1 }, 
				{ -1, -1, -1, -1, -1, -1 }, 
				{ 0, 1, 2, 3, 4, -1 } 
		};
		new DependenceHandler().execute(array);
	}

}
