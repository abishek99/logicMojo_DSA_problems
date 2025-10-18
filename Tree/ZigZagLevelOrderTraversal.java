package com.logicmojo.Tree;

import java.util.*;

public class ZigZagLevelOrderTraversal {

    public static List<List<Integer>> zigZag(TreeNode root) {
        List<List<Integer>> bsf = new ArrayList<>();
        if (root == null) {
            return bsf;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean pright = true;
        while (!q.isEmpty()) {
            int size = q.size();
            Deque<Integer> list = new ArrayDeque<>();
            for (int i=0; i < size; i++) {
                TreeNode temp = q.poll();
                if (pright) {
                    list.addLast(temp.data);
                } else {
                    list.addFirst(temp.data);
                }
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
            bsf.add(new ArrayList<>(list));
            pright = !pright;
        }
        return bsf;
    }
}
