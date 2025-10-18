package com.logicmojo.Tree;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class PostOrderTraversal {

    public static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        ArrayDeque<TreeNode> st = new ArrayDeque<>();
        TreeNode curr = root;
        TreeNode lastVisited = null;
        while (curr!= null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            TreeNode peakNode = st.peek();
            if (peakNode.right != null && lastVisited != peakNode.right) {
                curr = peakNode.right;
            } else {
                st.pop();
                list.add(peakNode.data);
                lastVisited = peakNode;
            }
        }
        return list;
    }

    public static List<Integer> recPostOrderTraversal(List<Integer> list, TreeNode node) {
        if (node == null) {
            return list;
        }
        recPostOrderTraversal(list,node.left);
        recPostOrderTraversal(list,node.right);
        list.add(node.data);
        return list;
    }

}
