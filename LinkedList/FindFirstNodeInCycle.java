package com.logicmojo.LinkedList;

public class FindFirstNodeInCycle {

    public static int findFirstNodeInCycle(Node head) {
        Node slow = head;
        Node fast = head;
        Node cycleNode = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycleNode = fast;
                break;
            }
        }
        slow = head;
        while (slow !=null && cycleNode!=null) {
            if (slow == cycleNode) {
                return slow.data;
            }
            slow = slow.next;
            cycleNode = cycleNode.next;
        }
        return -1;
    }
}
