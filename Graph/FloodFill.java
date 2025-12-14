package com.logicmojo.Graph;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][]ans = image;
        int[] delRow = {0, 0, 1, -1};
        int[] delCol = {1, -1, 0, 0};
        int inclr = image[sr][sc];
        dfs(image, ans, delRow, delCol, inclr, color, sr, sc);
        return ans;
    }


    private void dfs(int[][] image, int[][] ans, int[] delRow, int[] delCol,
                     int inclr, int color, int row, int col) {
        ans[row][col] = color;
        int r = image.length;
        int c = image[0].length;
        for (int i=0; i<4; i++) {
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];
            if (newRow >=0 && newCol >=0 && newRow <r && newCol < c &&
                    image[newRow][newCol] == inclr && ans[newRow][newCol] != color) {
                dfs(image, ans, delRow, delCol, inclr, color, newRow, newCol);
            }
        }
    }
}
