package org.wb.epi.Chap9BinaryTrees;

public class NineOneHeightBalanced {

    //check if a binary tree is height balanced - if for each node in the tree the difference in the height of left and right subtrees is atmost one
    public static void main(String[] args) {

    }

    private static class BalancedResult{
        int height;
        boolean isBalanced;

        BalancedResult(int height, boolean isBalanced){
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    private static boolean isBalanced(TreeNode root){
        return checkBalanced(root).isBalanced;
    }

    private static BalancedResult checkBalanced(TreeNode root){

        if(root == null){
            return new BalancedResult(-1, true);
        }

        BalancedResult leftResult = checkBalanced(root.left);
        if(!leftResult.isBalanced){
            return leftResult;
        }

        BalancedResult rightResult = checkBalanced(root.left);
        if(!rightResult.isBalanced){
            return rightResult;
        }

        boolean isBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
        int height = Math.max(leftResult.height, rightResult.height) + 1;

        return new BalancedResult(height, isBalanced);

    }



}
