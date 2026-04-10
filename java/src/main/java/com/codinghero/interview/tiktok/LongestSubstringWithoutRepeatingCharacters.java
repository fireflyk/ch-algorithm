package com.codinghero.interview.tiktok;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        final Set<Character> seen = new HashSet<>();
        int maxLength = 0;
        for(char c: s.toCharArray()) {
            if(seen.contains(c)) {
                // handle duplicate
                if(seen.size() > maxLength) {
                    maxLength = seen.size();
                }
                // remove characters from the beginning until no duplicate
                seen.clear();
            } else {
                seen.add(c);
            }
        }
        if(seen.size() > maxLength) {
            maxLength = seen.size();
        }
        // check one final time in case the longest substring is at the end
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); // Expected: 3
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));    // Expected: 1
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));   // Expected: 3
    }
}