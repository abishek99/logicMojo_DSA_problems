package com.logicmojo.Tree;



import java.util.ArrayDeque;
import java.util.Queue;

public class DeleteNodeInBinaryTree {

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        TreeNode searchNode = null;
        TreeNode lastNode = null;
        TreeNode parentOfLast = null;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                lastNode = temp;
                if (temp.data == key) {
                    searchNode = temp;
                }
                if (temp.left != null) {
                    parentOfLast = temp;
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    parentOfLast = temp;
                    q.add(temp.right);
                }
            }
        }

        if (searchNode != null) {
            searchNode.data = lastNode.data;
            if (parentOfLast!=null) {
                if (parentOfLast.right == lastNode) {
                    parentOfLast.right = null;
                } else if (parentOfLast.left == lastNode) {
                    parentOfLast.left = null;
                }
            }
        }
        return root;
    }



}
