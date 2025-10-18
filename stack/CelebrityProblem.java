package com.logicmojo.stack;

import java.util.ArrayDeque;

public class CelebrityProblem {

    public static int findCelebrity(int[][] mat) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int n = mat.length;
        for(int i=0; i<n;i++) {
            st.push(i);
        }
        while (st.size() > 1) {
            int first = st.pop();
            int second = st.pop();
            if (mat[first][second] == 1 && mat[second][first] == 0) {
                st.push(second);
            }
            if (mat[second][first] == 1 && mat[first][second] == 0) {
                st.push(first);
            }
        }
        if (!st.isEmpty()) {
            int celeb = st.pop();
            for (int i=0; i < n; i++) {
                if (i != celeb && mat[celeb][i] != 0) {
                    return -1;
                }
            }
            for (int[] j : mat) {
                if (j[celeb] != 1) {
                    return -1;
                }
            }
            return celeb;
        }
        return -1;
    }

    public static int twoPointerCelebrity(int[][] mat) {
        int l = 0;
        int r = mat.length-1;
        while (l < r) {
            if (mat[l][r] == 1 && mat[r][l] == 0) {
                l++;
            }
            if (mat[r][l] == 1 && mat[l][r] == 0) {
                r--;
            } else {
                l++;
                r--;
            }
        }
        if (l == r) {
            for (int i=0; i < mat.length; i++) {
                if (i != l && mat[l][i] != 0) {
                    return -1;
                }
            }
            for (int[] j : mat) {
                if (j[l] != 1) {
                    return -1;
                }
            }
            return l;
        }
        return -1;
    }

}
