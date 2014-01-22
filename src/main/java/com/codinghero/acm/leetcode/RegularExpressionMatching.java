package com.codinghero.acm.leetcode;


public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		if (s == null || p == null)
			return false;
		else if (s.length() == 0) {
			if (p.length() == 0) {
				return true;
			} else {
				return false;
			}
		}
		
		Boolean[][] memo = new Boolean[s.length()][p.length()];
		return isMatch(s, p, 0, 0, memo);
	}

	private boolean isMatch(String s, String p, int indexS, int indexP, Boolean[][] memo) {
		if (indexS == s.length()) {
			if (indexP == p.length()) {
				return this.put(memo, indexS, indexP, true);
			} else {
				for (int i = indexP; i < p.length(); i++) {
					i++;
					if (i >= p.length() || p.charAt(i) != '*') {
						return this.put(memo, indexS, indexP, false);
					}
				}
				return this.put(memo, indexS, indexP, true);
			}
		} else if (indexP == p.length()) {
			return this.put(memo, indexS, indexP, false);
		}
		
		// *
		if (indexP + 1 < p.length() && p.charAt(indexP + 1) == '*') {
			if (s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '.') {
				return this.get(memo, s, p, indexS + 1, indexP + 2)
						|| this.get(memo, s, p, indexS, indexP + 2)
						|| this.get(memo, s, p, indexS + 1, indexP);
			} else {
				return this.get(memo, s, p, indexS, indexP + 2);
			}
		}
		// == or .
		if (s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '.') {
			return this.get(memo, s, p, indexS + 1, indexP + 1);
		}
		// !=
		else {
			return this.put(memo, indexS, indexP, false);
		}
	}
	
	private boolean put(Boolean[][] memo, int indexS, int indexP, boolean result) {
		memo[indexS][indexP] = result;
		return result;
	}

	private boolean get(Boolean[][] memo, String s, String p, int indexS, int indexP) {
		Boolean result = memo[indexS][indexP];
		if (result == null) {
//			System.out.println("start calculate: "+indexS + "," + indexP);
			return this.isMatch(s, p, indexS, indexP, memo);
//			System.out.println("end calculate: "+indexS + "," + indexP);
//			System.out.println("result: " + memo.get(new Index(indexS, indexP)));
		} else {
			return result;
		}
	}
	
	private class Index {
		private int indexS;
		private int indexP;
		
		private Index(int indexS, int indexP) {
			this.indexS = indexS;
			this.indexP = indexP;
		}

		public int hashCode() {
			return this.indexS * 10 + indexP;
		}
		
		public boolean equals(Object o) {
			if (!(o instanceof Index))
				return false;
			Index index = (Index) o;
			boolean result = this.indexS == index.indexS && this.indexP == index.indexP;
			System.out.println(result + ":" + indexS + "," + indexP + ";"
					+ index.indexS + "," + index.indexP);
			return result;
		}
	}
	
//	private boolean isMatch(char s, char p, int state) {
//		
//	}
}
