package com.logicmojo.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ShortstPathWeightedDirWithSrc {

    public class Node {
        int edge;
        int weight;

        Node(int edge, int weight) {
            this.edge = edge;
            this.weight = weight;
        }
    }

    public List<Integer> shortestPathWeightedDirected(int V, int E, int[][] edges) {
        List<List<Node>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(new Node(edge[1], edge[2]));
        }
        List<Integer> path = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            path.add(i, Integer.MAX_VALUE);
        }
        path.set(0, 0);
        int[] topoOrder = topologicalOrder(adjList, V);
        for (int i = 0; i < topoOrder.length; i++) {
            int currNode = topoOrder[i];
            if (path.get(currNode) == Integer.MAX_VALUE) continue;
            for (Node neighbour : adjList.get(currNode)) {
                int neighbourDist = path.get(neighbour.edge);
                int newDist = path.get(currNode) + neighbour.weight;
                if (newDist < neighbourDist) {
                    path.set(neighbour.edge, newDist);
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


    private int[] topologicalOrder(List<List<Node>> adjList, int V) {
        int[] inDegree = new int[V];
        int[] output = new int[V];
        for (int i = 0; i < V; i++) {
            for (Node n : adjList.get(i)) {
                inDegree[n.edge]++;
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        int i = 0;
        while (!q.isEmpty()) {
            int currNode = q.poll();
            output[i++] = currNode;
            for (Node neighbour : adjList.get(currNode)) {
                inDegree[neighbour.edge]--;
                if (inDegree[neighbour.edge] == 0) {
                    q.offer(neighbour.edge);
                }
            }
        }
        return output;
    }
}
