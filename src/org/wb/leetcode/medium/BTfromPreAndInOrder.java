package org.wb.leetcode.medium;

import org.wb.epi.Chap9BinaryTrees.TreeNode;
import java.util.*;

public class BTfromPreAndInOrder {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7}, inorder = {9,3,15,20,7};
        TreeNode node = buildTree(preorder, inorder);

    }

    static int rootIdx = 0;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int preIdx = 0;
        Map<Integer, Integer> inOrderIdxMap = new HashMap<>();

        for(int i =0; i< inorder.length; i++) {
            inOrderIdxMap.put(inorder[i], i);
        }

        return arraysToTree(preorder, 0, preorder.length - 1, inOrderIdxMap);
    }

    private static TreeNode arraysToTree(int[] preorder, int left, int right, Map<Integer, Integer> inOrderIdxMap) {
        if(left > right) {
            return null;
        }

        int val = preorder[rootIdx];
        TreeNode root = new TreeNode(val);
        int inIdx = inOrderIdxMap.get(val);
        rootIdx++;

        root.left = arraysToTree(preorder, left, inIdx - 1, inOrderIdxMap);
        root.right = arraysToTree(preorder, inIdx + 1, right, inOrderIdxMap);

        return root;
    }
}
