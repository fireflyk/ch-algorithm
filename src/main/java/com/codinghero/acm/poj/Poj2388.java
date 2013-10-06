package com.codinghero.acm.poj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Poj2388 {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			list.add(cin.nextInt());
		Collections.sort(list);
		System.out.println(list.get((list.size() - 1) / 2));
	}

}
