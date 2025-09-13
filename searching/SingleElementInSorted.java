package com.logicmojo.searching;

import java.util.Arrays;
import java.util.List;

public class SingleElementInSorted {


    public static int findSingleSortedArray(List<Integer> arr) {
        int l = 0;
        int r = arr.size()-1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (mid > 0 &&
                    (arr.get(mid-1).equals(arr.get(mid)))) {
                if ((mid - l) % 2 == 0) {
                    r = mid - 2;
                } else {
                    l = mid + 1;
                }
            } else if (mid < arr.size()-1 && arr.get(mid).equals(arr.get(mid+1))) {
                if ((r - mid) % 2 == 0) {
                    l = mid + 2;
                } else {
                    r = mid - 1;
                }
            } else {
                return arr.get(mid);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findSingleSortedArray(Arrays.asList(2,3,3,4,4,5,5,6,6)));
        System.out.println(findSingleSortedArray(Arrays.asList(3,3,7,7,10,11,11)));
        System.out.println(findSingleSortedArray(Arrays.asList(2,2,3,3,4,5,5)));
    }
}
