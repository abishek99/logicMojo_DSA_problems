package com.logicmojo.Heap;

public class MinHeap {
    int heapSize;
    int[] heap;
    int capacity;


    public MinHeap(int size) {
        heap = new int[size];
        heapSize = 0;
        capacity = size;
    }
    public void insert(int data) {
        if (heapSize >= capacity) {
            return;
        }
        heap[heapSize] = data;
        heapSize++;
        bottomUpHeapify(heapSize-1);
    }
    public void bottomUpHeapify(int index) {
        if (index == 0) return;
        int parent = (index - 1) / 2;
        if (parent < 0 || heap[parent] < heap[index]) {
            return;
        }
        swap(index, parent);
        bottomUpHeapify(parent);
    }

    public void delete(int index) {
        if (index >=  capacity || index  >= heapSize) {
            return;
        }
        heap[index] = heap[heapSize-1];
        heapSize--;
        topDownHeapify(index);
    }

    public int extractMinEle() {
        if (heapSize == 0) {
            return  -1;
        }
        int res = heap[0];
        delete(0);
        return res;
    }

    public void topDownHeapify(int index) {
        int smallest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < heapSize && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right < heapSize && heap[right] < heap[smallest]) {
            smallest = right;
        }
        if (smallest == index) {
            return;
        }
        swap(smallest, index);
        topDownHeapify(smallest);
    }

    void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
}
