package com.codinghero.oj.leetcode;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class SubsetTest {

    @Test
    public void testSubsets1() {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 10, 0 };
        List<List<Integer>> result = new Subset3().subsets(arr);
        Assert.assertEquals(1024, result.size());
    }

    @Test
    public void testSubsets2() {
        int[] arr = { 1, 2, 2, 3 };
        List<List<Integer>> result = new Subset().subsets(arr);
        Assert.assertEquals(12, result.size());
    }
}
