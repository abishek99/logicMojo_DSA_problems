package com.logicmojo.Heap;

import com.logicmojo.Tree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class BSTMinHeap {

    public static TreeNode convertBST(TreeNode root) {
        // Write your code here.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            pq.offer(temp.data);
            if (temp.left != null) {
                q.offer(temp.left);
            }
            if (temp.right != null) {
                q.offer(temp.right);
            }
        }
        return preOrder(root, pq);
    }

    private static TreeNode preOrder(TreeNode root, PriorityQueue<Integer> pq) {
        if (root == null) {
            return null;
        }
        root.data = pq.poll();
        preOrder(root.left, pq);
        preOrder(root.right, pq);
        return root;
    }
}
