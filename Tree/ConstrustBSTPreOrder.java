package com.logicmojo.Tree;

import java.util.HashMap;
import java.util.Map;

public class ConstrustBSTPreOrder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i =0 ;i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildPreOrder(preorder, inorder, 0, preorder.length-1, indexMap);
    }

    private int preIndex = 0;

    private TreeNode buildPreOrder(int[] preorder, int[] inorder,
                                   int l , int r, Map<Integer, Integer> indexMap) {
        if (l > r) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex++]);
        int mid = indexMap.get(root.data);
        root.left = buildPreOrder(preorder, inorder, l, mid-1, indexMap);
        root.right = buildPreOrder(preorder, inorder, mid+1, r, indexMap);
        return root;
    }
}
