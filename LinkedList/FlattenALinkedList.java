package com.logicmojo.LinkedList;

public class FlattenALinkedList {


    public static Node flattenLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node midNode = findMid(head);
        Node rightHalf = midNode.next;
        midNode.next = null;
        Node leftNode = flattenLinkedList(head);
        Node rightNode = flattenLinkedList(rightHalf);
        return merge(leftNode, rightNode);
    }

    public static Node merge(Node left, Node right) {
        Node l1 =  left;
        Node l2 = right;
        Node sorted = new Node(-1);
        Node movingPointer = sorted;
        while (l1!= null && l2!=null) {
            if (l1.data <= l2.data) {
                movingPointer.bottom = l1;
                l1 = l1.bottom;
            } else {
                movingPointer.bottom = l2;
                l2 = l2.bottom;
            }
        }
        if (l1 != null) {
            movingPointer.bottom = l1;
        }
        if (l2 != null) {
            movingPointer.bottom = l2;
        }
        return sorted.bottom;
    }

    public static Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        if (head == null || head.next == null) {
            return head;
        }
        while (fast.next!=null && fast.next.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

   static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int x) {
            data = x;
            next = null;
            bottom = null;
        }
    }

}
