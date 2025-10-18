package com.logicmojo.LinkedList;

public class ReverseNodeKGroup {

    public static Node reverseKGroup(Node head, int k) {
       if (k == 1 || head == null || head.next == null) {
           return head;
       }
       Node curr = head;
       Node prev = null;
       while (curr != null) {
           Node kthNode = kthNode(curr, k);
           if(kthNode == null) {
               prev.next = curr;
               break;
           }
           Node nextGroup = kthNode.next;
           kthNode.next = null;
           reverse(curr);
           if (head == curr) {
               head = kthNode;
           } else {
               prev.next = kthNode;
           }
           prev = curr;
           curr = nextGroup;
       }
       return head;
    }

    // 1-> 2-> 3-> null
    public static void reverse(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
    }

    public static Node kthNode(Node head, int k) {
        Node curr = head;
        while (curr != null &&  k > 1) {
            k--;
            curr = curr.next;
        }
        return curr;
    }

}
