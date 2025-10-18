package com.logicmojo.Tree;

import com.sun.source.tree.Tree;

public class InsertInBinaryTree {

    public static TreeNode insertInBST(TreeNode root, int x) {
        if (root == null) {
            return new TreeNode(x);
        }
        if (root.data > x) {
            root = insertInBST(root.left, x);
        } else {
            root = insertInBST(root.right, x);
        }
        return root;
    }

    public static TreeNode iterativeInBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode curr = root;
        while (curr != null) {
            if (curr.data > val) {
                if (curr.left == null) {
                    curr.left = new TreeNode(val);
                    return root;
                }
                curr = curr.left;
            } else {
                if (curr.right == null) {
                    curr.right = new TreeNode(val);
                    return root;
                }
                curr = curr.right;
            }
        }
        return root;
    }
}
