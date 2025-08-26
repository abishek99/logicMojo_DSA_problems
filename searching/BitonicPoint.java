package com.logicmojo.searching;

public class BitonicPoint {

    public static int findBitonicPoint(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low < high) {
            mid = (low + high) / 2;
            if (mid > 0 && mid < arr.length - 1 && arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]) {
                return arr[mid];
            } else if (mid > 0 && mid < arr.length - 1 && arr[mid - 1] < arr[mid] && arr[mid + 1] > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return arr[low];
    }
}
