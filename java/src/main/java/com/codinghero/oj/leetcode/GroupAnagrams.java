package com.codinghero.oj.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[][] charNums = new int[strs.length][26];
        String[] anagrams = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                charNums[i][c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < 26; k++) {
                char c = (char) (k + 'a');
                for (int l = 0; l < charNums[i][k]; l++) {
                    sb.append(c);
                }
            }
            anagrams[i] = sb.toString();
        }

        Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            String anagram = anagrams[i];
            PriorityQueue<String> minHeap = map.get(anagram);
            if (minHeap == null) {
                minHeap = new PriorityQueue<String>();
                map.put(anagram, minHeap);
            }
            minHeap.offer(str);
        }

        List<List<String>> result = new LinkedList<List<String>>();
        Iterator<PriorityQueue<String>> iter = map.values().iterator();
        while (iter.hasNext()) {
            PriorityQueue<String> minHeap = iter.next();
            List<String> sameAnagrams = new LinkedList<String>();
            while (!minHeap.isEmpty()) {
                sameAnagrams.add(minHeap.poll());
            }
            result.add(sameAnagrams);
        }

        return result;
    }
}
