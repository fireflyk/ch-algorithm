package com.codinghero.acm.leetcode;

public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		if (s == null || p == null)
			return false;
//		else if (s.length() == 0) {
//			if (p.length() == 0) {
//				return true;
//			} else {
//				return false;
//			}
//		}

		Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
		return isMatch(s, p, 0, 0, memo);
	}

	private boolean isMatch(String s, String p, int indexS, int indexP, Boolean[][] memo) {
		if (indexS == s.length()) {
			if (indexP == p.length()) {
				return this.put(indexS, indexP, true, memo);
			} else {
				for (int i = indexP; i < p.length(); i++) {
					i++;
					if (i >= p.length() || p.charAt(i) != '*') {
						return this.put(indexS, indexP, false, memo);
					}
				}
				return this.put(indexS, indexP, true, memo);
			}
		} else if (indexP == p.length()) {
			return this.put(indexS, indexP, false, memo);
		}

		// *
		if (indexP + 1 < p.length() && p.charAt(indexP + 1) == '*') {
			if (s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '.') {
				boolean result = this.get(s, p, indexS + 1, indexP + 2, memo)
						|| this.get(s, p, indexS, indexP + 2, memo)
						|| this.get(s, p, indexS + 1, indexP, memo);
				return this.put(indexS, indexP, result, memo);
			} else {
				boolean result = this.get(s, p, indexS, indexP + 2, memo);
				return this.put(indexS, indexP, result, memo);
			}
		}
		// == or .
		if (s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '.') {
			return this.get(s, p, indexS + 1, indexP + 1, memo);
		}
		// !=
		else {
			return this.put(indexS, indexP, false, memo);
		}
	}

	private boolean put(int indexS, int indexP, boolean result, Boolean[][] memo) {
		memo[indexS][indexP] = result;
		return result;
	}

	private boolean get(String s, String p, int indexS, int indexP, Boolean[][] memo) {
		Boolean result = memo[indexS][indexP];
		if (result == null) {
			result = this.isMatch(s, p, indexS, indexP, memo);
			return result;
		} else {
			return result;
		}
	}
}
