package com.logicmojo.dp;


import java.util.Arrays;

public class FrogJump {

    public int frogJump(int[] height) {
        int[] dp = new int[height.length];
        Arrays.fill(dp, -1);
        return frogJumpRec(height, 0, dp);
    }

    public int frogJumpRec(int[] height, int n, int[] dp) {
        if (n == height.length-1) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int oneStep = Math.abs(height[n] - height[n+1]) + frogJumpRec(height, n+1, dp);
        int twoStep = Integer.MAX_VALUE;
        if (n + 2 < height.length) {
            twoStep = Math.abs(height[n] - height[n + 2]) + frogJumpRec(height, n + 2, dp);
        }
        dp[n] = Math.min(oneStep, twoStep);
        return dp[n];
    }
}
