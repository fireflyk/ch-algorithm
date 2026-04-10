package com.codinghero.oj;

import java.util.Arrays;

class Solution3 {
    public int solution(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        Arrays.sort(A);
        int prev = A[0];
        int sameCount = 1;
        int result = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == prev) {
                sameCount++;
            } else {
                result += getCombination(sameCount);
                prev = A[i];
                sameCount = 1;
            }
        }
        if (sameCount > 1)
            result += getCombination(sameCount);
        return result;
    }

    /**
     * getCombination(count) = C(count, 2)
     * 
     * @param count
     * @return
     */
    private int getCombination(int count) {
        return count * (count - 1) / 2;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().solution(new int[] { 3, 5, 6, 3, 3, 5, 3 }));
        System.out.println(new Solution3().solution(new int[] {}));
    }
}
