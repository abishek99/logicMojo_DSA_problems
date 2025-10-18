package com.logicmojo.Heap;

public class KthLargestEle {

    public int kthLargestElement(int[] nums, int k) {
        for (int i = (nums.length / 2) - 1; i>=0; i--) {
            topDownHeapify(nums, i , nums.length);
        }
        int ans = 0;
        int heapSize = nums.length;
        for (int i = 0 ; i < k ; i++) {
             ans = nums[0];
             nums[0] = nums[heapSize-1];
             heapSize--;
             topDownHeapify(nums, 0, heapSize);
        }
        return ans;
    }

    public void topDownHeapify(int[] nums, int index, int heapSize) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest == index) {
            return;
        }
        int temp = nums[index];
        nums[index] = nums[largest];
        nums[largest] = temp;
        topDownHeapify(nums, largest , heapSize);
    }
}
