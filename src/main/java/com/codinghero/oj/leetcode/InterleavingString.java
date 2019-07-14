package com.codinghero.oj.leetcode;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null || s2 == null || s3 == null)
			return false;
		else if (s1.length() + s2.length() != s3.length())
			return false;
		char[] cArr1 = s1.toCharArray();
		char[] cArr2 = s2.toCharArray();
		char[] cArr3 = s3.toCharArray();
		return isInterleave(cArr1, 0, cArr2, 0, cArr3, 0,
				new boolean[cArr1.length + 1][cArr2.length + 1]);
	}
	
	private boolean isInterleave(char[] cArr1, final int index1, char[] cArr2,
			final int index2, char[] cArr3, final int index3, boolean[][] visited) {
		if (index1 == cArr1.length && index2 == cArr2.length && index3 == cArr3.length)
			return true;
		else if (visited[index1][index2])
			return false;
		visited[index1][index2] = true;
		
		int curIndex1 = index1, curIndex2 = index2, curIndex3 = index3;
		while (curIndex1 < cArr1.length && cArr1[curIndex1] == cArr1[index1]
				&& cArr1[curIndex1] == cArr3[curIndex3]) {
			visited[curIndex1][curIndex2] = true;
			curIndex1++;
			curIndex3++;
		}
		if (index1 < curIndex1
				&& this.isInterleave(cArr1, curIndex1, cArr2, curIndex2, cArr3, curIndex3, visited))
			return true;
		
		curIndex1 = index1;
		curIndex2 = index2;
		curIndex3 = index3;
		
		while (curIndex2 < cArr2.length && cArr2[curIndex2] == cArr2[index2]
				&& cArr2[curIndex2] == cArr3[curIndex3]) {
			visited[curIndex1][curIndex2] = true;
			curIndex2++;
			curIndex3++;
		}
		if (index2 < curIndex2
				&& this.isInterleave(cArr1, curIndex1, cArr2, curIndex2, cArr3, curIndex3, visited))
			return true;
		
		return false;
	}
}
