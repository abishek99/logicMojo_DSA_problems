package com.logicmojo.Tree;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class DeleteNodeInBinarySearchTree {


    public static TreeNode deleteinBST(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.data == key) {
            // Node found
            if (root.left == null && root.right == null) {
                return null; // leaf
            }
            if (root.left == null) {
                return root.right; // only right child
            }
            if (root.right == null) {
                return root.left; // only left child
            }
            TreeNode temp = root.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            root.data = temp.data;
            root.right =  deleteinBST(root.right, temp.data);
        } else if(root.data > key) {
            root.left = deleteinBST(root.left, key);
        } else if (root.data < key) {
            root.right = deleteinBST(root.right, key);
        }
        return root;
    }

    public static TreeNode iterativeBST(TreeNode root, int key) {
        TreeNode curr = root;
        TreeNode parent = null;
        while (curr!=null && curr.data!= key) {
            parent = curr;
            if (curr.data > key) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        if (curr == null) {
            return root;
        }
        if (curr.left == null || curr.right == null) {
            TreeNode child = curr.left!= null ? curr.left : curr.right;
            if (parent == null) {
                return child;
            }
            if (parent.left == curr) {
                parent.left = child;
            }
            else {
                parent.right = child;
            }
        } else {
            TreeNode successorParent = curr;
            TreeNode sucessor = curr.right;
            while (sucessor.left != null) {
                successorParent = sucessor;
                sucessor = sucessor.left;
            }
            curr.data = sucessor.data;
            if (successorParent.left == sucessor) {
                successorParent.left = sucessor.right;
            } else if (successorParent.right == sucessor) {
                successorParent.right = sucessor.right;
            }
        }
        return root;
    }
}
