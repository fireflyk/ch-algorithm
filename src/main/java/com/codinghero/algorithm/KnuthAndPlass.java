package com.codinghero.algorithm;

import java.util.LinkedList;

public class KnuthAndPlass {
	
//	private static int NULL_DATA = -1;
//
//	private String[] words;
//
//	private int lineWidth;
//	private int oneSpaceWidth;
//
//	private int[][] c;
//	private int[] f;
//
//	private int[] cIndex;
//
//	public KnuthAndPlass(String[] words, int lineWidth) {
//		this(words, lineWidth, 1);
//	}
//
//	public KnuthAndPlass(String[] words, int lineWidth, int oneSpaceWidth) {
//		this.words = words;
//		this.lineWidth = lineWidth;
//		this.oneSpaceWidth = oneSpaceWidth;
//
//		this.c = new int[words.length][words.length];
//		this.f = new int[words.length];
//		this.cIndex = new int[words.length];
//
//		for (int i = 0; i < words.length; i++) {
//			f[i] = NULL_DATA;
//			cIndex[i] = NULL_DATA;
//			for (int j = 0; j < words.length; j++)
//				c[i][j] = NULL_DATA;
//		}
//	}
//
//	public void print() {
//		int[] result = cal();
//		int i = 0;
//		for (; i < result.length - 1; i++)
//			System.out.println(StringUtils.join(ArrayUtils.toList(words), " ",
//					result[i], result[i + 1] - 1));
//		System.out.print(StringUtils.join(ArrayUtils.toList(words), " ",
//				result[i], words.length - 1));
//	}
//
//	public int[] cal() {
//		if (f[0] == NULL_DATA)
//			f[words.length - 1] = f(words.length - 1);
//
//		LinkedList<Integer> result = new LinkedList<Integer>();
//		int i = words.length - 1;
//		while (true) {
//			if (cIndex[i] != NULL_DATA)
//				result.addFirst(cIndex[i]);
//			else {
//				result.addFirst(0);
//				break;
//			}
//			i = cIndex[i] - 1;
//		}
//		return ArrayUtils.toArray(result);
//	}
//
//	private int f(int j) {
//		c[0][j] = c(0, j);
//		if (c[0][j] < Integer.MAX_VALUE)
//			return c[0][j];
//		else {
//			int min = Integer.MAX_VALUE;
//			int debugK = 0, debugJ = 0;
//			for (int k = 0; k < j; k++) {
//				// if f[k-1] is not calculated, then calculate it
//				if (f[k] == NULL_DATA)
//					f[k] = f(k);
//				// if c[k][j-1] is not calculated, then calculate it
//				if (c[k + 1][j] == NULL_DATA)
//					c[k + 1][j] = c(k + 1, j);
//				// if find the more minium value, assign it
//				// f[k - 1] + c[k][j - 1] maybe overflow
//				if (c[k + 1][j] != Integer.MAX_VALUE
//						&& f[k] + c[k + 1][j] < min) {
//					min = f[k] + c[k + 1][j];
//					cIndex[j] = k + 1;
//
//					debugK = k;		// debug
//					debugJ = j;		// debug
//				}
//			}
//
//			System.out.println("f(" + j + ")=" + "f(" + debugK + ") + c("
//					+ (debugK + 1) + "," + debugJ + ")");	//debug
//			return min;
//		}
//	}
//
//	private int c(int i, int j) {
//		int sigmaIj = 0;
//		for (int index = i; index <= j; index++) {
//			sigmaIj += words[index].length();
//		}
//		int result = lineWidth - (j - i) * oneSpaceWidth - sigmaIj;
//		if (result >= 0)
//			return result * result;
//		else
//			return Integer.MAX_VALUE;
//	}
}
