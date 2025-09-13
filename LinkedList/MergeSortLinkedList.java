package com.logicmojo.LinkedList;

public class MergeSortLinkedList {


    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node middle = findMiddleNode(head);
        Node rightHalf = middle.next;
        middle.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(rightHalf);
        return merge(left, right);
    }

    public static Node merge(Node left, Node right) {
        Node l1 = left;
        Node l2 = right;
        Node dummy = new Node(-1);
        Node dummyPointer = dummy;
        while (l1 != null && l2 != null) {
            if (l1.data >= l2.data) {
                dummyPointer.next = l2;
                l2 = l2.next;
            } else {
                dummyPointer.next = l1;
                l1 = l1.next;
            }
            dummyPointer = dummyPointer.next;
        }
        if (l1 != null) {
            dummyPointer.next = l1;

        }
        if (l2 != null) {
            dummyPointer.next = l2;
        }
        return dummy.next;
    }

    public static Node findMiddleNode(Node head) {
        if (head == null) {
            return null;
        }
       Node slow = head;
       Node fast = head;
       while (fast.next!=null && fast.next.next!=null) {
           slow = slow.next;
           fast = fast.next.next;
       }
       return slow;
    }
}
