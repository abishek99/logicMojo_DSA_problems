package com.logicmojo.arrays;

public class LongestSubArrayPositiveWithSumK {

    /*
    sliding window works only when arr is all positive
     */
    public static int longestSubArray(int[] arr, int k) {
        int l=0;
        int sum = arr[l];
        int count = 0;
        for (int j = 1; j< arr.length; j++) {
            sum+=arr[j];
            if (sum == k) {
                count++;
            } else if (sum > k){
                while (sum > k  && l <= j) {
                    sum-=arr[l];
                    l++;
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
