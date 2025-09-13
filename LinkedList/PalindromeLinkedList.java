package com.logicmojo.LinkedList;

public class PalindromeLinkedList {

    private static Node findFirstMid(Node head) {
        Node slowNode = head;
        Node fastNode = head;
        while (fastNode != null && fastNode.next != null &&
                fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }

    private static Node reverse(Node head) {
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

    public static boolean palindromeLinkedList(Node head) {
        Node midNode = findFirstMid(head);
        Node reversedNode  = reverse(midNode);
        Node curr = head;
        while (curr!=null && reversedNode!=null) {
            if (curr.data != reversedNode.data) {
                return false;
            }
            curr = curr.next;
            reversedNode = reversedNode.next;
        }
        return true;
    }
}
