package com.logicmojo.Graph;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleI {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] preReq : prerequisites) {
            int u = preReq[0];
            int v = preReq[1];
            adj.get(u).add(v);
        }
        boolean []vis = new boolean[numCourses];
        boolean []rec = new boolean[numCourses];
        for (int i=0; i<adj.size(); i++) {
            if(!vis[i]) {
                if (isCyclicRec(adj, vis, rec, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCyclicRec(List<List<Integer>> adj, boolean[] vis,
                                boolean[] rec, int curr) {
        vis[curr] = true;
        rec[curr] = true;
        for (int neighbour : adj.get(curr)) {
            if (!vis[neighbour]) {
                if (isCyclicRec(adj, vis, rec, neighbour)) {
                    return true;
                }
            } else if (rec[neighbour]) {
                return true;
            }
        }
        rec[curr] = false;
        return false;
    }
}
