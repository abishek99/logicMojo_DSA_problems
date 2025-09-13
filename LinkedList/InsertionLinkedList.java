package com.logicmojo.LinkedList;

public class InsertionLinkedList {

    public static Node insertNodeAtEnd(int val, Node head) {
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(val);
        return head;
    }

     public static Node insertNodeAtEndRec(int val, Node head) {
        if (head.next == null) {
            head.next = new Node(val);
            return head.next;
        }
        insertNodeAtEndRec(val, head.next);
        return head;
    }
}
