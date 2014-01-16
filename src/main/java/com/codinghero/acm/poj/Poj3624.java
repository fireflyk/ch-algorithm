package com.codinghero.acm.poj;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Poj3624 {
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(new BufferedInputStream(System.in));
		int N = cin.nextInt();
		int W_SUM = cin.nextInt();
		// weight
		int[] w = new int[N];
		// value
		int[] v = new int[N];
		for (int i = 0; i < N; i++) {
			w[i] = cin.nextInt();
			v[i] = cin.nextInt();
		}
		int[] result = new int[W_SUM + 1];
		Knapsack k = new Knapsack();
		System.out.println(k.cal(N, W_SUM, w, v, result));
	}
	
	private static class Knapsack {
		
		public int cal(int n, int wSum, int[] w, int[] v, int[] result) {
			// if data is not calculated, then calculate it now
			// oppositely get data from memo
			for (int i = 0; i < n; i++) {
				for (int j = wSum; j >= w[i]; j--) {
					result[j] = Math.max(result[j - w[i]] + v[i], result[j]);
				}
			}
			return result[wSum];
		}
	}
}
