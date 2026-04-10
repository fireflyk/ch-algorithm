package com.codinghero.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i <= num.length - 3; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                if (num[i] + num[start] + num[end] == 0) {
                    ArrayList<Integer> oneOfResult = new ArrayList<Integer>();
                    oneOfResult.add(num[i]);
                    oneOfResult.add(num[start]);
                    oneOfResult.add(num[end]);
                    result.add(oneOfResult);
                    start++;
                    end--;
                    while (num[start] == num[start - 1] && start < end)
                        start++;
                    while (num[end] == num[end + 1] && start < end)
                        end--;
                } else if (num[i] + num[start] + num[end] > 0) {
                    end--;
                } else {
                    start++;
                }
            }

            while (i <= num.length - 4 && num[i] == num[i + 1]) {
                i++;
            }
        }
        return result;
    }
}
