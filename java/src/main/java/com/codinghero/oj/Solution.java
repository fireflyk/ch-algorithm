package com.codinghero.oj;

class Solution {
    int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (A[m] == X) {
                return m;
            } else if (A[m] > X) {
                r = m - 1;
            } else {
                l = Math.max(m, l + 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[] { -2, 2 }, 2));
        System.out.println(new Solution().solution(new int[] { -2, 2 }, -2));
    }
}

