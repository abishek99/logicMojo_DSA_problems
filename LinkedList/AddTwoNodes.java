package com.logicmojo.LinkedList;

public class AddTwoNodes {

    public static Node splitLinkedList(Node headA, Node headB) {
        Node revHeadA = ReverseLinkedList.reverseNode(headA);
        Node revHeadB = ReverseLinkedList.reverseNode(headB);
        Node sumNode = new Node(-1);
        Node sumFinal = sumNode;
        int carry = 0;
        while (revHeadB!= null && revHeadA!=null) {
            int sum = (revHeadB.data + revHeadA.data) + carry;
            carry = sum / 10;
            sumNode.next = new Node(sum % 10);
            sumNode = sumNode.next;
            revHeadA = revHeadA.next;
            revHeadB = revHeadB.next;
        }
        if (carry > 0) {
            sumNode.next = new Node(carry);
        }
        return sumFinal.next;
    }

    public static void main(String[] args) {

        int[] nodeData = {2,4,3};
        Node head = new Node(nodeData[0]);
        Node curr = head;
        for (int i=1; i<nodeData.length; i++) {
            curr.next = new Node(nodeData[i]);
            curr = curr.next;
        }

        int[] nodeData1 = {5,6,4};
        Node head1 = new Node(nodeData1[0]);
        Node curr1 = head1;
        for (int i=1; i<nodeData1.length; i++) {
            curr1.next = new Node(nodeData1[i]);
            curr1 = curr1.next;
        }
        Node sum = splitLinkedList(head, head1);
        PrintLinkedList.printLinkedListItr(sum);
    }
}
