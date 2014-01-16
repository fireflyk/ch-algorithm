package com.codinghero.acm.poj;

import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Poj1328 {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int round = 1;
		while (true) {
			int n = cin.nextInt(), d = cin.nextInt();
			if (n == 0)
				return;
			ArrayList<Node> islands = new ArrayList<Node>(n);
			for (int i = 0; i < n; i++) {
				Node island = new Node();
				island.x = cin.nextInt();
				island.y = cin.nextInt();
				islands.add(island);
			}
			System.out.println("Case " + round + ": " + cal(islands, n, d));
			round++;
		}
	}
	
	private static int cal(ArrayList<Node> islands, int n, int d) {
		if (d == 0)
			return -1;
		ArrayList<XRange> list = new ArrayList<XRange>(n);
		for (int i = 0; i < n; i++) {
			Node island = islands.get(i);
			if (island.y < 0 || island.y > d)
				return -1;
			
			double base = Math.sqrt(d * d - island.y * island.y);
			
			XRange r = new XRange();
			r.leftX = island.x - base;
			r.rightX = island.x + base;
			list.add(r);
		}
		Collections.sort(list);
		
		int radarNum = 1;
		double curRight = list.get(0).rightX;
		
		for (int i = 1; i < n; i++) {
			if (curRight < list.get(i).leftX) {
				radarNum++;
				curRight = list.get(i).rightX;
			}
		}
		return radarNum;
	}

	private static class Node implements Comparable<Node> {

		private int x;
		private int y;

		public int compareTo(Node o) {
			return this.x - o.x;
		}
	}
	
	private static class XRange implements Comparable<XRange> {

		private double leftX;
		private double rightX;
		
		public int compareTo(XRange o) {
			if (this.rightX > o.rightX)
				return 1;
			else if (this.rightX == o.rightX)
				return 0;
			else
				return -1;
		}
		
	}
}
