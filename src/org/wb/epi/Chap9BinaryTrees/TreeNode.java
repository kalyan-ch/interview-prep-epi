package org.wb.epi.Chap9BinaryTrees;

public class TreeNode {
    public TreeNode left;
    public Integer data;
    public TreeNode right;

    public TreeNode(Integer data){
        this.data = data;
    }

    public TreeNode(Integer data, TreeNode left, TreeNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

}
