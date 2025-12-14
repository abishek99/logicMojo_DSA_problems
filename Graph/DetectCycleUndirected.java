package com.logicmojo.Graph;

import java.util.List;

public class DetectCycleUndirected {

    public boolean isCyclicUndirected(List<List<Integer>> adj) {
        boolean visited[] = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                if (isCyclic(adj, -1, i, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCyclic(List<List<Integer>> adj, int parent, int curr, boolean[] visited) {
        visited[curr] = true;
        for (int i : adj.get(curr)) {
            if (!visited[i]) {
                if (isCyclic(adj, curr, i, visited)) {
                    return true;
                }
            } else if (i != parent) {
                return true;
            }
        }
        return false;
    }
}
