package org.wb.epi.Chap9BinaryTrees;

public class NineFourLCAWithParent {

    //find LCA when nodes have parent node field

    public TreeNodeWithParent findLCA(TreeNodeWithParent node1, TreeNodeWithParent node2){
        int depth1 = getDepth(node1), depth2 = getDepth(node2);

        if(depth1 > depth2){
            TreeNodeWithParent temp = node1;
            node1 = node2;
            node2 = temp;
        }

        int diffDepth = Math.abs(depth1 - depth2);

        while(diffDepth-- > 0 ){
            node2 = node2.parent;
        }

        while(node1 != node2){
            node1 = node1.parent;
            node2 = node2.parent;
        }

        return node1;

    }

    public int getDepth(TreeNodeWithParent node){
        TreeNodeWithParent temp = node;
        int depth = 0;
        while(temp != null){
            temp = temp.parent;
            depth++;
        }

        return depth;
    }


}
