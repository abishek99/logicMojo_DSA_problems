package com.logicmojo.Graph;



import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {

    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int []rowInd = {0,0,1,-1};
        int []colInd = {1,-1, 0,0};
        Queue<int[]> q = new ArrayDeque<>();
        for (int i=0; i<r; i++) {
            for (int j=0 ;j<c; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] ind = q.poll();
            int m = ind[0];
            int n = ind[1];
            for (int i = 0; i < rowInd.length; i++) {
                int nextRow = rowInd[i] + m;
                int nextCol = colInd[i] + n;
                if (isSafe(grid, nextRow, nextCol)) {
                    q.offer(new int[] {nextRow, nextCol});
                    grid[nextRow][nextCol] = grid[m][n] + 1;
                }
            }
        }
        int maxMinutes = 2;
        for (int i= 0; i < r ;i++) {
            for (int j= 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
                maxMinutes = Math.max(maxMinutes, grid[i][j]);
            }
        }
        return maxMinutes - 2;
    }

    private boolean isSafe(int[][] grid, int row, int col) {
        return row >= 0 && col >=0 && row < grid.length && col < grid[0].length &&
                grid[row][col] == 1;
    }
}
