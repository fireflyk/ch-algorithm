package com.codinghero.acm.leetcode;

public class ReadNCharactersGivenRead4II {

    private char[] buffer = new char[4];

    private int size;

    public int read(char[] buf, int n) {
        if (n <= size) {
            for (int i = 0; i < n && i < size; i++) {
                buf[i] = buffer[i];
            }
            for (int i = n; i < size; i++) {
                buffer[i - n] = buffer[i];
            }
            size -= n;
            return n;
        } else {
            for (int i = 0; i < size; i++) {
                buf[i] = buffer[i];
            }
            int tempSize = size;
            size = 0;
            return readFromOrig(buf, n - tempSize, tempSize);
        }
    }

    private int readFromOrig(char[] buf, int n, int offset) {
        int readCount = offset, count = 4;
        n += offset;
        // count < 4. orig not engough (orig size < n), break
        // readCount >= n. orig enough, exceed n
        while (count == 4 && readCount < n) {
            char[] cs = new char[4];
            count = read4(cs);
            if (readCount + count <= n) {
                copy(cs, 0, buf, readCount, count);
                readCount += count;
            }
            // orig enough, not exceed n, continue
            else {
                copy(cs, 0, buf, readCount, n - readCount);
                size = readCount + count - n;
                copy(cs, n - readCount, buffer, 0, size);
                readCount = n;
            }
        }
        return readCount;
    }

    private void copy(char[] orig, int origIndex, char[] dest, int destIndex, int size) {
        for (int i = 0; i < size; i++) {
            dest[destIndex + i] = orig[origIndex + i];
        }
    }

    private int read4(char[] buf) {
        return 0;
    }
}
