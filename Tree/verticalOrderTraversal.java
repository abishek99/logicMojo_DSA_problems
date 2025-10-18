package com.logicmojo.Tree;


import java.util.*;

public class verticalOrderTraversal {

    static class Pair {
        int row;
        int val;

        Pair(int r, int v) {
            row = r;
            val = v;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        // TreeMap to store HD -> List of Pair(row, value)
        TreeMap<Integer, List<Pair>> verticalMap = new TreeMap<>();
        Queue<Object[]> q = new ArrayDeque<>(); // Queue stores {node, HD, row}

        q.offer(new Object[]{root, 0, 0}); // root has HD=0, row=0

        while (!q.isEmpty()) {
            Object[] curr = q.poll();
            TreeNode node = (TreeNode) curr[0];
            int hd = (int) curr[1];
            int row = (int) curr[2];

            verticalMap.computeIfAbsent(hd, k -> new ArrayList<>()).add(new Pair(row, node.data));

            if (node.left != null) q.offer(new Object[]{node.left, hd - 1, row + 1});
            if (node.right != null) q.offer(new Object[]{node.right, hd + 1, row + 1});
        }

        // Sort each vertical column by row
        for (List<Pair> list : verticalMap.values()) {
            list.sort(Comparator.comparingInt(p -> p.row));
            List<Integer> col = new ArrayList<>();
            for (Pair p : list) col.add(p.val);
            res.add(col);
        }
        return res;
    }


}
