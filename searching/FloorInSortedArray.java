package com.logicmojo.searching;

public class FloorInSortedArray {

    public static int floorInSortedArray(int[] arr, int x) {
        int l = 0;
        int r = arr.length-1;
        int index = -1;

        while (l <= r) {
            int mid = l + (r-l)/2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                r=mid-1;
            } else if (arr[mid] < x) {
                index = mid;
                l= mid+1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int arr[] = new int[] {1, 2, 8, 10, 10, 12, 19};
       // int arr[] = new int[] {2};
        //int arr[] = new int[] {8,18,26,28,32,35,37,38,42,47,49,51,51,67,80};
        System.out.println(floorInSortedArray(arr, 11));
    }
}
