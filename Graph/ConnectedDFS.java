package com.logicmojo.Graph;

import java.util.ArrayList;

public class ConnectedDFS {

    public ArrayList<Integer> connectedDfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                rec(adj, list, visited, i);
            }
        }
        return list;

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
