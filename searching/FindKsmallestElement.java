package com.logicmojo.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKsmallestElement {

    private static int kSmallestEle(int k, List<Integer> nums1, List<Integer> nums2) {
        int i = 0;
        int j = 0;
        int index = 0;
        int val = 0;
        while (i <= nums1.size()-1 && j <= nums2.size()-1) {
            if (nums1.get(i) <= nums2.get(j)) {
                val = nums1.get(i);
                i++;
            } else {
                val = nums2.get(j);
                j++;
            }
            index++;
        }
        while (index < k && i <= nums1.size() - 1) {
            val = nums1.get(i);
            i++;
        }
        while (index < k && j <= nums2.size() - 1) {
            val = nums2.get(j);
            j++;

        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(kSmallestEle(3, Arrays.asList(2,7,9,10), Arrays.asList(5,6,11)));
    }

}
