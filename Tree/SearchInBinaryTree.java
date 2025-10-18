package com.logicmojo.Tree;

public class SearchInBinaryTree {

    public static boolean searchInBST(TreeNode root, int x){
        if (root == null) {
            return false;
        }
        if (root.data == x) {
            return true;
        }
        if (root.data < x) {
            return searchInBST(root.left, x);
        } else {
            return searchInBST(root.right, x);
        }
    }

    public static boolean iterativeBST(TreeNode root, int x) {
        if (root == null) {
            return false;
        }
        TreeNode curr = root;
        while (curr != null) {
            if (curr.data == x) {
                return true;
            } else {
                if (curr.data < x) {
                    curr = curr.left;
                } else {
                   curr = curr.left;
                }
            }
        }
        return false;
    }

}
