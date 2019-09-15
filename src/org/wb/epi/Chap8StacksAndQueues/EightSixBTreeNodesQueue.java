package org.wb.epi.Chap8StacksAndQueues;

import org.wb.epi.Chap9BinaryTrees.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class EightSixBTreeNodesQueue {

    //breadth first search of a binary tree
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20, null, null);
        TreeNode lvl2Node1 = insertTreeNode(true, 10, root);
        TreeNode lvl2Node2 = insertTreeNode(false, 1, root);
        TreeNode lvl3Node1 = insertTreeNode(true, 25, lvl2Node1);
        TreeNode lvl3Node2 = insertTreeNode(false, 26, lvl2Node1);
        TreeNode lvl3Node3 = insertTreeNode(true, 32, lvl2Node2);
        TreeNode lvl3Node4 = insertTreeNode(false, 37, lvl2Node2);
        insertTreeNode(true, 5, lvl3Node1);
        insertTreeNode(false, 6, lvl3Node2);
        insertTreeNode(false, 8, lvl3Node3);
        insertTreeNode(true, 10, lvl3Node4);


        breadthFirstSearchPrintTree(root);

    }

    private static void breadthFirstSearchPrintTree(TreeNode root) {

        Queue<TreeNode> currNodes = new ArrayDeque<>();
        currNodes.add(root);
        while(!currNodes.isEmpty()){
            Queue<TreeNode> nextNodes = new ArrayDeque<>();
            while(!currNodes.isEmpty()){
                TreeNode currNode = currNodes.poll();
                if(currNode != null){
                    System.out.print(currNode.data+" ");
                    if(currNode.left != null)
                        nextNodes.add(currNode.left);

                    if(currNode.right != null)
                        nextNodes.add(currNode.right);

                }
            }
            System.out.println();
            currNodes = nextNodes;
        }


    }

    private static TreeNode insertTreeNode(boolean isLeft, int data, TreeNode root) {
        TreeNode node = new TreeNode(data, null, null);
        if(isLeft){
            root.left = node;
        }else{
            root.right = node;
        }
        return node;
    }
}
