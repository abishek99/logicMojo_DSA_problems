package com.logicmojo.Tree;


public class AVLTreeInsertion {

   private TreeNode insert(TreeNode root, int key) {
       if (root == null) {
           return new TreeNode(key);
       }
       if (root.data >  key) {
           root.left = insert(root.left, key);
       } else if (root.data < key) {
           root.right = insert(root.right, key);
       } else {
           return root;
       }
       root.height = 1 + Math.max(height(root.left), height(root.right));
       int balance = height(root.left) - height(root.right);
       //LL
       if (balance > 1 && key < root.left.data) {
           return rightRotation(root);
       }
       //LR
       if (balance > 1 && key > root.left.data) {
           root.left = leftRotation(root.left);
           return rightRotation(root);
       }
       //RR
       if (balance < -1 && key > root.right.data) {
           return leftRotation(root);
       }
       // RL
       if (balance < -1 && key < root.right.data) {
           root.right = rightRotation(root.right);
           return leftRotation(root);
       }

       return root;
   }

   private TreeNode leftRotation(TreeNode y) {
       TreeNode x = y.right;
       TreeNode xRight = x.left;
       x.left = y;
       y.right = xRight;

       // first update root
       y.height = 1 + Math.max(height(y.left), height(y.right));
       // then update child
       x.height = 1 + Math.max(height(x.left), height(x.right));

       return x;
   }

    private TreeNode rightRotation(TreeNode y) {
        TreeNode x = y.left;
        TreeNode xRight = x.right;
        x.right = y;
        y.left = xRight;

        // first update root
        y.height = 1 + Math.max(height(y.left), height(y.right));
        // then update child
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return x;
    }

   private int height(TreeNode root) {
       if (root == null) {
           return 0;
       }
       else {
           return root.height;
       }
   }

   public class TreeNode {
       int data;
       int height;
       TreeNode left;
       TreeNode right;
       TreeNode(int data) {
           this.data = data;
           this.height = 1;
           this.left = null;
           this.right = null;
       }
   }

}
