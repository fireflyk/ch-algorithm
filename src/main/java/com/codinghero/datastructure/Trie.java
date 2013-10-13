package com.codinghero.datastructure;

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

	public boolean exists(Node node, String str) {
		Node resultNode = get(node, str);
		if (resultNode == null)
			return false;
		else
			return resultNode.getEnd();
	}

	public boolean exists(String str) {
		return exists(root, str);
	}
}