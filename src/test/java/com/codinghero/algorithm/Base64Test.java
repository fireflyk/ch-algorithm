package com.codinghero.algorithm;

import org.apache.commons.codec.binary.Base64;

public class Base64Test {
	public static void main(String[] args) {
		String str = "<script></script>";
		System.out.println(new String(new Base64().encode(str.getBytes())));
		System.out.println(new String(new Base64().decode("PHNjcmlwdD48L3NjcmlwdD4")));
	}
	
}
