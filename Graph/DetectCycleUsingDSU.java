package com.logicmojo.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class DetectCycleUsingDSU {
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;   // each node is parent of itself
            rank[i] = 0;
        }
        for (int i=0; i<V;i++) {
            for (int nei : adj.get(i)) {
                if (i < nei) {
                    int pu = find(i, parent);
                    int pv = find(nei, parent);
                    if (pu == pv) {
                        return 1;
                    }
                    // merge the sets
                    union(rank, parent, pu, pv);
                }

            }
        }
        return 0;
    }

    int find (int node, int[] parent) {
        if (parent[node] != node) {
            parent[node] = find (parent[node], parent);
        }
        return parent[node];
    }

    void union(int[] rank,int[] parent,  int l1, int l2) {
        if (rank[l2] > rank[l1]) {
            parent[l1] = l2;
        }
        else if (rank[l1] > rank[l2]) {
            parent[l2] = l1;
        } else {
            parent[l2] = l1;
            rank[l1]++;
        }
    }
}
