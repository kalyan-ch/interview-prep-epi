package org.wb.epi.Chap9BinaryTrees;

public class TreeNodeWithParent extends TreeNode{

    public TreeNodeWithParent parent;

    public TreeNodeWithParent(Integer data, TreeNode left, TreeNode right, TreeNodeWithParent parent){
        super(data, left, right);
        this.parent = parent;
    }

}
