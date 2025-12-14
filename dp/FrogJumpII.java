package com.logicmojo.dp;

public class FrogJumpII {

    public int maxJump(int[] stones) {
        int n = stones.length;
        int ans = 0;
        if (n == 2) {
            return Math.abs(stones[1] - stones[0]);
        }
        int i = 2;
        while (i < n) {
            ans = Math.max(ans, Math.abs(stones[i] - stones[i-2]));
            i++;
        }
        System.gc();
        return ans;
    }
}
