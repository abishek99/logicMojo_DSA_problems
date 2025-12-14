package com.logicmojo.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ShortestPathWeightedUnDirSrc {

    public class Node {
        int edge;
        int weight;

        Node(int edge, int weight) {
            this.edge = edge;
            this.weight = weight;
        }
    }

    // to get the source shortest path
    public List<Integer> shortestPath(int n, int m, int[][] edges, int src) {
        List<List<Node>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(new Node(edge[1], edge[2]));
            adjList.get(edge[1]).add(new Node(edge[0], edge[2]));
        }
        List<Integer> path = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            path.add(i, Integer.MAX_VALUE);
        }
        path.set(src, 0);
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(src);
        while (!q.isEmpty()) {
            int currNode = q.poll();
            for (Node neighbour : adjList.get(currNode)) {
                int neighbourDist = path.get(neighbour.edge);
                int newDist = path.get(currNode) + neighbour.weight;
                if (newDist < neighbourDist) {
                    path.set(neighbour.edge, newDist);
                    q.offer(neighbour.edge);
                }
            }
        }
        for (int i = 0; i < path.size(); i++) {
            if (path.get(i) == Integer.MAX_VALUE) {
                path.set(i, -1);
            }
        }
        return path;
    }
}
