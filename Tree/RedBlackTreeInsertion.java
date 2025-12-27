package com.logicmojo.Tree;

import com.sun.source.tree.Tree;

public class RedBlackTreeInsertion {

    private static final boolean RED = true;
    private static final boolean BLACK = false;


    public class TreeNode{
        int val;
        boolean color;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        TreeNode (int val) {
            color = RED;
            this.val = val;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    private TreeNode root;

    public void insertData(int val) {
        TreeNode node  = new TreeNode(val);
        root = insertBst(root, node);
        fixInsertion(node);
    }

    private TreeNode insertBst(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        if (root.val > node.val) {
            root.left = insertBst(root.left, node);
            root.left.parent = root;
        } else if (root.val < node.val) {
            root.right = insertBst(root.right, node);
            root.right.parent = root;
        }
        return root;
    }

    private void fixInsertion(TreeNode node) {
        while (node != null && node.parent.color == RED) {
            TreeNode parent  = node.parent;
            TreeNode grandParent = parent.parent;
            if (parent == grandParent.left) {
                TreeNode uncle = grandParent.right;
                if (uncle != null && uncle.color == RED) {
                    grandParent.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    node = grandParent;
                } else {
                    //this is LR case so we need to rotate left
                    if (parent.right == node) {
                        leftRotation(parent);
                        node = parent;
                        parent = node.parent;
                    }
                    // else single right rotation is required to fix violation
                    rightRotation(grandParent);
                    grandParent.color = RED;
                    parent.color = BLACK;
                    node = parent;
                }
            } else {
                TreeNode uncle = grandParent.left;
                if (uncle != null && uncle.color == RED) {
                    grandParent.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    node = grandParent;
                } else {
                    // this RL case need right rotation first
                    if (parent.left == node) {
                        rightRotation(parent);
                        node = parent;
                        parent = node.parent;
                    }
                    // else single left rotation is required to fix violation
                    leftRotation(grandParent);
                    grandParent.color = RED;
                    parent.color = BLACK;
                    node = parent;
                }
            }
        }
        root.color = BLACK;
    }

    private void leftRotation(TreeNode y) {
        TreeNode x  = y.right;
        TreeNode xLeft = x.left;
        x.left = y;
        y.right = xLeft;

        if (xLeft != null) {
            xLeft.parent = y;
        }
        // now x is the root connect xparent to y parent
        x.parent = y.parent;
        if (y.parent == null) {
            root = x;
        } else if (y == y.parent.left) {
            y.parent.left = x;
        } else if (y == y.parent.right) {
            y.parent.right = x;
        }
        // now update the y has a parent update x as parent
        y.parent  = x;

    }

    private void rightRotation(TreeNode y) {
        TreeNode x  = y.left;
        TreeNode xRight = x.right;
        x.right = y;
        y.left = xRight;


        if (xRight != null) {
            xRight.parent = y;
        }
        // now x is the root connect xparent to y parent
        x.parent = y.parent;

        if (y.parent == null) {
            root = x;
        } else if (y == y.parent.left) {
            y.parent.left = x;
        } else if (y == y.parent.right) {
            y.parent.right = x;
        }

        // now update the y has a parent update x as parent
        y.parent  = x;
    }
}
