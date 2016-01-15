package com.codinghero.acm.leetcode;

class TrieNode {

    boolean existed;

    TrieNode[] children;

    // Initialize your data structure here.
    public TrieNode() {
        children = new TrieNode[26];
    }
}

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        insert(root, word, 0);
    }

    private void insert(TrieNode node, String word, int wordIndex) {
        if (wordIndex == word.length()) {
            node.existed = true;
            return;
        }
        int ctoi = word.charAt(wordIndex) - 'a';
        if (node.children[ctoi] == null) {
            node.children[ctoi] = new TrieNode();
        }
        insert(node.children[ctoi], word, wordIndex + 1);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(TrieNode node, String word, int wordIndex) {
        if (wordIndex == word.length()) {
            return node.existed;
        }
        int ctoi = word.charAt(wordIndex) - 'a';
        if (node.children[ctoi] == null) {
            return false;
        }
        return search(node.children[ctoi], word, wordIndex + 1);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return startsWith(root, prefix, 0);
    }

    private boolean startsWith(TrieNode node, String word, int wordIndex) {
        if (wordIndex == word.length()) {
            return true;
        }
        int ctoi = word.charAt(wordIndex) - 'a';
        if (node.children[ctoi] == null) {
            return false;
        }
        return startsWith(node.children[ctoi], word, wordIndex + 1);
    }
}