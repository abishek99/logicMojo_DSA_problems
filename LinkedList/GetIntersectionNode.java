package com.logicmojo.LinkedList;

public class GetIntersectionNode {

    public static Node getIntersectionNode(Node headA, Node headB) {
        int lenA = 0;
        int lenB = 0;
        Node currA = headA;
        Node currB = headB;
        while (currA != null) {
            lenA++;
            currA = currA.next;
        }
        while (currB != null) {
            lenB++;
            currB = currB.next;
        }
        currA = headA;
        currB = headB;
        if (lenA > lenB) {
            int threshold = lenA - lenB;
            int temp = 0;
            while (threshold != temp) {
                temp++;
                currA = currA.next;
            }
        } else {
            int threshold = lenB -  lenA;
            int temp = 0;
            while (threshold != temp) {
                temp++;
                currB = currB.next;
            }
        }
        while (currA != null && currB != null) {
            currA = currA.next;
            currB = currB.next;
            if (currA == currB) {
                return currA;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nodeData1 = {4, 1, 8, 4, 5};
        int[] nodeData2 = {5, 6, 1, 8, 4, 5};
        Node head1 = new Node(nodeData1[0]);
        Node curr1 = head1;
        for (int i = 1; i < nodeData1.length; i++) {
            curr1.next = new Node(nodeData1[i]);
            curr1 = curr1.next;
        }
        Node head2 = new Node(nodeData2[0]);
        Node curr2 = head2;
        for (int i = 1; i < nodeData2.length; i++) {
            curr2.next = new Node(nodeData2[i]);
            curr2 = curr2.next;
        }
        Node intersectionNode = getIntersectionNode(head1, head2);

        Node curr = intersectionNode;
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.print("null");
    }
}
