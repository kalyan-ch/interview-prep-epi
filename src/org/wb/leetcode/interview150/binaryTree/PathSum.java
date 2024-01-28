package org.wb.leetcode.interview150.binaryTree;


import org.wb.epi.Chap9BinaryTrees.TreeNode;

public class PathSum {

    public static void main(String[] args) {
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node6 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4, node11, null);
        TreeNode node8 = new TreeNode(8, node13, node6);
        TreeNode root = new TreeNode(5, node4, node8);

        System.out.println(hasPathSum(root, 20));

    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return getPathSum(root, targetSum);
    }

    private static boolean getPathSum(TreeNode node, int remaining) {

        if(node.left == null && node.right == null) {
            return remaining == node.data;
        }

        boolean leftResult = true;
        boolean rightResult = true;

        if(node.left != null) {
            leftResult = getPathSum(node.left, remaining - node.data);
        }

        if(node.right != null) {
            rightResult = getPathSum(node.right, remaining - node.data);
        }

        return leftResult || rightResult;

    }
}
