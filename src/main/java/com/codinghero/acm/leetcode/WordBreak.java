package com.codinghero.acm.leetcode;

import java.util.Iterator;
import java.util.Set;

public class WordBreak {

	public boolean wordBreak(String s, Set<String> dict) {
		Trie t = new Trie();
		Iterator<String> iter = dict.iterator();
		while (iter.hasNext()) {
			t.insert(iter.next());
		}

		return wordBreak(s, t, 0, t.root);
	}

	private boolean wordBreak(String s, Trie t, final int index, final Trie.Node node) {
		if (index == s.length())
			return true;

		Trie.Node tempNode = node;
		int tempIndex = index;
		while (true) {
			if (tempIndex == s.length())
				return false;
			tempNode = t.get(tempNode, s.charAt(tempIndex));
			if (tempNode == null) {
				return false;
			} else if(wordBreak(s, t, tempIndex+1, tempNode)) {
				return true;
			} else if (tempNode.getEnd()) {
				return wordBreak(s, t, tempIndex + 1, t.root);
			} else {
				return false;
			}
		}
	}

	public class Trie {

		private Node root = new Node();

		public class Node {
			private Node[] child = new Node[26];
			private char c;
			private boolean end;

			public Node getChild(char c) {
				return child[c - 'a'];
			}

			public boolean exists(char c) {
				return getChild(c) != null;
			}

			public Node insert(char c) {
				if (child[c - 'a'] == null) {
					child[c - 'a'] = new Node();
					child[c - 'a'].c = c;
				}
				return getChild(c);
			}

			public void setEnd() {
				end = true;
			}

			public boolean getEnd() {
				return end;
			}
		}

		public void insert(String str) {
			char[] cArr = str.toCharArray();
			Node cur = root;
			for (int i = 0; i < cArr.length; i++) {
				cur = cur.insert(cArr[i]);
			}
			cur.setEnd();
		}

		public Node get(String str) {
			return get(root, str);
		}

		public Node get(Node node, char c) {
			return get(node, String.valueOf(c));
		}

		public Node get(Node node, String str) {
			char[] cArr = str.toCharArray();
			Node cur = node;
			for (int i = 0; i < cArr.length; i++) {
				char c = cArr[i];
				if (cur.exists(c))
					cur = cur.getChild(c);
				else
					return null;
			}
			return cur;
		}

		public boolean exists(String str) {
			return exists(root, str);
		}

		public boolean exists(Node node, char c) {
			return exists(node, String.valueOf(c));
		}

		public boolean exists(Node node, String str) {
			Node resultNode = get(node, str);
			if (resultNode == null)
				return false;
			else
				return resultNode.getEnd();
		}
	}
}
