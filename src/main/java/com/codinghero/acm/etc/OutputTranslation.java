package com.codinghero.acm.etc;

/**
 * Q: Suppose we can translate numbers into characters: 1->a, 2->b, ...26->z
 * given an integer, for example, 11223, 
 * output every translation of the number.
 * 
 * A: print f(a0,an-1) -> 
 * print a0 + f(a1,an-1)
 * print a0a1 + f(a2,an-1)
 * 
 * @author liutong01
 *
 */
public class OutputTranslation {

	public void printAll(String prefix, int[] numbers, int start) {
		if (start >= numbers.length)
			System.out.println(prefix);
		else if (start == numbers.length - 1) {
			if (numbers[start] != 0)
				printAll(prefix + getChar(numbers[start]), numbers, start + 1);
		} else {
			if (numbers[start] != 0) {
				printAll(prefix + getChar(numbers[start]), numbers, start + 1);
				if (getTwoBitNumber(numbers, start) <= 26)
					printAll(prefix + getChar(getTwoBitNumber(numbers, start)),
							numbers, start + 2);
			}
		}
	}

	private int getTwoBitNumber(int[] numbers, int start) {
		return numbers[start] * 10 + numbers[start + 1];
	}

	private char getChar(int number) {
		return (char) ('a' + number - 1);
	}

	public static void main(String[] args) {
		int[] numbers = { 1, 1, 2, 2, 3 };
		OutputTranslation ot = new OutputTranslation();
		ot.printAll("", numbers, 0);
	}

}
