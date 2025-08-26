package com.logicmojo.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class PairsClosestToSum {

    public static int closestToZero(int[] arr) {
        Arrays.sort(arr);
        int l = 0, r = arr.length-1;
        int closestSum = Integer.MAX_VALUE;
        while (l < r) {
            int currentSum = arr[l] + arr[r];
            if (Math.abs(closestSum) > Math.abs(currentSum)) {
                closestSum = currentSum;
            }
            if (Math.abs(closestSum) ==  Math.abs(currentSum)) {
                closestSum  = Math.max(closestSum, currentSum);
            }
            if (currentSum == 0) {
                return 0;
            } else if (currentSum < 0) {
                l++;
            } else {
                r--;
            }
        }
        return closestSum;
    }

}
