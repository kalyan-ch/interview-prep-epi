package org.wb.leetcode.medium;

import org.wb.epi.Chap9BinaryTrees.TreeNode;
import java.util.*;

public class MaxWidthBinaryTree {
    class NodeIdx {
        TreeNode node;
        long idx;

        public NodeIdx(TreeNode n, long index){
            node = n;
            idx = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        long width = 0;

        Queue<NodeIdx> q = new LinkedList<>();
        q.add(new NodeIdx(root, 0));

        while (!q.isEmpty()) {
            int n = q.size();
            NodeIdx first = q.peek();
            NodeIdx ni = null;
            for(int i = 0; i < n; i++){
                ni = q.poll();
                if(ni.node.left != null){
                    q.add(new NodeIdx(ni.node.left, 2 * ni.idx));
                }

                if(ni.node.right != null) {
                    q.add(new NodeIdx(ni.node.right, 2 * ni.idx + 1));
                }
            }

            width = Math.max(width, ni.idx - first.idx + 1);
        }

        return (int) width;
    }
}
