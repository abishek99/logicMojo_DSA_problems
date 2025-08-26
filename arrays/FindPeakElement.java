package com.logicmojo.arrays;

public class FindPeakElement {


    public static int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int peak = Integer.MIN_VALUE;
        int index = 0 ;
        while (low < high) {
            int mid = low + (high-low)/2;
            while (low <= mid) {
                if (peak < nums[low]) {
                    peak = Math.max(nums[low], peak);
                    index = low;
                }
                low++;
            }
            low = mid+1;
            while (low <= high) {
                if (peak < nums[low]) {
                    peak = Math.max(nums[low], peak);
                    index = low;
                }
                low++;
            }
        }
        return index;
    }

    public static int binarySearchPeakEle(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while (low < high) {
            int mid = low + (high-low)/2;
            if (nums[mid] < nums[mid+1] ) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }


    public static void main(String[] args) {
        int[] arr = new int[] {1,2,1,3,5,6,4};
        //int[] arr = new int[] {-2147483648,-2147483647};
        System.out.println(binarySearchPeakEle(arr));
    }
}
