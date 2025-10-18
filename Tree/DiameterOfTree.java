package com.logicmojo.Tree;

public class DiameterOfTree {

    static int diameter = 0;

    public static int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = diameter(root.left);
        int rightHeight = diameter(root.right);
        diameter = Math.max(diameter, leftHeight + rightHeight + 1);
        return Math.max(leftHeight, rightHeight)+1;
    }
}
