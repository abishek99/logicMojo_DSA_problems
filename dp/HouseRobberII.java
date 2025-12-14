package com.logicmojo.dp;

import java.util.Arrays;

public class HouseRobberII {


    public int houseRobberII(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return  Math.max(nums[0],nums[1]);
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int[] dp1 = new int[nums.length];
        Arrays.fill(dp1, -1);
        int withFirstHouse = houseRobberIIRec(nums, 0, dp, nums.length-1);
        int withoutFirstHouse = houseRobberIIRec(nums, 1, dp1, nums.length);
        return Math.max(withoutFirstHouse, withFirstHouse);
    }

    int houseRobberIIRec(int[] nums, int n, int[] dp, int len) {
        if (n >= len) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int skipNext = nums[n] + houseRobberIIRec(nums, n + 2, dp, len);
        int skip = houseRobberIIRec(nums, n + 1, dp, len);
        dp[n] = Math.max(skipNext, skip);
        return dp[n];
    }
}
