package com.logicmojo.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> subList = new ArrayList<>();
            int size = q.size();
            for (int i=0; i<size; i++) {
                TreeNode node = q.poll();
                subList.add(node.data);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            list.add(subList);
        }
        return list;
    }

    public static List<List<Integer>> recApproach(TreeNode root, int level, List<List<Integer>> list) {
        if (root == null) {
            return list;
        }
        if (list.size() == level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.data);
        recApproach(root.left, level+1, list);
        recApproach(root.right, level+1, list);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(19);
        root.left = new TreeNode(10);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.right = new TreeNode(13);
        System.out.println(levelOrderTraversal(root));

    }

}
