package com.logicmojo.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTree {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return new ArrayList<>() {{add(0);}};
        }
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        int []inDegree = new int[n];
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
            inDegree[u]++;
            inDegree[v]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i<inDegree.length; i++) {
            if(inDegree[i] == 1) {
                q.offer(i);
            }
        }
        int sizeNode = n;
        while(sizeNode > 2) {
            int size = q.size();
            sizeNode = sizeNode - size;
            for (int i = 0 ; i < size; i++) {
                int curr = q.poll();
                for (int neighbour : adjList.get(curr)) {
                    inDegree[neighbour]--;
                    if (inDegree[neighbour] == 1) {
                        q.offer(neighbour);
                    }
                }
            }
        }
        return new ArrayList<>(q);
    }
}
