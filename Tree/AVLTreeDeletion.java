package com.logicmojo.Tree;

import com.logicmojo.Tree.AVLTreeInsertion.TreeNode;

public class AVLTreeDeletion {

    public static TreeNode deleteTreeNode(TreeNode root, int key) {
        // code here.
        if (root == null) {
            return root;
        }
        if (root.data > key) {
            root.left = deleteTreeNode(root.left, key);
        } else if (root.data < key) {
            root.right = deleteTreeNode(root.right, key);
        } else {
            if (root.right == null) {
                return root.left;
            } else {
                TreeNode successor = root.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
                root.data = successor.data;
                root.right = deleteTreeNode(root.right, successor.data);
            }
        }
        root.height = 1 + Math.max(height(root.left), height(root.right));
        int balance = height(root.left) - height(root.right);

        //LL
        if (balance > 1 && height(root.left.left) >= height(root.left.right)) {
            return rightRotation(root);
        }

        // LR
        if (balance > 1 && height(root.left.left) < height(root.left.right)) {
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }

        //RR
        if (balance < -1 && height(root.right.right) >= height(root.right.left)) {
            return leftRotation(root);
        }

        //RL
        if (balance < -1 && height(root.right.right) < height(root.right.left)) {
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }
        return root;
    }

    private static TreeNode leftRotation(TreeNode y) {
        TreeNode x = y.right;
        TreeNode xRight = x.left;
        x.left = y;
        y.right = xRight;
        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return x;
    }

    private static TreeNode rightRotation(TreeNode y) {
        TreeNode x = y.left;
        TreeNode xRight = x.right;
        x.right = y;
        y.left = xRight;
        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return x;
    }

    private static int height(TreeNode root) {
        return root == null ? 0 : root.height;
    }
}
