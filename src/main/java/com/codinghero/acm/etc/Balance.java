package com.codinghero.acm.etc;

import java.util.Scanner;

/**
 * 
 * DFS problem
 * 
 * @author Tong Liu
 *
 */
public class Balance {
	
	private static boolean FINISHED = true;
	private static boolean NOT_FINISHED = false;
	private static int NULL_DATA = -1;
	private static int BALANCE_WEIGHT = 10;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		final int N = s.nextInt();
		s.nextLine();	// skip the tail of 1st line
		
		// balance index of each side
		int[][] leftBalances = new int[N][N];
		int[][] rightBalances = new int[N][N];
		// total weight of each side
		int[] leftWeight = new int[N];
		int[] rightWeight = new int[N];
		// the supplement of each side
		int[] leftSupply = new int[N];
		int[] rightSupply = new int[N];
		// is finished calculating
		boolean[] leftFinished = new boolean[N];
		boolean[] rightFinished = new boolean[N];
		
		// init
		init(leftBalances);
		init(rightBalances);
		
		// handle input
		for (int i = 0; i < N; i++) {
			// left
			String leftStr = s.nextLine();
			handleInput(leftStr, i, leftBalances, leftWeight);
			// right
			String rightStr = s.nextLine();
			handleInput(rightStr, i, rightBalances, rightWeight);
		}
		
		calculateAll(leftBalances, rightBalances, leftWeight, rightWeight, leftSupply, rightSupply, leftFinished, rightFinished);
		
		// output
		handleOutput(leftSupply, rightSupply);
	}

	/**
	 * fill array with default value
	 * 
	 * @param balances
	 */
	private static void init(int[][] balances) {
		for (int j = 0; j < balances.length; j++) {
			for (int k = 0; k < balances.length; k++) {
				balances[j][k] = NULL_DATA;
			}
		}
	}
	
	/**
	 * read balances data & weight data
	 * 
	 * @param str
	 * @param index
	 * @param balances
	 * @param weight
	 */
	private static void handleInput(String str, int index, int[][] balances, int[] weight) {
		String[] strArr = str.split(" ");
		weight[index] = Integer.parseInt(strArr[0]);
		for (int j = 1; j < strArr.length; j++) {
			balances[index][j - 1] = Integer.parseInt(strArr[j]);
		}
	}
	
	/**
	 * DFS calculate
	 * 
	 * @param index
	 * @param leftBalances
	 * @param rightBalances
	 * @param leftWeight
	 * @param rightWeight
	 * @param leftSupply
	 * @param rightSupply
	 * @param leftFinished
	 * @param rightFinished
	 */
	private static void calculateAll(
			int[][] leftBalances, int[][] rightBalances, 
			int[] leftWeight, int[] rightWeight, 
			int[] leftSupply, int[] rightSupply,
			boolean[] leftFinished, boolean[] rightFinished) {
		for (int i = 0; i < leftBalances.length; i++) {
			calculate(i, leftBalances, rightBalances, leftWeight, rightWeight, leftSupply, rightSupply, leftFinished, rightFinished);
		}
	}

	/**
	 * DFS calculate
	 * 
	 * @param index
	 * @param leftBalances
	 * @param rightBalances
	 * @param leftWeight
	 * @param rightWeight
	 * @param leftSupply
	 * @param rightSupply
	 * @param leftFinished
	 * @param rightFinished
	 */
	private static void calculate(
			int index, 
			int[][] leftBalances, int[][] rightBalances, 
			int[] leftWeight, int[] rightWeight, 
			int[] leftSupply, int[] rightSupply,
			boolean[] leftFinished, boolean[] rightFinished) {
		if (leftFinished[index] == NOT_FINISHED) {
			for (int j = 0; j < leftBalances[index].length; j++) {
				if (leftBalances[index][j] == NULL_DATA)
					break;
				int currentIndex = leftBalances[index][j];
				if (leftFinished[currentIndex] == NOT_FINISHED)
					calculate(currentIndex, leftBalances, rightBalances, leftWeight, rightWeight, leftSupply, rightSupply, leftFinished, rightFinished);
				if (rightFinished[currentIndex] == NOT_FINISHED)
					calculate(currentIndex, leftBalances, rightBalances, leftWeight, rightWeight, leftSupply, rightSupply, leftFinished, rightFinished);
				// balance i weight += (empty weight + l + r + l or r supply)
				leftWeight[index] += leftWeight[currentIndex];
				leftWeight[index] += rightWeight[currentIndex];
				leftWeight[index] += BALANCE_WEIGHT;
				leftWeight[index] += leftSupply[currentIndex];
				leftWeight[index] += rightSupply[currentIndex];
			}
			leftFinished[index] = FINISHED;
		}
		
		if (rightFinished[index] == NOT_FINISHED) {
			for (int j = 0; j < rightBalances[index].length; j++) {
				if (rightBalances[index][j] == NULL_DATA)
					break;
				int currentIndex = rightBalances[index][j];
				if (leftFinished[currentIndex] == NOT_FINISHED)
					calculate(currentIndex, leftBalances, rightBalances, leftWeight, rightWeight, leftSupply, rightSupply, leftFinished, rightFinished);
				if (rightFinished[currentIndex] == NOT_FINISHED)
					calculate(currentIndex, leftBalances, rightBalances, leftWeight, rightWeight, leftSupply, rightSupply, leftFinished, rightFinished);
				rightWeight[index] += leftWeight[currentIndex];
				rightWeight[index] += rightWeight[currentIndex];
				rightWeight[index] += BALANCE_WEIGHT;
				rightWeight[index] += leftSupply[currentIndex];
				rightWeight[index] += rightSupply[currentIndex];
			}
			rightFinished[index] = FINISHED;
		}
		
		if (leftWeight[index] > rightWeight[index])
			rightSupply[index] = leftWeight[index] - rightWeight[index];
		else
			leftSupply[index] = rightWeight[index] - leftWeight[index];
		
	}
	
	/**
	 * 
	 * @param leftSupply
	 * @param rightSupply
	 */
	private static void handleOutput(int[] leftSupply, int[] rightSupply) {
		for (int j = 0; j < leftSupply.length; j++) {
			System.out.println(j + ": " + leftSupply[j] + " " + rightSupply[j]);
		}
	}
}
