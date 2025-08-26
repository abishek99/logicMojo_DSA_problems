package com.logicmojo.searching;

public class BinarySearch {

    public static int binarySearch(int[] arr, int search) {
        int l = 0;
        int r = arr.length-1;
        while (l <= r) {
            int mid = l + (r-l) / 2;
            if (arr[mid] == search) {
                return mid;
            } else if (arr[mid] > search) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return -1;
    }

}
