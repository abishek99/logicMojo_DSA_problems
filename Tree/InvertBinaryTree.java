package com.logicmojo.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class InvertBinaryTree {

    public static TreeNode invertBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i<size; i++) {
                TreeNode node = q.poll();


                TreeNode temp = node.right;
                node.right = node.left;
                node.left = temp;


                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return root;
    }
}
