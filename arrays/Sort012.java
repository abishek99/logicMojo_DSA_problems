package com.logicmojo.arrays;

public class Sort012 {

    public static void sort(int arr[]) {
        int l = 0;
        int r = arr.length-1;
        while (true) {
            while (l < r && arr[l] == 0) {
                l++;
            }
            while (l < r && arr[r] != 0) {
                r--;
            }
            if (l >= r) {
                break;
            }
            int swap = arr[l];
            arr[l] = arr[r];
            arr[r] = swap;
        }
        r = arr.length-1;
        while (true) {
            while (l < r && arr[l] == 1) {
                l++;
            }
            while (l < r && arr[r] == 2) {
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

    public static void main(String[] args) {
        int arr[] = new int[] {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sort(arr);
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
}
