package com.logicmojo.Tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBSTPostOrder {

    private int postOrderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> indexMap = new HashMap<Integer,Integer>();
        for (int i=0; i<inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        postOrderIndex = postorder.length - 1;
        return buildPost(inorder, postorder, 0, inorder.length-1, indexMap);
    }

    public TreeNode buildPost(int[] inorder, int[] postorder, int l,
                              int r, Map<Integer,Integer> indexMap) {
        if (l > r) {
            return null;
        }
        int postOrderVal = postorder[postOrderIndex--];
        int mid = indexMap.get(postOrderVal);
        TreeNode root = new TreeNode(postOrderVal);
        root.right = buildPost(inorder, postorder, mid+1, r, indexMap);
        root.left = buildPost(inorder, postorder, l, mid-1, indexMap);
        return root;
    }
}
