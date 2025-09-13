package com.logicmojo.LinkedList;

public class RotateNode {

    private static Node rotateNode(Node head, int k) {
        int len = 0;
        if (head == null || k == 0 || head.next == null) {
            return head;
        }
        Node curr = head;
        while (curr != null) {
            curr = curr.next;
            len++;
        }
        k = k % len;
        if (k == 0) return head;
        int count = 1;
        Node mid = head;
        Node leftNode = mid;
        while (mid != null && count != len - k) {
            mid = mid.next;
            count++;
        }
        Node rightNode = mid.next;
        mid.next = null;
        Node tempNode = rightNode;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        tempNode.next = leftNode;
        return rightNode;
    }

}
