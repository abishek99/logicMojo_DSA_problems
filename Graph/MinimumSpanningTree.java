package com.logicmojo.Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpanningTree {

    public int spanningTree(int V, int[][] edges) {
        // code here
        List<List<Node>> adjList = new ArrayList<>();
        for (int i=0; i<V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adjList.get(u).add(new Node(v, weight));
            adjList.get(v).add(new Node(u, weight));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));
        pq.offer(new Node(0,0));
        int ans = 0;
        int count = 0;
        boolean[] visited = new boolean[V];
        while(!pq.isEmpty()) {
            Node n = pq.poll();
            if (visited[n.edge]) {
                continue;
            }
            visited[n.edge] = true;
            count++;
            ans+=n.weight;
            for (Node nei : adjList.get(n.edge)) {
                if (!visited[nei.edge]) {
                    pq.offer(nei);
                }
            }
            if (count == V) {
                break;
            }
        }
        return ans;

    }

    class Node {
        int edge;
        int weight;
        Node (int edge, int weight) {
            this.edge = edge;
            this.weight = weight;
        }
    }
}
