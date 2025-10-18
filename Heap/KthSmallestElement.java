package com.logicmojo.Heap;

public class KthSmallestElement {

    public int kthSmallestElement(int[] nums, int k) {
        for (int i = (nums.length/2)-1;i>=0;i--) {
            topDownHeapify(nums, i, nums.length);
        }
        int heapSize = nums.length;
        int ans = -1;
        for (int i=0; i<k; i++) {
            ans = nums[0];
            nums[0] = nums[heapSize-1];
            heapSize--;
            topDownHeapify(nums, 0, heapSize);
        }
        return ans;
    }

    public void topDownHeapify(int[] nums, int ind, int heapSize) {
        int smallest = ind;
        int left = 2 * ind + 1;
        int right = 2 * ind + 2;
        if (left < heapSize && nums[left] < nums[smallest]) {
            smallest = left;
        }
        if (right < heapSize && nums[right] < nums[smallest]) {
            smallest = right;
        }
        if (smallest == ind) {
            return;
        }
        int temp = nums[ind];
        nums[ind] = nums[smallest];
        nums[smallest] = temp;
        topDownHeapify(nums, smallest, heapSize);
    }
}
