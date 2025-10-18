package com.logicmojo.stack;

public class MinStack {

    class Node {
        int val;
        int min;
        Node next;

        Node(int val, int min) {
            this.val = val;
            this.min = min;
            this.next = null;
        }
    }

    Node head;
    int size;

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val);
        } else {
            Node newHead = new Node(val, Math.min(head.min, val));
            newHead.next = head;
            head = newHead;
        }
        size++;
    }

    public void pop() {
        if (head != null) {
            head = head.next;
            size--;
        }
    }

    public int top() {
        if (head == null) {
            return -1;
        } else {
            int data = head.val;
            return data;
        }
    }

    public int getMin() {
        if (head == null) {
            return -1;
        }
        return head.min;
    }

}
