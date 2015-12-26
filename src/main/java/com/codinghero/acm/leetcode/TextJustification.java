package com.codinghero.acm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a length L, format the text such that each line
 * has exactly L characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words
 * as you can in each line. Pad extra spaces ' ' when necessary so that each
 * line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If
 * the number of spaces on a line do not divide evenly between words, the empty
 * slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is
 * inserted between words.
 * 
 * For example, words: ["This", "is", "an", "example", "of", "text",
 * "justification."] L: 16.
 * 
 * Return the formatted lines as: [ "This    is    an", "example  of text",
 * "justification.  " ]
 * 
 * @author tliu
 *
 */
public class TextJustification {
	public List<String> fullJustify(String[] words, int L) {
        int curL = 0;
        int curStart = 0;
        List<String> result = new ArrayList<String>();
		for (int i = 0; i < words.length; i++) {
            String word = words[i];
			if (word.length() + curL + (i - curStart) <= L) {
                curL += word.length();
            } else {
                result.add(getLine(words, L - curL, curStart, i - 1));
                curStart = i;
                curL = words[i].length();
            }
        }
        result.add(getTailLine(words, L - curL, curStart, words.length - 1));
        return result;
    }
    
    private String getLine(String[] words, int spaceL, int start, int end) {
		if (start == end) {
			return words[start] + getSpace(spaceL);
		}
        int spaceSlot = end - start;
        int leastSpace = spaceL / spaceSlot;
        int remainder = spaceL % spaceSlot;
        StringBuilder sb = new StringBuilder();
		for (int i = start; i < end; i++, remainder--) {
			sb.append(words[i]);
			sb.append(getSpace(leastSpace + (remainder > 0 ? 1 : 0)));
		}
        sb.append(words[end]);
        return sb.toString();
    }
    
    private String getTailLine(String[] words, int spaceL, int start, int end) {
    	StringBuilder sb = new StringBuilder();
		for (int i = start; i < end; i++) {
			sb.append(words[i]);
			sb.append(" ");
		}
		sb.append(words[end]);
		sb.append(getSpace(spaceL - (end - start)));
		return sb.toString();
    }
    
    private String getSpace(int num) {
        if (num == 0) {
			return "";
		} else if (num == 1) {
			return " ";
		} else {
			int num2 = num / 2;
			System.out.println(num2);
			String result = getSpace(num2);
			String extra = num % 2 == 1 ? " " : "";
			return result + result + extra;
		}
    }
}
