package com.codinghero.acm.leetcode;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class MergeIntervalsTest {

	private MergeIntervals2 instance = new MergeIntervals2();

	@Test
	public void test1() {
		Interval i1 = new Interval(1, 3);
		Interval i2 = new Interval(3, 6);
		Interval i3 = new Interval(4, 5);
		Interval i4 = new Interval(11, 18);
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(i1);
		intervals.add(i2);
		intervals.add(i3);
		intervals.add(i4);
		
		List<Interval> result = instance.merge(intervals);
		Assert.assertEquals(1, result.get(0).start);
		Assert.assertEquals(6, result.get(0).end);
		Assert.assertEquals(11, result.get(1).start);
		Assert.assertEquals(18, result.get(1).end);
	}

	@Test
	public void test2() {
		Interval i1 = new Interval(1, 6);
		Interval i2 = new Interval(2, 4);
		Interval i4 = new Interval(11, 18);
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(i1);
		intervals.add(i2);
		intervals.add(i4);
		
		List<Interval> result = instance.merge(intervals);
		Assert.assertEquals(1, result.get(0).start);
		Assert.assertEquals(6, result.get(0).end);
		Assert.assertEquals(11, result.get(1).start);
		Assert.assertEquals(18, result.get(1).end);
	}

	@Test
	public void test3() {
		Assert.assertEquals(null, instance.merge(null));
		Assert.assertEquals(new ArrayList<Interval>(), instance.merge(new ArrayList<Interval>()));

		Interval i1 = new Interval(1, 3);
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(i1);
		Assert.assertEquals(intervals, instance.merge(intervals));
	}
}
