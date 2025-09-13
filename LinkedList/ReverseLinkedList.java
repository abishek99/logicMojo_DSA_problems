package com.logicmojo.LinkedList;

public class ReverseLinkedList {

    public static Node reverseNode(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static Node reverseNodeRec(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newNode = reverseNodeRec(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    public static void printLinkedListRec(Node head) {
        if (head == null) {
            System.out.print("null");
            return;
        }
        System.out.print(head.data+"->");
        printLinkedListRec(head.next);
    }

}
