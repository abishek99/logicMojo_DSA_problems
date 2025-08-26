package com.logicmojo.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class PairsClosestToSum {

    public static int closestToZero(int[] arr) {
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length-1;
        int closestSum = arr[l] + arr[r];
        while (l < r) {
            int currentSum = arr[l] + arr[r];
            if (Math.abs(currentSum) < Math.abs(closestSum)) {
                closestSum = currentSum;
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



    public static void main(String[] args) {
        //int[] arr = new int[]{-21, -67, -37, -18, 4, -65};
        int[] arr = new int[] {-8,-66,-60};
        System.out.println(closestToZero(arr));
    }
}
