package com.logicmojo.LinkedList;

import static com.logicmojo.LinkedList.PrintLinkedList.printLinkedListRec;

public class MergeTwoSortedLinkedList {

    private static Node mergeTwoSortedLinkedList(Node list1, Node list2) {
        Node l1 = list1;
        Node l2 = list2;
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        Node curr = new Node(-1);
        Node temp = curr;
        while (l1 != null && l2 != null) {
           if (l1.data >= l2.data) {
               temp.next = l2;
               l2 = l2.next;
           } else {
               temp.next = l1;
               l1 = l1.next;
           }
           temp = temp.next;
        }
        while (l1 != null) {
            temp.next = l1;
            temp = temp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            temp.next = l2;
            temp = temp.next;
            l2 = l2.next;
        }
        return curr.next;
    }

    public static void main(String[] args) {
        int[] nodeData = {1,2,3,5};
        int[] nodeData1 = {1,2,3,4,6,7};
        Node head = new Node(nodeData[0]);
        Node curr = head;
        for (int i=1; i<nodeData.length; i++) {
            curr.next = new Node(nodeData[i]);
            curr = curr.next;
        }
        Node head2 = new Node(nodeData1[0]);
        Node curr2 = head2;
        for (int i=1; i<nodeData1.length; i++) {
            curr2.next = new Node(nodeData1[i]);
            curr2 = curr2.next;
        }
        Node sortedNode = mergeTwoSortedLinkedList(head, head2);
        printLinkedListRec(sortedNode);
    }
}
