package com.logicmojo.Heap;

import java.util.PriorityQueue;

public class NearlySorted {

    public void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i=0; i<=k; i++) {
            minHeap.offer(arr[i]);
        }
        int index = 0;
        for (int i = k + 1; i < arr.length ;i++) {
            arr[index++] = minHeap.poll();
            minHeap.offer(arr[i]);
        }

        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
     }
}
