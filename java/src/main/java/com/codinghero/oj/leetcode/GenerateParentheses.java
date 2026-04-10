package com.codinghero.oj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<List<String>> memo = new ArrayList<List<String>>(n + 1);
        for (int i = 0; i <= n; i++) {
            memo.add(null);
        }
        return generateParenthesis(memo, n);
    }

    private List<String> generateParenthesis(List<List<String>> memo, int n) {
        if (memo.get(n) == null) {
            List<String> result = new ArrayList<String>();
            if (n == 0) {
                result.add("");
            } else {
                for (int i = 0; i < n; i++) {
                    List<String> preResults = generateParenthesis(i);
                    List<String> postResults = generateParenthesis(n - 1 - i);
                    for (String pre : preResults) {
                        for (String post : postResults) {
                            result.add("(" + pre + ")" + post);
                        }
                    }

                }
            }
            memo.set(n, result);
        }
        return memo.get(n);
    }
}
