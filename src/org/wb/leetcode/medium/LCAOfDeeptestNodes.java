package org.wb.leetcode.medium;

import org.wb.epi.Chap9BinaryTrees.TreeNode;

public class LCAOfDeeptestNodes {

    private static class Node {
        TreeNode treeNode;
        int height;

        public Node(TreeNode tn, int h) {
            treeNode = tn;
            height = h;
        }


        @Override
        public String toString() {
            return (treeNode != null ? treeNode.data : "null")+" "+height;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode level2Left = new TreeNode(5);
        TreeNode level2Right = new TreeNode(1);
        root.left = level2Left;
        root.right = level2Right;

        level2Left.left = new TreeNode(6);
        System.out.println(lcaDeepestLeaves(root).data);
    }

    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        Node n = depth(root);
        return n.treeNode;
    }

    private static Node depth(TreeNode node) {

        if(node == null){
            return new Node(null, 0);
        }

        Node left = depth(node.left);
        Node right = depth(node.right);
        int maxH = Math.max(left.height, right.height) + 1;

        if(left.height > right.height) {
            return new Node(left.treeNode, maxH);
        } else if (right.height > left.height) {
            return new Node(right.treeNode, maxH);
        } else {
            return new Node(node, maxH);
        }

    }
}
