package com.codinghero.acm.leetcode;

public class JavaNumberUtils {
	public boolean isNumber(String s) {
		if (s == null || s.length() == 0)
			return false;
		s = s.trim();
		if (s.equals("."))
			return false;
		int state = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (state == 0) {
				if (c == '-') {
					state = 1;
				} else if (c >= '0' && c <= '9') {
					state = 2;
				} else if (c == '.') {
					state = 6;
				} else {
					return false;
				}
			} else if (state == 1) {
				if (c >= '0' && c <= '9') {
					state = 4;
				} else if (c == '.') {
					state = 6;
				} else {
					return false;
				}
			} else if (state == 2) {
				if (c >= '0' && c <= '9') {

				} else if (c == '.') {
					state = 6;
				} else {
					return false;
				}
			} else if (state == 4) {
				if (c >= '0' && c <= '9') {

				} else if (c == '.') {
					state = 6;
				} else {
					return false;
				}
			} else if (state == 6) {
				if (c >= '0' && c <= '9') {
					
				} else {
					return false;
				}
			}
		}
		if (state == 2 || state == 4 || state == 6)
			return true;
		else
			return false;
	}
	
	public boolean isPositiveInteger(String str, int start, int end) {
		
	}
	
	public boolean isPositiveNumber(String str, int start, int end) {
		
	}
	
	public boolean isSimpleNumber(String str) {
		
	}
}
