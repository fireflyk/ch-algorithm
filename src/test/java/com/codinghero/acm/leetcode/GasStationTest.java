package com.codinghero.acm.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class GasStationTest {

	@Test
	public void test1() {
		GasStation gasStation = new GasStation();
		Assert.assertEquals(4, gasStation.canCompleteCircuit(new int[] { 3, 0,
				2, -2, 2 }, new int[] { 1, 1, 1, 1, 1 }));

		Assert.assertEquals(
				1,
				gasStation.canCompleteCircuit(new int[] { 0, 2 }, new int[] {
						1, 1 }));
		
		Assert.assertEquals(
				-1,
				gasStation.canCompleteCircuit(new int[] { 2, 4 }, new int[] {
						3, 4 }));
		Assert.assertEquals(
				-1,
				gasStation.canCompleteCircuit(new int[] { 2 }, new int[] {
						3 }));
	}
}
