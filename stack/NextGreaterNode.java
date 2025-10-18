package com.logicmojo.stack;

import com.logicmojo.LinkedList.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class NextGreaterNode {

    public static int[] nextGreaterNode(Node head) {
        List<Integer>  list = new ArrayList<>();
        Node curr = new Node(-1);
        curr.next = head;
        while (curr.next != null) {
            list.add(curr.next.data);
            curr = curr.next;
        }
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int[] arr = new int[list.size()];
        for (int i=0; i <list.size(); i++) {
            if (st.isEmpty()) {
                st.push(i);
            } else {
                while (!st.isEmpty() && list.get(st.peek()) < list.get(i)) {
                   arr[st.peek()] = list.get(i);
                   st.pop();
                }
                st.push(i);
            }
        }
        return arr;
    }
}
