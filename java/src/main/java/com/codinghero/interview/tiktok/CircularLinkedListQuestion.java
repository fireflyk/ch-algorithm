package com.codinghero.interview.tiktok;

/**
 * single direct linked list
 * loop?
 */
public class CircularLinkedListQuestion {

    public boolean hasLoop(Node head) {
        if (head == null) {
            return false;
        }
        Node fast = head, slow = head;
        while (true) {
            fast = fast.next;
            if (fast == null) {
                return false;
            }
            if (fast == slow) {
                return true;
            }

            fast = fast.next;
            if (fast == null) {
                return false;
            }
            if (fast == slow) {
                return true;
            }

            slow = slow.next;
        }
    }

    static class Node {
        Node next;

        public Node(Node next) {
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node node5 = new Node(null);
        Node node4 = new Node(node5);
        Node node3 = new Node(node4);
        Node node2 = new Node(node3);
        Node node1 = new Node(node2);

        System.out.println(new CircularLinkedListQuestion().hasLoop(node1));
        System.out.println(new CircularLinkedListQuestion().hasLoop(null));
    }
}
