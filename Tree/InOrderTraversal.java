package com.logicmojo.Tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {

    public static List<Integer> inOrderTraversal(TreeNode root) {
       List<Integer> list = new ArrayList<>();
       ArrayDeque<TreeNode> st = new ArrayDeque<>();
       TreeNode curr = root;
       while (curr != null || !st.isEmpty()) {
           while (curr != null) {
               st.push(curr);
               curr = curr.left;
           }
           TreeNode peakNode = st.pop();
           list.add(peakNode.data);
           if (peakNode.right != null) {
               curr = peakNode.right;
           }
       }
       return list;

    }

    public static List<Integer> recApproach(TreeNode root, List<Integer> list) {
        if (root == null) {
           return list;
        }
        recApproach(root.left, list);
        list.add(root.data);
        recApproach(root.right, list);
        return list;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(19);
        root.left = new TreeNode(10);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.right = new TreeNode(13);
        List<Integer> result = inOrderTraversal(root);
        for (Integer level : result) {
            System.out.print(level+ " ");
        }
    }
}
