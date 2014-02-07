package com.codinghero.acm.leetcode;

public class ImplementStrStr {
	
	private final static int HEAD_INDEX = -1;
	
	public String strStr(String haystack, String needle) {
		if (needle.equals("")) {
			if (haystack.equals(""))
				return "";
			else
				return haystack;
		}
		
		int[] next = getKMPNext(needle);
		int i = 0, j = 0;
		while (true) {
			if (j == HEAD_INDEX) {
				i++;
				j++;
			} else if (j == needle.length())
				break;
			if (i == haystack.length())
				break;
			
			if (haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		if (i < haystack.length())
			return haystack.substring(i - needle.length());
		else if (j == needle.length())
			return haystack.substring(i - needle.length());
		else
			return null;
	}
	
	private int[] getKMPNext(String needle) {
		int[] next = new int[needle.length()];
		next[0] = HEAD_INDEX;
		int prefixIndex = HEAD_INDEX;
		for (int postfixIndex = 0; postfixIndex < needle.length() - 1; ) {
			if (prefixIndex == HEAD_INDEX
					|| needle.charAt(prefixIndex) == needle.charAt(postfixIndex)) {
				prefixIndex++;
				postfixIndex++;
				if (needle.charAt(prefixIndex) != needle.charAt(postfixIndex))
					next[postfixIndex] = prefixIndex;
				else
					next[postfixIndex] = next[prefixIndex];
			} else {
				// this next line code is the core of the algorithm
				// if we write prefixIndex--, that will cost lots of times
				prefixIndex = next[prefixIndex];
			}
		}
		return next;
	}
}
