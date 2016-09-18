package com.codinghero.interview.facebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * S: "ecdaebbcdaf"<br/>
 * T: "abc"<br/>
 * Destination: Find the shortest substring of S which include all character in
 * T Result: "bcda"
 * 
 * @author tliu
 *
 */
public class MinimumWindowSubstring2 {

    public String minWindow(String s, String t) {
        Map<Character, Integer> unMatchedMap = this.getUnMatchedMap(t);
        Map<Character, Integer> unMatchedCountMap = new HashMap<Character, Integer>(unMatchedMap);
        Set<Character> dict = new HashSet<Character>(unMatchedMap.keySet());

        IndexRange result = null;
        Integer start = -1, end = -1;

        do {
            for (end = end + 1; end < s.length(); end++) {
                char c = s.charAt(end);
                if (dict.contains(c)) {
                    minus1(unMatchedCountMap, c);
                    minus1OrRemove(unMatchedMap, c);
                    // not contains prove that unmatched == 0
                    if (unMatchedMap.isEmpty()) {
                        result = getBetterResult(result, new IndexRange(start, end));
                        break;
                    }
                }
            }
            if (end >= s.length())
                break;

            for (start = start + 1; start <= end; start++) {
                char c = s.charAt(start);
                if (dict.contains(c)) {
                    plus1(unMatchedCountMap, c);
                    if (unMatchedCountMap.get(c) > 0) {
                        unMatchedMap.put(c, unMatchedCountMap.get(c));
                    }
                    if (!unMatchedMap.isEmpty()) {
                        result = getBetterResult(result, new IndexRange(start, end));
                        break;
                    }
                }
            }
        } while (end < s.length() && start < end);
        System.out.println(start + "," + end + "," + s.length());
        if (result == null)
            return "";

        return s.substring(result.start, result.end + 1);
    }

    private IndexRange getBetterResult(IndexRange result1, IndexRange result2) {
        if (result1 == null) {
            return result2;
        } else if (result2 == null) {
            return result1;
        } else if (result2.end - result2.start < result1.end - result1.start) {
            return result2;
        } else {
            return result1;
        }
    }

    private Map<Character, Integer> getUnMatchedMap(String t) {
        Map<Character, Integer> countMap = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            plus1(countMap, t.charAt(i));
        }
        return countMap;
    }

    private void plus1(Map<Character, Integer> unMatchedMap, char key) {
        Integer value = unMatchedMap.get(key);
        if (value != null) {
            unMatchedMap.put(key, value + 1);
        } else {
            unMatchedMap.put(key, 1);
        }
    }

    private void minus1(Map<Character, Integer> unMatchedCountMap, char key) {
        Integer value = unMatchedCountMap.get(key);
        if (value == null) {
            value = 0;
        }
        unMatchedCountMap.put(key, value - 1);
    }

    private void minus1OrRemove(Map<Character, Integer> unMatchedMap, char key) {
        Integer value = unMatchedMap.get(key);
        if (value != null) {
            if (value == 1) {
                unMatchedMap.remove(key);
            } else {
                unMatchedMap.put(key, value - 1);
            }
        }
    }

    public class IndexRange {
        public int start;
        public int end;

        public IndexRange(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
