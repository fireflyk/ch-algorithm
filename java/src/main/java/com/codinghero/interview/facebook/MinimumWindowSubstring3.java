package com.codinghero.interview.facebook;

/**
 * S: "ecdaebbcdaf"<br/>
 * T: "abc"<br/>
 * Destination: Find the shortest substring of S which include all character in
 * T Result: "bcda"
 * 
 * @author tliu
 *
 */
public class MinimumWindowSubstring3 {

    public String minWindow(String s, String t) {
        int unMatched = 0;
        Integer[] unMatchedCount = new Integer[128];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (unMatchedCount[c] != null) {
                unMatchedCount[c]++;
            } else {
                unMatched++;
                unMatchedCount[c] = 1;
            }
        }

        IndexRange result = null;
        Integer start = -1, end = -1;

        do {
            for (end = end + 1; end < s.length(); end++) {
                char c = s.charAt(end);
                if (unMatchedCount[c] != null) {
                    unMatchedCount[c]--;
                    if (unMatchedCount[c] == 0) {
                        unMatched--;
                    }
                    if (unMatched == 0) {
                        result = getBetterResult(result, new IndexRange(start, end));
                        break;
                    }
                }
            }
            if (end >= s.length())
                break;

            for (start = start + 1; start <= end; start++) {
                char c = s.charAt(start);
                if (unMatchedCount[c] != null) {
                    unMatchedCount[c]++;
                    if (unMatchedCount[c] == 1) {
                        unMatched++;
                    }
                    if (unMatched > 0) {
                        result = getBetterResult(result, new IndexRange(start, end));
                        break;
                    }
                }
            }
        } while (end < s.length() && start < end);
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

    public class IndexRange {
        public int start;
        public int end;

        public IndexRange(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
