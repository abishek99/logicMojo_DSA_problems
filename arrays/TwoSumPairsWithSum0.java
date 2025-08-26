package com.logicmojo.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoSumPairsWithSum0 {

    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        Arrays.sort(arr);
        int l = 0, r = arr.length - 1;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        while (l < r) {
            if (arr[l] + arr[r] == 0) {
                ArrayList<Integer> subList = new ArrayList<>();
                subList.add(arr[l]);
                subList.add(arr[r]);
                list.add(subList);
                int left = arr[l];
                int right = arr[r];
                while (l < r && arr[l] == left) {
                    l++;
                }
                while (l < r && arr[r] == right) {
                    r--;
                }
            } else if (arr[l] + arr[r] > 0) {
                r--;
            } else {
                l++;
            }
        }
        return list;
    }
}
