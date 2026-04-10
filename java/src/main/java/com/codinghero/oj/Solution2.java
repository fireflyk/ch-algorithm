package com.codinghero.oj;

public class Solution2 {
    public String solution(String S) {
        if (S == null || S.length() == 0)
            return S;
        char c0 = S.charAt(0);
        int i = 1;
        StringBuilder result = new StringBuilder();
        while (i < S.length()) {
            char c1 = S.charAt(i++);
            // AB,AA,BA => A
            if ((c0 == 'A' && c1 == 'B') || (c0 == 'A' && c1 == 'A') || (c0 == 'B' && c1 == 'A')) {
                c0 = 'A';
            }
            // CB,CC,BC => C
            else if ((c0 == 'C' && c1 == 'B') || (c0 == 'C' && c1 == 'C') || (c0 == 'B' && c1 == 'C')) {
                c0 = 'C';
            }
            // AC,CA, go to next char
            else {
                result.append(c0);
                c0 = c1;
            }
        }
        result.append(c0);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().solution("ABBCC"));
        System.out.println(new Solution2().solution("AC"));
        System.out.println(new Solution2().solution(""));
        System.out.println(new Solution2().solution("A"));
    }
}
