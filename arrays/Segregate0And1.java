package com.logicmojo.arrays;

public class Segregate0And1 {

    static void segregate0and1(int[] arr) {
        // code here
        int l=0;
        int r = arr.length-1;
        while (true) {
            while (l < r && arr[l] != 1) {
                l++;
            }
            while (l <r  && arr[r] != 0) {
                r--;
            }
            if (l >= r) {
                return;
            }
            int swap = arr[l];
            arr[l] = arr[r];
            arr[r] = swap;
        }
    }

}
