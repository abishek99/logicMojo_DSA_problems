package com.logicmojo.LinkedList;

public class ReverseDoublyLinkedList {


    public static Node reverseDoubyLinkedList(Node head) {
       if (head.next == null) {
           return head;
       }
       Node curr = head;
       Node prev = null;
       while (curr != null) {
           Node temp = curr.next;
           curr.prev = temp;
           curr.next = prev;
           prev = curr;
           curr = temp;
       }
       return prev;
    }

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }


}
