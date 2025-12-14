package com.logicmojo.dp;

public class FibonacciDP {

    public int fibonaciMemorization(int i, int[] dp) {
        if (i <= 1) {
            return i;
        }
        if (dp[i]!=-1) {
            return dp[i];
        }
        dp[i] = fibonaciMemorization(i-1, dp) + fibonaciMemorization(i-2, dp);
        return dp[i];
    }

    public int fibonaciTabulation(int i) {
        int[] dp = new int[i+1];
        dp[0] = 0;
        dp[1] = 1;
        if (i == 0 || i == 1) {
            return dp[i];
        }
        for (int j=2; j<=i;j++) {
            dp[j] = dp[j-1] + dp[j-1];
        }
        return dp[i];
    }


}
