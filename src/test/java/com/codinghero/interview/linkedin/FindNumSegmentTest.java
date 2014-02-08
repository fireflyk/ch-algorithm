package com.codinghero.interview.linkedin;

import junit.framework.Assert;

import org.junit.Test;

import com.codinghero.interview.linkedin.FindNumSegment.Segment;

public class FindNumSegmentTest {
	
	private FindNumSegment instance = new FindNumSegment();
	
	@Test
	public void test1() {
		Assert.assertEquals(null, instance.find(new int[] {}, 10));
	}
	
	@Test
	public void test2() {
		Segment segment = instance.find(new int[] { 10 }, 10);
		Assert.assertEquals(0, segment.getStartIndex());
		Assert.assertEquals(0, segment.getEndIndex());
	}
	
	@Test
	public void test3() {
		Segment segment = instance.find(new int[] { 0, 10 }, 10);
		Assert.assertEquals(1, segment.getStartIndex());
		Assert.assertEquals(1, segment.getEndIndex());
	}
	
	@Test
	public void test4() {
		Segment segment = instance.find(new int[] { 10, 20 }, 10);
		Assert.assertEquals(0, segment.getStartIndex());
		Assert.assertEquals(0, segment.getEndIndex());
	}
	
	@Test
	public void test5() {
		Segment segment = instance.find(new int[] { 0, 10, 20 }, 10);
		Assert.assertEquals(1, segment.getStartIndex());
		Assert.assertEquals(1, segment.getEndIndex());
	}
	
	@Test
	public void test6() {
		Segment segment = instance.find(new int[] { 0, 0, 10, 10, 10, 20, 30 }, 10);
		Assert.assertEquals(2, segment.getStartIndex());
		Assert.assertEquals(4, segment.getEndIndex());
	}
}
