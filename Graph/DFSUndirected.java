package com.logicmojo.Graph;

import java.util.ArrayList;

public class DFSUndirected {

    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        return rec(adj, new ArrayList<>(), new boolean[adj.size()], 0);
    }


    private ArrayList<Integer> rec(ArrayList<ArrayList<Integer>> adj,
                                   ArrayList<Integer> list, boolean visited[], int edge) {
        list.add(edge);
        visited[edge] = true;
        for (int i=0; i < adj.get(edge).size(); i++) {
            int neighbour = adj.get(edge).get(i);
            if (!visited[neighbour]) {
                rec(adj, list, visited, neighbour);
            }
        }
        return list;
    }
}
