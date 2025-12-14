package com.logicmojo.Graph;

import java.util.*;

public class TopologicalSort {

    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> list = new ArrayList<>();
        for (int i=0; i<V; i++) {
            list.add(new ArrayList<>());
        }
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            list.get(u).add(v);
        }
        // store the indegree count in arr
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int num : list.get(i)) {
                inDegree[num]++;
            }
        }
        // get the o indegree for processing
        Queue<Integer> q = new ArrayDeque<>();
        for (int i=0; i<inDegree.length;i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        //process the neighbours and decrease the indegree count
        ArrayList<Integer> output = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            output.add(curr);
            for (int neighbour : list.get(curr)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    q.offer(neighbour);
                }
            }
        }

        //return the output
        return output;
    }


    public ArrayList<Integer> topoSortDfs(int V, int[][] edges) {
        // code here
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<>());
        }
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            list.get(u).add(v);
        }
        boolean[] visited = new boolean[V];
        ArrayDeque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < list.size(); i++) {
            if (!visited[i]) {
                dfsHelper(list, i, visited, st);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!st.isEmpty()) {
            ans.add(st.pop());
        }
        return ans;
    }

    private void dfsHelper(List<List<Integer>> adj, int curr, boolean[] visited, ArrayDeque<Integer> st) {
        visited[curr] = true;
        for (int i : adj.get(curr)) {
            if (!visited[i]) {
                dfsHelper(adj, i, visited, st);
            }
        }
        st.push(curr);
    }
}
