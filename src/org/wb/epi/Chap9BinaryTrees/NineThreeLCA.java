package org.wb.epi.Chap9BinaryTrees;

public class NineThreeLCA {

    //find the least common ancestor of two nodes
    private static class LCAResult{
        int numTargetNodes;
        TreeNode ancestor;

        public LCAResult(int numTargetNodes, TreeNode ancestor) {
            this.numTargetNodes = numTargetNodes;
            this.ancestor = ancestor;
        }
    }

    public static TreeNode lcaOfTwoNodes(TreeNode root, TreeNode node1, TreeNode node2){
        return LCAHelper(root, node1, node2).ancestor;
    }

    public static LCAResult LCAHelper(TreeNode root, TreeNode node1, TreeNode node2){

        if(root == null){
            return new LCAResult(0, null);
        }

        LCAResult leftRes = LCAHelper(root.left, node1, node2);
        if(leftRes.numTargetNodes == 2){
            return leftRes;
        }

        LCAResult rightRes = LCAHelper(root.right, node1, node2);
        if(rightRes.numTargetNodes == 2){
            return rightRes;
        }

        int numTargetNodes = leftRes.numTargetNodes + rightRes.numTargetNodes + (root == node1 ? 1: 0) + (root == node2 ? 1: 0);
        return new LCAResult(numTargetNodes, numTargetNodes == 2 ? root : null);
    }

}
