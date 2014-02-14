package com.codinghero.acm.leetcode;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		StringBuilder sb = new StringBuilder();
		if (strs == null || strs.length == 0)
			return sb.toString();
		
		// try to find next by next
		for (int i = 0;; i++) {
			Character cur = null;
			int j = 0;
			for (; j < strs.length; j++) {
				// met the shortest string
				if (strs[j] == null || i == strs[j].length()) {
					break;
				}
				// the first string of this round
				else if (cur == null) {
					cur = strs[j].charAt(i);
				}
				// match
				else if (strs[j].charAt(i) == cur) {
					continue;
				}
				// not match
				else {
					break;
				}
			}
			// get correct character
			if (j == strs.length) {
				sb.append(cur);
			}
			// not match
			else {
				break;
			}
		}
		return sb.toString();
	}
}
