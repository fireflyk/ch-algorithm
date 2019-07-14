package com.codinghero.oj.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Poj3349 {

	private static int SNOW_FLAKE_ARMS = 6;
	private static int MAP_SIZE = 10000;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(cin.readLine());
		int[][] snowFlake = new int[n][SNOW_FLAKE_ARMS];
		Map<Integer, List<Integer>> sumMap = new HashMap<Integer, List<Integer>>(MAP_SIZE);
		
		for (int i = 0; i < n; i++) {
			// read data
			String[] nums = cin.readLine().split(" ");
			for (int j = 0; j < SNOW_FLAKE_ARMS; j++) {
				snowFlake[i][j] = Integer.parseInt(nums[j]);
			}
			
			// put data
			int key = sum(snowFlake, i) % MAP_SIZE;
			if (!sumMap.containsKey(key)) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				sumMap.put(key, list);
			} else {
				List<Integer> list = sumMap.get(key);
				list.add(i);
			}
		}

		// check data
		check(sumMap, snowFlake);
	}

	private static int sum(int[][] arr, int index) {
		int sum = 0;
		for (int i = 0; i < SNOW_FLAKE_ARMS; i++)
			sum += arr[index][i];
		return sum;
	}

	private static void check(Map<Integer, List<Integer>> sumMap, int[][] snowFlake) {
		Iterator<Entry<Integer, List<Integer>>> iter = sumMap.entrySet().iterator();
		while(iter.hasNext()) {
			Entry<Integer, List<Integer>> e = iter.next();
			List<Integer> sameSumList = e.getValue();
			if (sameSumList != null && sameSumList.size() >= 2) {
				for (int i = 0; i < sameSumList.size(); i++) {
					for (int j = i + 1; j < sameSumList.size(); j++) {
						if (checkOne(snowFlake, sameSumList.get(i), sameSumList.get(j))) {
							System.out.println("Twin snowflakes found.");
							return;
						}
					}
				}
			}
		}
		System.out.println("No two snowflakes are alike.");
	}

	private static boolean checkOne(int[][] snowFlake, int i1, int i2) {
		
		for (int i = 0; i < SNOW_FLAKE_ARMS; i++) {
			boolean flag = true;
			for (int step = 0; step < SNOW_FLAKE_ARMS; step++) {
				if (snowFlake[i1][step] != snowFlake[i2][(i + step) % SNOW_FLAKE_ARMS]) {
					flag = false;
					break;
				}
			}
			if (flag)
				return true;
		}
		
		
		for (int i = 0; i < SNOW_FLAKE_ARMS; i++) {
			boolean flag = true;
			for (int step = 0; step < SNOW_FLAKE_ARMS; step++) {
				if (snowFlake[i1][step] != snowFlake[i2][(i + SNOW_FLAKE_ARMS - step) % SNOW_FLAKE_ARMS]) {
					flag = false;
					break;
				}
			}
			if (flag)
				return true;
		}
		
		return false;
	}
}
