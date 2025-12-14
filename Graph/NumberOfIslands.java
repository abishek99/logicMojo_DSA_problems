package com.logicmojo.Graph;

public class NumberOfIslands {

    public int getNumberOfIsland(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    rec(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void rec(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length ||
                j >= grid[i].length || grid[i][j] != '1' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        rec(grid, visited, i-1, j);
        rec(grid, visited, i+1, j);
        rec(grid, visited, i, j-1);
        rec(grid, visited, i, j+1);
    }
}
