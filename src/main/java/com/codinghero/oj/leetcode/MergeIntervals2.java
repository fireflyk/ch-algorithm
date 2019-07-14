package com.codinghero.oj.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals2 {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() == 0)
			return intervals;
		Collections.sort(intervals, new IntervalComparator());
		return doMerge(intervals);
	}

	private List<Interval> doMerge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>(intervals.size());
		Interval prev = intervals.get(0);
		result.add(prev);

		for (int ii = 1; ii < intervals.size(); ii++) {
			Interval cur = intervals.get(ii);
			// merge
			if (prev.end >= cur.start) {
				prev.end = Math.max(prev.end, cur.end);
			}
			// no merge
			else {
				result.add(cur);
				prev = cur;
			}
		}
		return result;
	}

	private class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval o1, Interval o2) {
			if (o1.start > o2.start)
				return 1;
			else if (o1.start == o2.start)
				return 0;
			else
				return -1;
		}
	}
}
