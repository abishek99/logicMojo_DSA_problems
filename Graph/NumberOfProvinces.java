package com.logicmojo.Graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i<isConnected.length; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i=0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for (int i= 0; i< isConnected.length; i++) {
            if (!visited[i]) {
                dfs(adjList, i, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(List<List<Integer>> adjList, int src, boolean[] visited) {
        visited[src] = true;
        for (int i  : adjList.get(src)) {
            if(!visited[i]) {
                dfs(adjList, i, visited);
            }
        }
    }
}
