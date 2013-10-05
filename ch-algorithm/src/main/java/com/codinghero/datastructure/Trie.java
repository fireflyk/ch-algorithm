package com.codinghero.datastructure;

public class Trie {
	
	private Node root = new Node();
	
	private class Node {
		private Node[] child = new Node[26];
		private boolean set;
		
		public Node getChild(char c) {
			return child[c - 'a'];
		}

		public boolean visited(char c) {
			return getChild(c) != null;
		}
		
		public Node visit(char c) {
			child[c - 'a'] = new Node();
			return getChild(c);
		}
		
		public void insert() {
			set = true;
		}
		
		public boolean exists() {
			return set;
		}
	}
	
	public void insert(String str) {
		char[] cArr = str.toCharArray();
		Node cur = root;
		for (int i = 0; i < cArr.length; i++) {
			cur = cur.visit(cArr[i]);
		}
		cur.insert();
	}

	public boolean exists(String str) {
		char[] cArr = str.toCharArray();
		Node cur = root;
		for (int i = 0; i < cArr.length; i++) {
			char c = cArr[i];
			if (cur.visited(c))
				cur = cur.getChild(c);
			else
				return false;
		}
		return cur.exists();
	}
}