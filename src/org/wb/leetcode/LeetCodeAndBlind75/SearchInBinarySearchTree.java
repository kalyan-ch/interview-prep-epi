package org.wb.leetcode.LeetCodeAndBlind75;


import org.wb.leetcode.util.TreeNode;

public class SearchInBinarySearchTree {
    public static void main(String[] args) {

    }

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;

        if(val > root.val){
            return searchBST(root.right, val);
        }else if(val < root.val){
            return searchBST(root.left, val);
        }else{
            return root;
        }
    }
}
