package com.codinghero.algorithm;

public class KMP {

	public int contains(String mainStr, String patternStr) {
		int[] next = getKmpNext(patternStr);
		int mi = 0, pi = 0;
		while (true) {
			char mc = mainStr.charAt(mi);
			char pc = patternStr.charAt(pi);
			if (mc == pc) {
				++pi;
				++mi;
				// it is equal at the end, so match
				if (pi == patternStr.length())
					return mi - pi;
				// it is not finished matching at the end, so not match
				else if (mi == mainStr.length())
					break;
				else
					continue;
			} else {
				pi = next[pi];
				if (pi == -1) {
					++pi;
					++mi;
				}
			}
		}

		return -1;
	}

	private int[] getKmpNext(String str) {
		int[] next = new int[str.length()];
		next[0] = -1;
		int i = 0, j = -1;
		while (i < str.length() - 1) {
			if (j == -1 || str.charAt(i) == str.charAt(j)) {
				++i;
				++j;
				next[i] = j;
			} else {
				j = next[j];
			}
		}
		return next;
	}

}
