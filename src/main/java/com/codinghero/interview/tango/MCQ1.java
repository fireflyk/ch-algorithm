package com.codinghero.interview.tango;

public class MCQ1 {
	public static void main(String[] args){
		short v1 = 18;
        Long v2 = new Long("18");
        Long v3 = new Long(18);
        Short v4 = new Short(v1);
		System.out.println(v1 == v2);
		System.out.println(v2 == v3);
		System.out.println(v3.equals(v1));
		System.out.println(v3.equals(v4));
	}
}
