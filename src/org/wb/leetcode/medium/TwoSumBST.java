package org.wb.leetcode.medium;

import org.wb.epi.Chap9BinaryTrees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TwoSumBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(6);
        root.left = left;
        root.right = right;

        right.right = new TreeNode(8);
        left.left = new TreeNode(2);
        left.right = new TreeNode(4);

        System.out.println(findTarget(root, 9));
    }
    public static boolean findTarget(TreeNode root, int k) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                int diff = Math.abs(node.data - k);

                TreeNode diffNode = findDiff(root, diff);
                if(diffNode != null && diffNode != node) {
                    return true;
                }

                if(node.left != null) {
                    q.add(node.left);
                }

                if(node.right != null) {
                    q.add(node.right);
                }
            }
        }

        return false;
    }

    private static TreeNode findDiff(TreeNode root, int diff) {
        TreeNode node = root;

        while(node != null){
            if(node.data == diff) {
                return node;
            } else if(diff > node.data){
                node = node.right;
            } else {
                node = node.left;
            }
        }

        return null;
    }
}
