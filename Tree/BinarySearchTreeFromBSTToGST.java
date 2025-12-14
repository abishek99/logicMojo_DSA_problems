package com.logicmojo.Tree;

public class BinarySearchTreeFromBSTToGST {

   public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }

    }


    public TreeNode bstToGst(TreeNode root) {
        return(rec(root));
    }

    int sum = 0;
    private TreeNode rec(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = rec(root.right);
        sum+=root.val;
        TreeNode newTree = new TreeNode(sum);
        TreeNode left = rec(root.left);
        newTree.right = right;
        newTree.left = left;
        return newTree;
    }
}
