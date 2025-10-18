package com.logicmojo.Tree;

import java.util.ArrayDeque;

public class SameTree {


    public static boolean sameTree(TreeNode p, TreeNode q) {
        TreeNode curr1 = p;
        TreeNode curr2 = q;
        ArrayDeque<TreeNode> st1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> st2 = new ArrayDeque<>();
        while ((curr1 != null && curr2 != null) ||
                (!st1.isEmpty() && !st2.isEmpty())) {
            while (curr1 != null && curr2 != null) {
                if (curr1.data != curr2.data) {
                    return false;
                }
                //p tree
                st1.push(curr1);
                curr1 = curr1.left;
                //q tree
                st2.push(curr2);
                curr2 = curr2.left;
            }
            if (curr1 != null || curr2 != null) {
                return false;
            }
            curr1 = st1.pop().right;
            curr2 = st2.pop().right;
        }
        return (curr1 == null && curr2 == null) && (st1.isEmpty() && st2.isEmpty());
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        System.out.println(sameTree(root1, root2));
    }
}
