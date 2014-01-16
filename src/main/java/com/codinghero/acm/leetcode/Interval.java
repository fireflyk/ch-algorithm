package com.codinghero.acm.leetcode;

public class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

	public boolean equals(Object o) {
		if (!(o instanceof Interval) || o == null) {
			return false;
		}
		Interval interval = (Interval) o;
		if (this.start == interval.start && this.end == interval.end) {
			return true;
		} else {
			return false;
		}
	}
}
