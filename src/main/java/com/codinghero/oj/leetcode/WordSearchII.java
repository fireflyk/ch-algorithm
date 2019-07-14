package com.codinghero.oj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        WordSearch instance = new WordSearch();
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            if (instance.exist(board, words[i]))
                result.add(words[i]);
        }
        return result;
    }

    private class WordSearch {
        public boolean exist(char[][] board, String word) {
            char[] cArr = word.toCharArray();
            // find the first matched character, and then find recursively
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == cArr[0] && exist(board, cArr, 1, i, j, new boolean[board.length][board[i].length]))
                        return true;
                }
            }
            return false;
        }

        /**
         * find towards up, right, down, left, recursively
         * 
         * @param board
         * @param cArr
         * @param cIndex
         * @param i
         * @param j
         * @param visited
         * @return
         */
        public boolean exist(char[][] board, char[] cArr, int cIndex, int i, int j, boolean[][] visited) {
            if (cIndex == cArr.length)
                return true;
            visited[i][j] = true;
            if (match(board, cArr, cIndex, i - 1, j, visited) && exist(board, cArr, cIndex + 1, i - 1, j, visited)) {
                return true;
            } else if (match(board, cArr, cIndex, i, j + 1, visited) && exist(board, cArr, cIndex + 1, i, j + 1, visited)) {
                return true;
            } else if (match(board, cArr, cIndex, i + 1, j, visited) && exist(board, cArr, cIndex + 1, i + 1, j, visited)) {
                return true;
            } else if (match(board, cArr, cIndex, i, j - 1, visited) && exist(board, cArr, cIndex + 1, i, j - 1, visited)) {
                return true;
            }
            visited[i][j] = false;
            return false;
        }

        private boolean match(char[][] board, char[] cArr, int cIndex, int i, int j, boolean[][] visited) {
            if (i >= 0 && i < board.length && j >= 0 && j < board[i].length && !visited[i][j] && board[i][j] == cArr[cIndex]) {
                return true;
            } else {
                return false;
            }
        }
    }
}
