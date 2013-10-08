package com.codinghero.algorithm;

public class NumberUtils {
	public boolean isNumber(String s) {
		if (s == null || s.length() == 0)
			return false;
		s = s.trim();
		int state = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (state == 0) {
				if (c == '-') {
					state = 1;
				} else if (c == '0') {
					state = 2;
				} else if (c >= '1' && c <= '9') {
					state = 3;
				} else if (c == '.') {
					state = 6;
				} else {
					return false;
				}
			} else if (state == 1) {
				if (c == '0') {
					state = 4;
				} else if (c >= '1' && c <= '9') {
					state = 5;
				} else if (c == '.') {
					state = 6;
				} else {
					return false;
				}
			} else if (state == 2) {
				if (c == '.') {
					state = 6;
				} else {
					return false;
				}
			} else if (state == 3) {
				if (c >= '0' && c <= '9') {

				} else if (c == '.') {
					state = 6;
				} else {
					return false;
				}
			} else if (state == 4) {
				if (c == '.') {
					state = 6;
				} else {
					return false;
				}
			} else if (state == 5) {
				if (c == '.') {
					state = 6;
				} else {
					return false;
				}
			} else if (state == 6) {
				if (c >= '0' && c <= '9') {
					state = 7;
				} else {
					return false;
				}
			} else if (state == 7) {
				if (c >= '0' && c <= '9') {
					
				} else {
					return false;
				}
			}
		}
		if (state == 2 || state == 3 || state == 5 || state == 7)
			return true;
		else
			return false;
	}
}
