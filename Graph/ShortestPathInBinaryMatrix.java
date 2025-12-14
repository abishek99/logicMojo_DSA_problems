package com.logicmojo.Graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int[] row = {1, 1, 1, 0, 0, -1, -1, -1};
        int[] col = {1, 0, -1, 1, -1, 1, 0, -1};
        if (grid[0][0] == 1 || grid[grid.length-1][grid[0].length-1] == 1) return -1;
        int[][] dis = new int[grid.length][grid[0].length];
        for (int[] d : dis) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        Queue<Block> q = new ArrayDeque<>();
        if (grid[0][0] == 0) {
            dis[0][0] = 1;
            q.offer(new Block(0, 0));
        }
        while (!q.isEmpty()) {
            Block curr = q.poll();
            for (int k=0; k<8; k++) {
                int nextRow = curr.row + row[k];
                int nextCol = curr.col + col[k];
                if (isSafe(nextRow, nextCol, grid)) {
                    int currDis = dis[curr.row][curr.col] + 1;
                    int rcDis = dis[nextRow][nextCol];
                    if (currDis < rcDis) {
                        dis[nextRow][nextCol] = currDis;
                        q.offer(new Block(nextRow, nextCol));
                    }
                }
            }
        }
        int n = grid.length;
        int m = grid[0].length;
        int ans = dis[n-1][m-1];
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private boolean isSafe(int row, int col, int[][] grid) {
        return row >= 0 && col >=0 &&
                row < grid.length && col < grid[0].length && grid[row][col] == 0;
    }

    class Block {
        int row;
        int col;
        Block(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
