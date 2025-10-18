package com.logicmojo.Tree;

import java.util.ArrayList;
import java.util.List;

public class RightViewBST {

    public static List<Integer> rightView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        } else {
            return rightProcess(root, new ArrayList<>(), 0);
        }
    }

    public static List<Integer> rightProcess(TreeNode root, List<Integer> list, int level) {
        if(root == null){
            return list;
        }
        if(list.size() == level) {
            list.add(root.data);
        }
        rightProcess(root.right, list, level+1);
        rightProcess(root.left, list, level+1);
        return list;
    }
}
