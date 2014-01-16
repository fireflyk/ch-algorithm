package com.codinghero.acm.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class WordBreak2 {
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		Trie t = new Trie();
		Iterator<String> iter = dict.iterator();
		while (iter.hasNext()) {
			t.insert(iter.next());
		}
		
		ArrayList<ArrayList<String>> memo = new ArrayList<ArrayList<String>>(s.length());
		for (int i = 0; i < s.length(); i++) {
			memo.add(null);
		}
		wordBreak(s, t, 0, memo);

		return memo.get(0);
	}

	private void wordBreak(String s, Trie t, final int index, ArrayList<ArrayList<String>> memo) {

		if (memo.size() == 0) {
			memo.add(new ArrayList<String>());
			return;
		} else if (memo.get(index) != null) {
			return;
		}
		
		Trie.Node tempNode = t.root;
		int tempIndex = index;
		StringBuilder sb = new StringBuilder();
		ArrayList<String> resultList = new ArrayList<String>();
		while (true) {
			if (tempIndex == s.length()) {
				memo.set(index, resultList);
				return;
			}
			sb.append(s.charAt(tempIndex));
			tempNode = t.get(tempNode, s.charAt(tempIndex));
			if (tempNode == null) {
				memo.set(index, resultList);
				return;
			} else if (!tempNode.getEnd()) {
				tempIndex++;
			} else {
				// arrive the tail, append the prefix
				if (tempIndex + 1 == s.length()) {
					resultList.add(sb.toString());
				}
				// not arrive the tail
				else {
					wordBreak(s, t, tempIndex + 1, memo);
					ArrayList<String> list = memo.get(tempIndex + 1);
					// if success, append them
					if (list != null && list.size() > 0) {
						for (int i = 0; i < list.size(); i++) {
							String suffix = list.get(i);
							// arrive the tail, append the suffix
							if(!suffix.equals("")) {
								resultList.add(sb.toString() + " " + suffix);
							}
							// not arrive the tail, append the suffix
							else {
								resultList.add(sb.toString());
							}
						}
					}
				}
				tempIndex++;
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
