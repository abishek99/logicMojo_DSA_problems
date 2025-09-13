package com.logicmojo.LinkedList;

public class KthFromEndNode {

    public static int kthNodeFromEnd(Node head, int k) {
        Node refNode = head;
        for (int i=0; i<k; i++) {
            if (refNode != null) {
                refNode = refNode.next;
            } else {
                return -1;
            }
        }
        Node slowPointer = head;
        while (slowPointer!=null && refNode!=null) {
            refNode = refNode.next;
            slowPointer = slowPointer.next;
        }
        if (slowPointer != null) {
            return slowPointer.data;
        }
        return -1;
    }

}
