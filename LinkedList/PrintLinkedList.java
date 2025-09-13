package com.logicmojo.LinkedList;

public class PrintLinkedList {

    public static void printLinkedListItr(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.print("null");
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
