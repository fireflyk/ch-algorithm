package com.codinghero.interview.google;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.Assert;

import org.junit.Test;

public class RegexStringTest {

	@Test
	public void testFindGroup1() {
		Pattern pattern = Pattern.compile("<title>(.*?)</title>");
		Matcher matcher = pattern
				.matcher("<title>abc</title>def<title>ghi</title>jkl");
		matcher.find();
		Assert.assertEquals("<title>abc</title>", matcher.group());
		matcher.find();
		Assert.assertEquals("<title>ghi</title>", matcher.group());
	}

	@Test
	public void testFindGroup2() {
		Pattern pattern = Pattern.compile("[a-z]+|[0-9]+");
		Matcher matcher = pattern.matcher("a20l1");
		matcher.find();
		Assert.assertEquals("a", matcher.group());
		matcher.find();
		Assert.assertEquals("20", matcher.group());
		matcher.find();
		Assert.assertEquals("l", matcher.group());
		matcher.find();
		Assert.assertEquals("1", matcher.group());
	}

	@Test
	public void testSplit1() {
		Pattern pattern = Pattern.compile("[a-z]+|[0-9]+");
		String[] strArr = pattern.split("a20l1");
		Assert.assertEquals(0, strArr.length);
	}

	@Test
	public void testSplit2() {
		Pattern pattern = Pattern.compile("=|&");
		String[] strArr = pattern.split("number=123-456-1111&key1=v1&key2=v2");
		Assert.assertEquals("123-456-1111", strArr[1]);
		Assert.assertEquals("v1", strArr[3]);
		Assert.assertEquals("v2", strArr[5]);

	}
}
