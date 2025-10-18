package com.logicmojo.Heap;

import java.util.PriorityQueue;

public class HeapSort {

    public void heapSort(int []arr) {
        //create MaxHeap
        int n =  arr.length;
        for (int i = (n / 2) - 1; i>=0; i--){
            topDownHeapify(arr, i, n);
        }
        int heapSize = n;
        while (heapSize > 1) {
            int temp = arr[0];
            arr[0] = arr[heapSize-1];
            arr[heapSize-1] = temp;
            heapSize--;
            topDownHeapify(arr, 0, heapSize);
        }
    }

    public void topDownHeapify(int[] arr, int ind, int heapSize) {
        int largest = ind;
        int left = 2 * ind + 1;
        int right = 2 * ind + 2;
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest == ind) {
            return;
        }
        int temp = arr[largest];
        arr[largest] = arr[ind];
        arr[ind] = temp;
        topDownHeapify(arr, largest, heapSize);
    }

    public void priorityQ(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int j : arr) {
            pq.add(j);
        }
        for (int i=0; i < arr.length; i++) {
            arr[i] = pq.poll();
        }
    }
}
