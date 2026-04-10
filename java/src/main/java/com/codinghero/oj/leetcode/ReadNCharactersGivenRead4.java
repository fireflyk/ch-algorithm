package com.codinghero.oj.leetcode;

public class ReadNCharactersGivenRead4 {

    public int read(char[] buf, int n) {
        int readCount = 0, count = 4;
        // count < 4. orig not engough (orig size < n), break
        // readCount >= n. orig enough, exceed n
        while (count == 4 && readCount < n) {
            char[] cs = new char[4];
            count = read4(cs);
            if (readCount + count < n) {
                copy(cs, 0, buf, readCount, 4);
            }
            // orig enough, not exceed n, continue
            else {
                copy(cs, 0, buf, readCount, n - readCount);
            }
            readCount += count;
        }
        return Math.min(n, readCount);
    }

    private void copy(char[] orig, int origIndex, char[] dest, int destIndex, int size) {
        for (int i = 0; i < size; i++) {
            dest[destIndex + i] = orig[origIndex + i];
        }
    }

    private int read4(char[] buf) {
        return 0;
    }

    public static void main(String[] args) {
        char[] cs = new char[4];
        cs[0] = '\0';
        System.out.println(cs[0]);
        System.out.println(cs[1]);
        System.out.println(cs[0] == cs[1]);
    }
}
