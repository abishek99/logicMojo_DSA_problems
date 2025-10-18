package com.logicmojo.Tree;

public class CousinsBST {

    public static boolean isSiblings(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        if (root.left != null && root.right != null) {
            return ((root.left.data == x && root.right.data == y) ||
                    (root.left.data == y && root.right.data == x));
        }
        return  isSiblings(root.left, x, y) || isSiblings(root.right, x, y);
    }

    public static boolean isCousin(TreeNode root, int x, int y) {
        int xLevel = getLevel(root, x, 0);
        int yLevel = getLevel(root, y, 0);
        return xLevel == yLevel && !isSiblings(root, x, y);
    }

    public static int getLevel(TreeNode root, int key, int level) {
        if (root == null) {
            return -1;
        }
        if (root.data == key) {
            return level;
        }
        int left = getLevel(root.left, key, level+1);
        if (left != -1) {
            return left;
        }
        return  getLevel(root.right, key, level+1);
    }
}
