package com.logicmojo.Graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCyclicDirected {

    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> list = new ArrayList<>();
        for (int i=0; i<V; i++) {
            list.add(new ArrayList<>());
        }
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            list.get(u).add(v);
        }
        boolean[] visited = new boolean[V];
        boolean[] rec = new boolean[V];
        for (int i=0; i<list.size(); i++) {
            if (!visited[i]) {
                if (isCyclicRec(list, i, visited, rec)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCyclicRec(List<List<Integer>> adj, int curr, boolean[] visited, boolean[] rec) {
        visited[curr] = true;
        rec[curr] = true;
        for (int i : adj.get(curr)) {
            if (!visited[i]) {
                if (isCyclicRec(adj, i, visited, rec)) {
                    return true;
                }
            } else if (rec[i]) {
                return true;
            }
        }
        rec[curr] = false;
        return false;
    }
}
