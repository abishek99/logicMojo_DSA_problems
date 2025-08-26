package com.logicmojo.arrays;

import java.util.HashMap;
import java.util.Map;

public class FindOddOccurrence {

    // XOR approach
    public static int findOddOccurrence(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum ^= num;
        }
        return sum;
    }


    //map approach
    public static int findOccurrenceMapApproach(int n, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i])+1);
            } else {
                map.put(arr[i], 1);
            }
        }
        for (int num : map.keySet()) {
            if (map.get(num) % 2 != 0) {
                return num;
            }
        }
        return -1;
    }
}
