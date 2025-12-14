package com.logicmojo.Graph;

import java.util.*;

public class DijkstraAlgorithmUnDir {

    public class Node {
        int edge;
        int weight;
        Node(int edge, int weight) {
            this.edge = edge;
            this.weight = weight;
        }
    }


    public int[] dijkstraAlgo(int V, int[][] edges, int src) {
        List<List<Node>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(new Node(edge[1], edge[2]));
            adjList.get(edge[1]).add(new Node(edge[0], edge[2]));
        }
        int[] path = new int[V];
        Arrays.fill(path, Integer.MAX_VALUE);
        path[src] =  0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));
        pq.add(new Node(src, 0));
        while(!pq.isEmpty()) {
            Node currNod = pq.poll();
            if (currNod.weight > path[currNod.edge]) continue;
            for (Node neighbour : adjList.get(currNod.edge)) {
                int existingDistance = path[neighbour.edge];
                int newDistance = path[currNod.edge] + neighbour.weight;
                if (newDistance < existingDistance) {
                    path[neighbour.edge] =  newDistance;
                    pq.add(new Node(neighbour.edge, newDistance));
                }
            }
        }
        return path;
    }
}
