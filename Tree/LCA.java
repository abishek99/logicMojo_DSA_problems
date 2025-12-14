package com.logicmojo.Tree;

public class LCA {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return rec(root, p, q);
    }

    private TreeNode rec(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode leftAnc = rec(root.left, p , q);
        TreeNode rightAnc = rec(root.right, p , q);
        if(leftAnc != null && rightAnc != null) {
            return root;
        }
        if (leftAnc!=null) {
            return leftAnc;
        }
        return rightAnc;
    }
}
