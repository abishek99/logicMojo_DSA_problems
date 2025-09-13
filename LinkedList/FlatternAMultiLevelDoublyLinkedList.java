package com.logicmojo.LinkedList;

public class FlatternAMultiLevelDoublyLinkedList {


    public static Node flatten(Node head) {
        if (head == null) return null;
        return flattenChild(head);
    }

    public static Node flattenChild(Node head) {
       if (head == null) {
           return null;
       }
       Node curr = head;
       if (curr.child != null) {
           Node child = flattenChild(curr.child);
           Node next = curr.next;
           Node childTail = child;
           while (childTail.next != null) {
               childTail = childTail.next;
           }
           curr.next = child;
           child.prev = curr;
           childTail.next = next;
           curr.child = null;
           if (next != null) {
               next.prev = childTail;
           }
       } else {
           curr.next = flattenChild(curr.next);
       }
       return head;
    }





    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n1.next = n2; n2.prev = n1;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;
        n4.next = n5; n5.prev = n4;
        n5.next = n6; n6.prev = n5;

        // Child of 3 → 7-8-9-10
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);

        n7.next = n8; n8.prev = n7;
        n8.next = n9; n9.prev = n8;
        n9.next = n10; n10.prev = n9;

        n3.child = n7;

        // Child of 8 → 11-12
        Node n11 = new Node(11);
        Node n12 = new Node(12);

        n11.next = n12; n12.prev = n11;

        n8.child = n11;

        Node curr = flatten(n1);
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

   static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

       public Node(int val) {
           this.val = val;
           this.prev = null;
           this.next = null;
           this.child = null;
       }
   }
}
