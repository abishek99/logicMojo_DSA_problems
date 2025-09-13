package com.logicmojo.LinkedList;

public class GetkthNode {

    public static int getKthNode(Node head, int x) {
        Node slowNode = head;
        int slow = 1;
        while (slowNode!=null) {
            if (slow == x) {
                return slowNode.data;
            }
            slowNode = slowNode.next;
            slow++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Node curr = new Node(1);
        Node head = curr;
        for (int i = 2; i <= 5; i++) {
            curr.next = new Node(i);
            curr = curr.next;
        }
        System.out.println(getKthNode(head, 4));
    }

}
