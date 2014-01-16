package com.codinghero.acm.poj;

import java.util.Scanner;

public class Poj3295 {

	private static int index;
	private static boolean pqrst[] =  new boolean[5];
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			String line = cin.nextLine();
			if (line.equals("0"))
				break;
			
			execute(line);
		}
	}
	
	private static void execute(String str) {
		for (int p = 0; p <= 1; p++) {
			pqrst[0] = (p == 0);
			for (int q = 0; q <= 1; q++) {
				pqrst[1] = (q == 0);
				for (int r = 0; r <= 1; r++) {
					pqrst[2] = (r == 0);
					for (int s = 0; s <= 1; s++) {
						pqrst[3] = (s == 0);
						for (int t = 0; t <= 1; t++) {
							pqrst[4] = (t == 0);
							index = 0;
							if (!cal(str)) {
								System.out.println("not");
								return;
							}
						}
					}
				}
			}
		}
		System.out.println("tautology");
	}
	
	private static boolean cal(String str) {
		char c = str.charAt(index++);
		if (c == 'K') {
			boolean w = cal(str);
			boolean x = cal(str);
			return w && x;
		} else if (c == 'A'){
			boolean w = cal(str);
			boolean x = cal(str);
			return w || x;
		} else if (c == 'N') {
			boolean w = cal(str);
			return !w;
		} else if (c == 'C'){
			boolean w = cal(str);
			boolean x = cal(str);
			return !w || x;
		} else if (c == 'E'){
			boolean w = cal(str);
			boolean x = cal(str);
			return w == x;
		} else {
			return pqrst[c - 'p'];
		}
	}
}
