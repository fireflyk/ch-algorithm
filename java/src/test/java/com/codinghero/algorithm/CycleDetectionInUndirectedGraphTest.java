package com.codinghero.algorithm;

import org.junit.Assert;
import org.junit.Test;

public class CycleDetectionInUndirectedGraphTest {

    private CycleDetectionInUndirectedGraph instance = new CycleDetectionInUndirectedGraph();

    @Test
    public void test() {
        Assert.assertFalse(instance.validTree(4, new int[][] { { 0, 1 }, { 2, 3 } }));
    }
}
