package com.logicmojo.arrays;

public class FindMissingNumber {

    public static int findMissingNumber(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int j : nums) {
            max = Math.max(j, max);
            min = Math.min(j, min);
        }
        if (min == 1) {
            return 0;
        }
        if (max == 0) {
            return 1;
        }
        int arrSum = 0;
        for (int j : nums) {
            arrSum+= j;
        }
        int actualSum  = (max * (max+1)) / 2;
        if (actualSum - arrSum == 0) {
            return max+1;
        } else {
            return actualSum - arrSum;
        }
    }
}
