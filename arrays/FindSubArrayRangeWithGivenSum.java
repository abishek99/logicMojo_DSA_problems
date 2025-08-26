package com.logicmojo.arrays;

import java.util.HashMap;

public class FindSubArrayRangeWithGivenSum {

    public static int findSubArray(int[] arr, int tar) {
        //[10, 2, -2, -20, 10]
        HashMap<Integer,Integer> freq = new HashMap<>();
        freq.put(0, 1);
        int prefixSum = 0;
        int count = 0;
        for (int i=0; i<arr.length;i++) {
            prefixSum+=arr[i];
            if (freq.containsKey(prefixSum - tar)) {
                count+=freq.get(prefixSum - tar);
            } else {
                freq.put(prefixSum, freq.getOrDefault(prefixSum,0)+1);
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int arr[] = new int[] {10, 2, -2, -20, 10};
        System.out.println(findSubArray(arr, -10));
    }
}
