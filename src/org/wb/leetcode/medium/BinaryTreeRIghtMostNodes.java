package org.wb.leetcode.medium;

import org.wb.epi.Chap9BinaryTrees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRIghtMostNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(0);

        List<Integer> levelNodes = BFS(root);
    }

    public static List<Integer> BFS(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int nodesInCurrentLevel = queue.size();

            for (int i = 0; i < nodesInCurrentLevel; i++) {
                // get current node from queue
                TreeNode node = queue.remove();

                
                if(i == nodesInCurrentLevel - 1) {
                    System.out.print(node.data + " ");
                    result.add(node.data);
                }

                // put the next level onto the queue
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            System.out.println();
        }
        return result;
    }
}
