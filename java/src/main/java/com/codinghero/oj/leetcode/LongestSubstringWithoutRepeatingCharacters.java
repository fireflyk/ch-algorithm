package com.codinghero.oj.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> dict = new HashSet<>();
        int max = 0;
        for(int left = 0, right = 0; right < s.length(); right++) {
            char rc = s.charAt(right);
            if (!dict.contains(rc)) {
                dict.add(rc);
                if(right - left + 1 >= max) {
                    max = right-left+1;
                }
            } else {
                for(; left < right; left++) {
                    char lc = s.charAt(left);
                    dict.remove(lc);
                    if (lc == rc) {
                        left++;
                        break;
                    }
                }
            }
        }
        return max;
    }
}
