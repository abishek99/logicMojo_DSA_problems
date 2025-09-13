package com.logicmojo.LinkedList;

public class DeleteKthNode {

    private static Node deleteKthNode(int x, Node head) {
        Node curr = head;
        if (x == 1) {
            return head.next;
        }
        int count = 1;
        while (curr!= null && count < (x-1)) {
            curr = curr.next;
            count++;
        }
        curr.next = curr.next.next;
        return head;
    }

    public static void printLinkedListRec(Node head) {
        if (head == null) {
            System.out.print("null");
            return;
        }
        System.out.print(head.data+"->");
        printLinkedListRec(head.next);
    }

    public static void main(String[] args) {
        Node curr = new Node(1);
        Node head = curr;
        for (int i = 2; i <= 10; i++) {
            curr.next = new Node(i);
            curr = curr.next;
        }
        Node insertNode = deleteKthNode(1, head);
        PrintLinkedList.printLinkedListItr(insertNode);
    }


}
