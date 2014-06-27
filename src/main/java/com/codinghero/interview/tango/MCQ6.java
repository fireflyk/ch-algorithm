package com.codinghero.interview.tango;

public class MCQ6 {
	public static void main(String[] args) {
		MCQ6 x = new MCQ6(); /* Line 5 */
		MCQ6 x2 = m1(x);
		MCQ6 x4 = new MCQ6(); /* Line 7 */
		x2 = x4; /* Line 8 */
		System.out.println();
	}

	static MCQ6 m1(MCQ6 mx) {
		mx = new MCQ6(); /* Line 13 */
		return mx;
	}
}
