package org.wb.leetcode.easy;

import org.wb.leetcode.util.TreeNode;

public class ClosestNodeInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(closestValue(root, 3.5));
    }

    private static int closestValue(TreeNode root, double target) {
        int result = root.val;
        while(root != null){
            if(Math.abs(target - root.val) == Math.abs(target - result)){
                result = Math.min(root.val, result);
            } else if(Math.abs(target - root.val) < Math.abs(target - result)){
                result = root.val;
            }
            root = root.val > target? root.left: root.right;
        }
        return result;
    }
}
