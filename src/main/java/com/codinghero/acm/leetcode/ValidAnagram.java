package com.codinghero.acm.leetcode;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] sLetterCount = getLetterCount(s);
        int[] tLetterCount = getLetterCount(t);
        return isEqual(sLetterCount, tLetterCount);
    }

    private boolean isEqual(int[] sLetterCount, int[] tLetterCount) {
        for (int i = 0; i < 52; i++) {
            if (sLetterCount[i] != tLetterCount[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] getLetterCount(String s) {
        int[] letterCount = new int[52];
        if (s != null) {
            for (char c : s.toCharArray()) {
                letterCount[index(c)]++;
            }
        }
        return letterCount;
    }

    private int index(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        } else {
            return 26 + (c - 'A');
        }
    }
}
