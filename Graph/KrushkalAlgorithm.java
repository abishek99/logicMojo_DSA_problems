package com.logicmojo.Graph;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KrushkalAlgorithm {

    int kruskalsMST(int V, int[][] edges) {
        // code here
        int parent[] = new int[V];
        int rank[] = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            pq.offer(new Node(u, v, w));
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            Node n = pq.poll();
            int l1 = findParent(parent, n.src);
            int l2 = findParent(parent, n.dest);
            if (l1 != l2) {
                unionRank(l1, l2, parent, rank);
                sum += n.weight;
            }
        }
        return sum;
    }

    private void unionRank(int l1, int l2, int[] parent, int[] rank) {
        if (rank[l1] > rank[l2]) {
            parent[l2] = l1;
        } else if (rank[l2] > rank[l1]) {
            parent[l1] = l2;
        } else {
            parent[l2] = l1;
            rank[l1]++;
        }
    }

    private int findParent(int[] parent, int node) {
        if (node != parent[node]) {
            parent[node] = findParent(parent, parent[node]);
        }
        return parent[node];
    }


    class Node {
        int src;
        int dest;
        int weight;

        Node(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

}
