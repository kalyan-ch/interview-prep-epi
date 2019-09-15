package org.wb.epi.Chap9BinaryTrees;

public class NineTwoTreeSymmetric {

    //check if left and right subtrees of a tree are mirror images of each other
    private static boolean isSymmetric(TreeNode root){
        return root == null || checkSymmetric(root.left, root.right);
    }

    private static boolean checkSymmetric(TreeNode left, TreeNode right) {

        if(left == null && right == null){
            return true;
        }else if(left != null && right != null){
            return (Integer.compare(left.data, right.data) == 0) && checkSymmetric(left.left, right.right) && checkSymmetric(left.right, right.left);
        }

        return false;

    }

}
