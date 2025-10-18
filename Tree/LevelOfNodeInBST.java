package com.logicmojo.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOfNodeInBST {

    public static int getLevel(TreeNode root, int key) {
        int level = 0;
        if (root == null) {
            return level;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            for (int i=0; i<size; i++) {
                TreeNode node = q.poll();
                if (node.data == key) {
                    return level;
                }
                if (node.left != null) {
                   q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return 0;
    }
}
