package com.logicmojo.Heap;

import java.util.Collections;
import java.util.List;

public class ImplementPriorityQueue {

    public int pop(List<Integer> heap) {
        // Write you code here.
        if (heap.isEmpty()) {
            return -1;
        }
        int ele = heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        topDownHeapfiy(heap, 0);
        return ele;
    }
    public void topDownHeapfiy(List<Integer> heap, int ind) {
        int largest = ind;
        int left = 2 * ind + 1;
        int right = 2 * ind + 2;
        if (left < heap.size() && heap.get(left) > heap.get(largest)) {
            largest = left;
        }
        if (right < heap.size() && heap.get(right) > heap.get(largest)) {
            largest = right;
        }
        if (largest == ind) {
            return;
        }
        Collections.swap(heap, largest, ind);
        topDownHeapfiy(heap, largest);
    }

}
