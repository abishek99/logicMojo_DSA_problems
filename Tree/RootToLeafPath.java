package com.logicmojo.Tree;



import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RootToLeafPath {

    public static List<List<Integer>> rootToLeafPath (TreeNode root) {
       return dfs(root, new ArrayList<>(), new ArrayList<>());
    }

    public static List<List<Integer>> dfs(TreeNode root, List<List<Integer>> list, List<Integer> temp) {
        if (root == null) {
            return list;
        }
        temp.add(root.data);
        if (root.left == null && root.right == null) {
            list.add(new ArrayList<>(temp));
        }
        dfs(root.left, list, temp);
        dfs(root.right, list, temp);
        temp.remove(temp.size() - 1);
        return list;
    }
}
