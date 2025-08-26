package com.logicmojo.arrays;

import java.util.Arrays;

public class TripletSum {

    public static boolean tripletSum(int[] arr, int target) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            int num = arr[i];
            int l = i + 1;
            int r = arr.length - 1;
            while (l < r) {
                int sum = num + arr[l] + arr[r];
                if (sum == target) {
                    return true;
                } else if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return false;
    }
}
