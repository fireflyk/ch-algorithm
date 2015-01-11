package com.codinghero.interview.amazon;

public class ListManupilation {
	/*
	 * Complete the function below.
	 */
	/*
	 * For your reference: LinkedListNode { int val; LinkedListNode *next; };
	 */

	public static class LinkedListNode{
        int val;
        LinkedListNode next;
    
        LinkedListNode(int node_value) {
            val = node_value;
            next = null;
        }
    }

	static LinkedListNode manipulateList(LinkedListNode root) {
		if (root == null || root.next == null)
			return root;
		LinkedListNode mid = root, tail = root.next;
		while (true) {
			mid = mid.next;
			tail = tail.next;
			if (tail == null) {
				break;
			}
			tail = tail.next;
			if (tail == null) {
				break;
			}
		}
		
		LinkedListNode n1 = root, n2 = mid;
		while (n1.next != mid) {
			LinkedListNode h1Next = n1.next;
			LinkedListNode h2Next = n2.next;
			n1.next = n2;
			n2.next = h1Next;
			n1 = h1Next;
			n2 = h2Next;
		}
		n1.next = n2;
		return root;
	}

}
