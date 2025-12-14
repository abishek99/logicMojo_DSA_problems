package com.logicmojo.Graph;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0 ;i<graph.length; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int u = 0; u < graph.length; u++) {
            for (int v : graph[u]) {
                adjList.get(u).add(v);
            }
        }
        boolean []visited = new boolean[graph.length];
        boolean []path = new boolean[graph.length];
        boolean []safeNode = new boolean[graph.length];
        for (int i = 0 ;i < graph.length; i++) {
            if (!visited[i]) {
                dfs(adjList, path, visited, safeNode, i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0 ; i < safeNode.length; i++) {
            if (safeNode[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean dfs(List<List<Integer>> adjList, boolean[] path,
                        boolean[] visited, boolean[] safeNode, int currNode) {
        visited[currNode] = true;
        path[currNode] = true;
        for (int nei : adjList.get(currNode)) {
            if (!visited[nei]) {
                if (dfs(adjList, path, visited, safeNode, nei)) {
                    return true;
                }
            } else if (path[nei]) {
                return true;
            }
        }
        path[currNode] = false;
        safeNode[currNode] = true;
        return false;
    }
}
