package com.codinghero.interview.facebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
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
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        Map<Character, Integer> unMatchedMap = this.getUnMatchedMap(t);
        Set<Character> dict = new HashSet<Character>(unMatchedMap.keySet());
        Map<Character, LinkedList<Integer>> indexesMap = new HashMap<Character, LinkedList<Integer>>();

        IndexRange result = null;
        Integer start = -1, end = -1;
        while (end == null || end < s.length()) {
            start++;
            for (int i = start; i < s.length(); i++) {
                if (dict.contains(s.charAt(i))) {
                    start = i;
                    break;
                }
            }
            for (end = start; end < s.length(); end++) {
                char c = s.charAt(end);
                if (dict.contains(c)) {
                    // not contains prove that unmatched == 0
                    if (!unMatchedMap.containsKey(c)) {
                        removeHead(indexesMap, c);
                        addTail(indexesMap, c, end);
                    } else {
                        addTail(indexesMap, c, end);
                        minus1(unMatchedMap, c);
                    }
                    if (unMatchedMap.isEmpty()) {
                        result = getBetterResult(result, new IndexRange(getUpdatedStartIndex(indexesMap), end));
                    }
                }
            }
        }

        if (result == null)
            return "";
        return s.substring(result.start, result.end + 1);
    }

    private int getUpdatedStartIndex(Map<Character, LinkedList<Integer>> indexesMap) {
        Iterator<Entry<Character, LinkedList<Integer>>> iter = indexesMap.entrySet().iterator();
        int min = Integer.MAX_VALUE;
        while (iter.hasNext()) {
            Entry<Character, LinkedList<Integer>> e = iter.next();
            if (min > e.getValue().getFirst()) {
                min = e.getValue().getFirst();
            }
        }
        return min;
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

    private void addTail(Map<Character, LinkedList<Integer>> indexesMap, char key, int value) {
        LinkedList<Integer> list = indexesMap.get(key);
        if (list == null) {
            list = new LinkedList<Integer>();
            indexesMap.put(key, list);
        }
        list.addLast(value);
    }

    private void removeHead(Map<Character, LinkedList<Integer>> indexesMap, char key) {
        LinkedList<Integer> list = indexesMap.get(key);
        if (list != null)
            list.removeFirst();
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

    private void minus1(Map<Character, Integer> unMatchedMap, char key) {
        Integer value = unMatchedMap.get(key);
        if (value != null) {
            if (value == 1) {
                unMatchedMap.remove(key);
            } else {
                unMatchedMap.put(key, unMatchedMap.get(key) - 1);
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
