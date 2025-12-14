package com.logicmojo.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFordAlgorithm {

    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] output = new int[V];
        Arrays.fill(output, Integer.MAX_VALUE);
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i=0; i<V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adjList.get(u).add(new Pair(v, weight));
        }
        output[src] = 0;
        for (int i=0; i<V-1; i++) {
            for(int j=0; j<V; j++) {
                for (Pair nei : adjList.get(j)) {
                    if (output[j] != Integer.MAX_VALUE &&
                            output[j] + nei.weight < output[nei.edge]) {
                        output[nei.edge] =  nei.weight + output[j];
                    }
                }
            }
        }

            for(int j=0; j<V; j++) {
                for (Pair nei : adjList.get(j)) {
                    if (output[j] != Integer.MAX_VALUE &&
                            output[j] + nei.weight < output[nei.edge]) {
                        Arrays.fill(output, -1);
                        return output;
                    }
                }
            }

        for (int i = 0; i < V; i++) {
            if (output[i] == Integer.MAX_VALUE)
                output[i] = 100000000;
        }

        return output;
    }

    class Pair {
        int edge;
        int weight;
        Pair(int edge, int weight) {
            this.edge = edge;
            this.weight = weight;
        }
    }
}
