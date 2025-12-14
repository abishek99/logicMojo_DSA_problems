package com.logicmojo.Tree;

public class FlatternBST {

    public void flatten(TreeNode root) {
        root = flattenRec(root);
    }

    private TreeNode flattenRec(TreeNode root) {
        if(root == null) {
            return root;
        }
        TreeNode left = flattenRec(root.left);
        TreeNode right = flattenRec(root.right);
        if (root.left != null) {
            if (left != null) {
                left.right = root.right;
            }
            root.right = root.left;
            root.left = null;
        }
        if (right != null) {
            return right;
        }
        if (left != null) {
            return left;
        }
        return root;
    }
}
