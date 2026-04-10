package com.codinghero.oj.leetcode;

import junit.framework.Assert;

import org.junit.Test;

public class SimplifyPathTest {
	@Test
	public void test() {
		SimplifyPath instace = new SimplifyPath();
		Assert.assertEquals("/home", instace.simplifyPath("/home/"));
		Assert.assertEquals("/c", instace.simplifyPath("/a/./b/../../c/"));
		Assert.assertEquals("/", instace.simplifyPath("/../"));
		Assert.assertEquals("/home/foo", instace.simplifyPath("/home//foo/"));
		Assert.assertEquals("/...", instace.simplifyPath("/..."));
		Assert.assertEquals("/..a/abc", instace.simplifyPath("/..a/abc"));
		Assert.assertEquals("/.abc", instace.simplifyPath("/.abc"));
		Assert.assertEquals("/a..b", instace.simplifyPath("/a..b"));
		Assert.assertEquals("/", instace.simplifyPath("//abc/.."));
	}
}
