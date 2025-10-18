package com.logicmojo.Tree;

import java.util.*;

public class AllNodesDistanceKBST {

    public static TreeNode findNode(TreeNode root, TreeNode target) {
        if (root == null) {
            return null;
        }
        if (root == target) {
            return root;
        }
        TreeNode left = findNode(root.left, target);
        if(left != null) {
            return left;
        }
        return findNode(root.right, target);
    }

    public static List<Integer> getAllNodesKDist(TreeNode root, TreeNode target, int k) {
        TreeNode targetInRoot = findNode(root, target);
        List<Integer> list = new ArrayList<>();
        if (targetInRoot == null) {
            return list;
        }
        int n = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        buildParent(root, null, parent);
        Set<TreeNode> visited = new HashSet<>();
        q.offer(targetInRoot);
        visited.add(targetInRoot);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if (n == k) {
                    list.add(temp.data);
                }
                if (temp.left != null && visited.add(temp.left)) {
                    q.offer(temp.left);
                }
                if (temp.right != null && visited.add(temp.right)) {
                    q.offer(temp.right);
                }
                TreeNode parentNode = parent.get(temp);
                if (parentNode != null && visited.add(parentNode)) {
                    q.offer(parentNode);
                }
            }
            if (n == k) {
                break;
            }
            n++;
        }
        return list;
    }

    private static void buildParent(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> map) {
        if (root == null) return;
        map.put(root, parent);
        buildParent(root.left, root, map);
        buildParent(root.right, root, map);
    }

    public static void main(String[] args) {

    //             0
    //            / \
    //           2   1
    //              / \
    //             3   4


        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        TreeNode target = root.right.left; // node with value 3
        int k = 2;

        System.out.println(getAllNodesKDist(root, target, k));
    }
}
