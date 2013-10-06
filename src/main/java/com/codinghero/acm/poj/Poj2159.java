package com.codinghero.acm.poj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Poj2159 {

	public static void main(String[] args) {
		
		Scanner cin = new Scanner(System.in);
		String str1 = cin.next(), str2 = cin.next();
		int ENG_LETTER_NUMBERS = 26;
		ArrayList<Integer> list1 = new ArrayList<Integer>(ENG_LETTER_NUMBERS);
		ArrayList<Integer> list2 = new ArrayList<Integer>(ENG_LETTER_NUMBERS);

		for (int i = 0; i < ENG_LETTER_NUMBERS; i++) {
			list1.add(0);
			list2.add(0);
		}

		for (int i = 0; i < str1.length(); i++) {
			int number = list1.get(str1.charAt(i) - 'A');
			number++;
			list1.set(str1.charAt(i) - 'A', number);

			number = list2.get(str2.charAt(i) - 'A');
			number++;
			list2.set(str2.charAt(i) - 'A', number);
		}

		Collections.sort(list1);
		Collections.sort(list2);

		for (int i = 0; i < ENG_LETTER_NUMBERS; i++) {
			if (!list1.get(i).equals(list2.get(i))) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

}
