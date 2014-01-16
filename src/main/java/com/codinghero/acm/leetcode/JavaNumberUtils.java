package com.codinghero.acm.leetcode;

public class JavaNumberUtils {
	public boolean isNumber(String str) {
		if (str == null || str.length() == 0)
			return false;
		str = str.trim();
		if (str.length() == 0)
			return false;

		if (str.contains("e")) {
			if (str.indexOf("e") != str.lastIndexOf("e"))
				return false;
			
			String[] strArr = str.split("e");
			if (strArr.length == 2 && isSimpleNumber(strArr[0])
					&& isInteger(strArr[1])) {
				return true;
			} else {
				return false;
			}
		} else {
			return isSimpleNumber(str);
		}

	}

	public boolean isSimpleNumber(String str) {
		if (str.contains("."))
			return isDecimal(str);
		else
			return isInteger(str);
	}

	public boolean isInteger(String str) {
		if (str.startsWith("-"))
			return isPositiveInteger(str.substring(1));
		else if (str.startsWith("+"))
			return isPositiveInteger(str.substring(1));
		else
			return isPositiveInteger(str);
	}

	public boolean isPositiveInteger(String str) {
		if (str.length() == 0)
			return false;
		for (char c : str.toCharArray()) {
			if (c < '0' || c > '9')
				return false;
		}
		return true;
	}

	public boolean isDecimal(String str) {
		if (str.indexOf(".") != str.lastIndexOf("."))
			return false;

		String[] strArr = str.split("\\.");
		if (strArr.length == 2) {
			if (isInteger(strArr[0]) && isPositiveInteger(strArr[1])) {
				return true;
			} else if ((strArr[0].equals("") || strArr[0].equals("-") || strArr[0].equals("+"))
					&& isPositiveInteger(strArr[1])) {
				return true;
			} else if (strArr[1].equals("") && isInteger(strArr[0])) {
				return true;
			} else
				return false;
		} else if (strArr.length == 1) {
			return isInteger(strArr[0]);
		} else {
			return false;
		}
	}
}
