package com.codinghero.oj.poj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Poj1753 {

	private static int SIZE = 4;
	private static int ALL_WHITE = 0;
	private static int ALL_BLACK = 65535;
	
	public static void main(String[] args) {
		
		int diagram = 0;
		int[] result = new int[65536];
		
		Scanner cin = new Scanner(System.in);
		for (int i = 0; i < SIZE; i++) {
			String line = cin.nextLine();
			for (int j = 0; j < SIZE; j++) {
				diagram += convert(line.charAt(j)) << (i * SIZE + j);
			}
		}
		
		if (diagram == ALL_WHITE || diagram == ALL_BLACK) {
			System.out.println(0);
			return;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(diagram);
		while (!q.isEmpty()) {
			int current = q.remove();
			for (int i = 0; i < SIZE * SIZE; i++) {
				int next = flipPiece(current, i);
				if (next == ALL_WHITE || next == ALL_BLACK) {
					System.out.println(result[current] + 1);
					return;
				}
				if (result[next] == 0) {
					result[next] = result[current] + 1;
					q.offer(next);
				}
			}
		}
		System.out.println("Impossible");
	}

	private static int convert(char c) {
		if (c == 'w')
			return 1;
		else if (c == 'b')
			return 0;
		else
			throw new IllegalArgumentException();
	}
	
	private static int flipPiece(int diagram, int pos) {
		diagram ^= (1 << pos);
		// up
		if (pos >= 4)
			diagram ^= (1 << (pos - 4));
		// down
		if (pos + 4 < SIZE * SIZE)
			diagram ^= (1 << (pos + 4));
		// left
		if (pos % 4 != 0)
			diagram ^= (1 << (pos - 1));
		// right
		if (pos % 4 != 3)
			diagram ^= (1 << (pos + 1));
		return diagram;
	}
}
