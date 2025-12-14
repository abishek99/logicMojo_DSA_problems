package com.logicmojo.dp;

import java.util.Arrays;

public class HouseRobber {

    public int houseRobber(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        return houseRobberMem(nums, 0, dp);
    }

    public int houseRobberMem(int[] nums, int n, int[] dp) {
        if (n >= nums.length) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int skipNext = nums[n] + houseRobberMem(nums, n + 2, dp);
        int skip = houseRobberMem(nums, n + 1, dp);
        dp[n] = Math.max(skipNext, skip);
        return dp[n];
    }
}
