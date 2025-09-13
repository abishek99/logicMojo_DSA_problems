package com.logicmojo.searching;

import java.util.ArrayList;

public class FindDuplicateNumbers {

    public static ArrayList<Integer> findDuplicateNumbers(int[] arr) {
        int l = 0;
        int r = arr.length-1;
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (mid > 0 &&  mid < arr.length-1 &&
                    arr[mid] == arr[mid+1] || arr[mid] == arr[mid-1]) {
                list.add(arr[mid]);
                int left = mid;
                count++;
                while (left >= 0 && arr[left] == arr[mid]) {
                    count++;
                    left--;
                }
                int right = 0;
                while (right <= arr.length-1 && arr[right] == arr[mid]) {
                    count++;
                    right++;
                }
                list.add(count);
               return list;
            }
            else if (arr[r] - arr[mid] < (r - mid) ||
                    arr[mid] - arr[l] == (l + mid)) {
                l = mid+1;
            } else if (arr[mid] - arr[l] < (l + mid) ||
                    arr[r] - arr[mid] == (r - mid)) {
                r = mid-1;
            }
        }
        if (list.isEmpty()) {
            list.add(-1);
            list.add(-1);
        } else {
            list.add(count);
        }
        return list;
    }

    public static void main(String[] args) {
        //int[] arr = new int[] {2,3,4,5,5};
        //int[] arr = new int[] {1,1,1,2,3,4,5,6,7,8,9};
        //int[] arr = new int[] {1,2,3,3,4};
        //int[] arr = {1,2,3}
        int[] arr = {1,2,3,3,4};
        System.out.println(findDuplicateNumbers(arr));
     }
}
