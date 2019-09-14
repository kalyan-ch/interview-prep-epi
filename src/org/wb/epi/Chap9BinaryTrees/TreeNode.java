package org.wb.epi.Chap9BinaryTrees;

public class TreeNode<T> {
    public TreeNode left;
    public T data;
    public TreeNode right;

    public TreeNode(T data, TreeNode left, TreeNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

}
