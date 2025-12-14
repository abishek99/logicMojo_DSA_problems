package com.logicmojo.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] preReq : prerequisites) {
            int u = preReq[0];
            int v = preReq[1];
            adj.get(v).add(u);
        }
        int[] inDegree = new int[numCourses];
        for (int i= 0; i<numCourses;i++) {
            for (int neighbour : adj.get(i)) {
                inDegree[neighbour]++;
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i=0; i<inDegree.length;i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        int[] output = new int[numCourses];
        int i = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            output[i++] = curr;
            for (int neighbour : adj.get(curr)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    q.offer(neighbour);
                }
            }
        }
        return i == numCourses ? output : new int[0] ;
    }
}
