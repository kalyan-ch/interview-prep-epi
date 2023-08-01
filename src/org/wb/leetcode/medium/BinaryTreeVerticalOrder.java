package org.wb.leetcode.medium;

import org.wb.epi.Chap5Arrays.ArraysUtils;
import org.wb.epi.Chap9BinaryTrees.TreeNode;

import java.util.*;

public class BinaryTreeVerticalOrder {

    private static class NodeWithColumn {
        TreeNode node;
        int colIdx;

        public NodeWithColumn(TreeNode node, int colIdx) {
            this.node = node;
            this.colIdx = colIdx;
        }
    }
    public static void main(String[] args) {
        TreeNode root = constructTree();
        List<List<Integer>> order = verticalOrder(root);
        ArraysUtils.printInt2dList(order);
    }

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> columnToNode = new TreeMap<>();
        Queue<NodeWithColumn> q = new LinkedList<>();


        q.add(new NodeWithColumn(root, 0));

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++ ) {
                NodeWithColumn nodeCol = q.remove();
                TreeNode node = nodeCol.node;
                int colIdx = nodeCol.colIdx;
                List<Integer> nodes = columnToNode.getOrDefault(colIdx, new ArrayList<>());
                nodes.add(node.data);
                columnToNode.put(colIdx, nodes);

                if(node.left != null) {
                    q.add(new NodeWithColumn(node.left, colIdx - 1));
                }

                if(node.right != null) {
                    q.add(new NodeWithColumn(node.right, colIdx + 1));
                }
            }
        }

        for(int colIdx: columnToNode.keySet()) {
            result.add(columnToNode.get(colIdx));
        }

        return result;
    }

    public static TreeNode constructTree() {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        root.left = node1;
        TreeNode node = new TreeNode(20);
        root.right = node;
        node.left = new TreeNode(15);
        node.right = new TreeNode(7);
        node1.left = new TreeNode(4);
        node1.right = new TreeNode(8);
        return root;
    }
}
