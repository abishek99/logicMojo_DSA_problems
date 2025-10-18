package com.logicmojo.Tree;



public class BalancedBinaryTree {

    public static boolean balancedTree(TreeNode root) {
        return maxHeight(root) != -1;
    }

    public static int maxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxHeight(root.left);

        int rightHeight = maxHeight(root.right);

        return leftHeight == -1 || rightHeight == -1 ||
                Math.abs(leftHeight - rightHeight) > 1 ? -1 :
                Math.max(leftHeight,rightHeight) + 1 ;
    }
}
