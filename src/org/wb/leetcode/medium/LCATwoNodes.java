package org.wb.leetcode.medium;

import org.wb.epi.Chap9BinaryTrees.TreeNode;

public class LCATwoNodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        root.left = p;
        root.right = new TreeNode(1);
        root.left.right = q;
        root.right.left = new TreeNode(0);

        TreeNode node = findLCA(root, p, q);
        System.out.println(node.data);
    }

    private static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        if(left != null && right != null){
            return root;
        }

        return (left != null) ? left : right;

    }
}
