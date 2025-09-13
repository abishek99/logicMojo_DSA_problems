package com.logicmojo.searching;

public class FindSqrt {

    static int floorSqrt(int n) {
        // code here
        int start = 1;
        int num = 1;
        while (start * start <= n) {
            num = start;
            start++;
        }
        return num;
    }

    static int binarySearch (int n) {
//        int l = 0;
//        int r = n;
//        while (l <= r) {
//            int mid = l + (r-l)/2;
//            if (mid * mid == n) {
//                return mid;
//            } else if (mid * mid >= n) {
//                r = mid-1;
//            } else {
//                l = mid+1;
//            }
//        }
//        return 1;

        int l = 0;
        int r = n;
        int num = 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid * mid == n) {
                return mid;
            } else if ((mid * mid) >= n) {
                r = mid - 1;
            } else {
                l = mid + 1;
                num = mid;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(16));
    }
}
