package org.wb.leetcode.LeetCodeAndBlind75;

import org.wb.leetcode.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSum3 {
    static int totalPaths = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(4), right = new TreeNode(8);
        root.left = left; root.right = right;
        TreeNode leftLeft = new TreeNode(11), rightLeft = new TreeNode(13), rightRight = new TreeNode(4);
        left.left = leftLeft; right.left = rightLeft; right.right = rightRight;
        leftLeft.left = new TreeNode(7); leftLeft.right = new TreeNode(2);
        rightRight.left = new TreeNode(5); rightRight.right = new TreeNode(1);

        System.out.println(pathSum(root, 22));

        root = new TreeNode(1);
        left = new TreeNode(-2); right = new TreeNode(-3);
        root.left = left; root.right = right;
        leftLeft = new TreeNode(1); left.left = leftLeft;
        left.right = new TreeNode(3); rightLeft = new TreeNode(-2);
        leftLeft.left = new TreeNode(-1); right.left = rightLeft;
        totalPaths = 0;

        System.out.println(pathSum(root, -1));
    }

    public static int pathSum(TreeNode root, int targetSum) {
        var prefixMap = new HashMap<Long, Long>();
        prefixMap.put(0L, 1L);
        dfs(root, targetSum, 0, prefixMap);
        return totalPaths;
    }

    private static void dfs(TreeNode node, long targetSum, long curr, Map<Long, Long> prefixMap ) {
        if(node == null) {
            return;
        }

        curr += node.val;
        var oldPathSum = curr - targetSum;

        totalPaths += prefixMap.getOrDefault(oldPathSum, 0L);
        prefixMap.put(curr, prefixMap.getOrDefault(curr, 0L) + 1);

        dfs(node.left, targetSum, curr, prefixMap);
        dfs(node.right, targetSum, curr, prefixMap);

        prefixMap.put(curr, prefixMap.get(curr) - 1);
    }
}
