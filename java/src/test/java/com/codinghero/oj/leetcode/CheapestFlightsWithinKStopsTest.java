package com.codinghero.oj.leetcode;

import com.codinghero.algorithm.CheapestFlightsWithinKStops;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheapestFlightsWithinKStopsTest {

    private CheapestFlightsWithinKStops instance4Test = new CheapestFlightsWithinKStops();

    @Test
    public void test() {
        assertEquals(200, instance4Test.findCheapestPrice(
                3,
                new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}},
                0, 2, 1));
    }
}
