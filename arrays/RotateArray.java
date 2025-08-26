package com.logicmojo.arrays;

public class RotateArray {

    public static void rotateArray(int nums[], int k) {
        k = k % nums.length;
        int i=0, j = nums.length-k-1;
        while (i < j) {
            int swap = nums[i];
            nums[i] = nums[j];
            nums[j] = swap;
            i++;
            j--;
        }
        i = nums.length-k ; j = nums.length-1;
        while (i <= j) {
            int swap = nums[i];
            nums[i] = nums[j];
            nums[j] = swap;
            i++;
            j--;
        }
        i = 0; j = nums.length-1;
        while (i < j) {
            int swap = nums[i];
            nums[i] = nums[j];
            nums[j] = swap;
            i++;
            j--;
        }
    }
}
