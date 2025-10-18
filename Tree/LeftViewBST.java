package com.logicmojo.Tree;


import java.util.ArrayList;

public class LeftViewBST {

    public ArrayList<Integer> leftView(TreeNode root) {
        // code here
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        return leftTree(root, list, 0);
    }

    private ArrayList<Integer> leftTree(TreeNode root, ArrayList<Integer> list, int level) {
        if (root == null) {
            return list;
        }
        if (level == list.size()) {
            list.add(root.data);
        }
        leftTree(root.left, list, level+1);
        leftTree(root.right, list, level+1);
        return list;
    }
}
