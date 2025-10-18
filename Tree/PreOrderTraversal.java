package com.logicmojo.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class PreOrderTraversal {


    public static List<Integer> preOrderTraversal(TreeNode root) {
      return recTraversal(root, new ArrayList<>());
    }

    public static List<Integer> recTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        list.add(root.data);
        recTraversal(root.left, list);
        recTraversal(root.right, list);
        return list;
    }

    public static List<Integer> iterativeApproach(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        ArrayDeque<TreeNode> st = new ArrayDeque<>();
        TreeNode curr = root;
        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                list.add(curr.data);
                st.push(curr);
                curr = curr.left;
            }
            TreeNode peekNode = st.pop();
            if(peekNode.right != null) {
                curr = peekNode.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(19);
        root.left = new TreeNode(10);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.right = new TreeNode(13);
        List<Integer> result = iterativeApproach(root);

        for (Integer level : result) {
            System.out.print(level+ " ");
        }
    }
}
