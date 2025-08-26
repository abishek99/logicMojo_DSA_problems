package com.logicmojo.arrays;

public class MajorityElement {

    // Boyer-Moore Voting Algorithm
    public static int findMajprityElement(int[] nums) {
        int votes = 0;
        int candidate = 0;
        for (int num : nums) {
            if (votes == 0) {
                candidate = num;
                votes++;
            } else if (candidate == num) {
                votes++;
            } else {
                votes--;
            }
        }
        votes = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == candidate) {
                votes+=1;
            }
        }
        if (nums.length/2 <= votes) {
            return candidate;
        }
        return -1;
    }
}
