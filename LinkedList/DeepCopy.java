package com.logicmojo.LinkedList;

public class DeepCopy {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static Node deepCopy(Node head) {
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        curr = head;
        while (curr != null && curr.next!=null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        curr = head;
        Node newNode = new Node(-1);
        Node temp  = newNode;
        while (curr != null) {
            Node copyNode = curr.next;
            curr.next = copyNode.next;
            temp.next = copyNode;
            temp = temp.next;
            curr = curr.next;
        }
        return newNode.next;
    }

    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        Node curr = deepCopy(n1);
        while (curr != null) {
            System.out.print(curr.val+ "->");
            curr = curr.next;
        }
        //System.out.print("null");
    }
}
