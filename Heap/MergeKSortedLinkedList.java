package com.logicmojo.Heap;


import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLinkedList {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


    public ListNode mergeKSortedLinkedList(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode proc = dummy;
        while (!pq.isEmpty()) {
           ListNode temp = pq.poll();
           proc.next = temp;
           proc = proc.next;
           ListNode nextNode = temp.next;
           if (nextNode != null){
               pq.offer(nextNode);
           }
           //temp.next = null;
        }
        return dummy.next;
    }


}
