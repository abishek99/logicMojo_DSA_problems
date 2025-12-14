package com.logicmojo.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BFSUndirected {

    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        visited[0] = true;
        ArrayList<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int currNode = q.poll();
            list.add(currNode);
            for (int i=0; i<adj.get(currNode).size(); i++) {
                int neighbour = adj.get(currNode).get(i);
                if (!visited[neighbour]) {
                    q.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        return list;
    }
}
