package com.logicmojo.greedyalgorithm;

import java.util.Arrays;

public class MinimumPlatforms {

    public int minimumPlatforms(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0;
        int j = 0;
        int minimumPlatform  = 0;
        int platform = 0;
        while (i < arr.length && j < dep.length) {
            if (arr[i] <= dep[j]) {
                i++;
                platform++;
            } else {
                j++;
                platform--;
            }
            minimumPlatform = Math.max(minimumPlatform, platform);
        }
        return minimumPlatform;
    }
}
