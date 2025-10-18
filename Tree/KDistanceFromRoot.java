package com.logicmojo.Tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class KDistanceFromRoot {

    public static ArrayList<Integer> kdistanceFromRoot(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int n = 0;
        while (!q.isEmpty() && n!=k) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            n++;
        }
        int size = q.size();
        for (int i=0; i<size; i++) {
            TreeNode node = q.poll();
            list.add(node.data);
        }
        return list;
    }

   public static  ArrayList<Integer> recKDistanceFromRoot(TreeNode root, int k, int n,ArrayList<Integer> list) {
        if (root == null) {
            return list;
        }
        if (n == k) {
            list.add(root.data);
            return list;
        }
        recKDistanceFromRoot(root.left, k , n+1, list);
        recKDistanceFromRoot(root.right, k , n+1, list);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(recKDistanceFromRoot(root, 2, 0, new ArrayList<>()));
    }

}
