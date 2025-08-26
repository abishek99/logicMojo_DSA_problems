package com.logicmojo.arrays;

public class MaximumDifferenceBetweenIncreasingElements {

    public static int findMaximumIncreasingEle(int[] nums) {
        int preMin = nums[0];
        int max = -1;
        for (int i=1; i<nums.length; i++) {
            if (preMin >= nums[i]) {
                preMin = nums[i];
            } else {
                max = Math.max(max, nums[i]-preMin);
            }
        }
        return max;
    }
}
