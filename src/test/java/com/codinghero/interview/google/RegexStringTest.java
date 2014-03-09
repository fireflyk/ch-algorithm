package com.codinghero.interview.google;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegexStringTest {

	@Test
	public void test1() {
		Pattern pattern = Pattern.compile("<title>(.*?)</title>");
		Matcher matcher = pattern
				.matcher("<title>abc</title>def<title>ghi</title>jkl");
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

	@Test
	public void test2() {
		Pattern pattern = Pattern.compile("[a-z]+|[0-9]+");
		Matcher matcher = pattern.matcher("a20l1");
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

	@Test
	public void test3() {
		Pattern pattern = Pattern.compile("[a-z]+|[0-9]+");
		String[] strArr = pattern.split("a20l1");
		for (String str : strArr) {
			System.out.println(str);
		}
	}

	@Test
	public void test4() {
		Pattern pattern = Pattern.compile("=|&");
		String[] strArr = pattern.split("number=123-456-1111&key1=v1&key2=v2");
		for (String str : strArr) {
			System.out.println(str);
		}
	}
}
