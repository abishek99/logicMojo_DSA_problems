package com.logicmojo.Tree;

import java.util.*;

public class BottomView {

    public static List<Integer> processBottomView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<TreeNode, Integer> hdMap = new HashMap<>();
        Map<Integer, Integer> bottomViewMap = new TreeMap<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        hdMap.put(root, 0);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            int hd = hdMap.get(temp);
            bottomViewMap.put(hd, temp.data);
            if (temp.left != null) {
                q.offer(temp.left);
                hdMap.put(temp.left, hd-1);
            }
            if (temp.right != null) {
                q.offer(temp.right);
                hdMap.put(temp.right, hd+1);
            }
        }
        return new ArrayList<>(bottomViewMap.values());
    }
}
