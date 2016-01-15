package com.codinghero.acm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        Map<String, Character> valueDict = new HashMap<String, Character>();
        if (words.length != pattern.length())
            return false;

        String[] dict = new String[26];
        for (int i = 0; i < pattern.length(); i++) {
            if (!valueMatched(dict, pattern.charAt(i), words[i]) || !valueDuplicated(valueDict, pattern.charAt(i), words[i]))
                return false;
        }
        return true;
    }

    private boolean valueDuplicated(Map<String, Character> valueDict, char key, String value) {
        if (!valueDict.containsKey(value)) {
            valueDict.put(value, key);
            return true;
        } else {
            return valueDict.get(value).equals(key);
        }
    }

    private boolean valueMatched(String[] keyDict, char key, String value) {
        int index = key - 'a';
        if (keyDict[index] == null) {
            keyDict[index] = value;
            return true;
        } else {
            return keyDict[index].equals(value);
        }
    }
}
