package com.logicmojo.Tree;


import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumDepthOfTree {

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            level++;
        }
        return level;
    }

    public static int rec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int heightLeft = rec(root.left);
        int heightRight = rec(root.right);
        return Math.max(heightLeft, heightRight) + 1;
    }
}
