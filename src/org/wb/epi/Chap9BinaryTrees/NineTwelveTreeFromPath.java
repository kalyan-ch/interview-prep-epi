package org.wb.epi.Chap9BinaryTrees;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class NineTwelveTreeFromPath{

    //construct a tree from list of nodes from traverse path of a tree
    //each node has unique value

    public TreeNode constructTree(List<Integer> inorderPath, List<Integer> preOrderPath){

        Map<Integer, Integer> nodeToIndexInOrder = new HashMap<>();

        for(int i =0; i < inorderPath.size(); i++){
            nodeToIndexInOrder.put(inorderPath.get(i), i);
        }

        return binaryTreeHelper(preOrderPath, 0, preOrderPath.size(), 0, inorderPath.size(), nodeToIndexInOrder);
    }

    public TreeNode binaryTreeHelper(List<Integer> preOrderPath, int preOrderStart, int preOrderEnd, int inOrderStart, int inOrderEnd, Map<Integer, Integer> nodeToIndexInOrder){

        if(preOrderStart >= preOrderEnd || inOrderStart >= inOrderEnd){
            return null;
        }

        int rootIdx = nodeToIndexInOrder.get(preOrderPath.get(preOrderStart));
        int leftSubTreeSize = rootIdx - inOrderStart;

        TreeNode left = binaryTreeHelper(preOrderPath, preOrderStart + 1, preOrderStart + 1 + leftSubTreeSize, inOrderStart, rootIdx, nodeToIndexInOrder);
        TreeNode right = binaryTreeHelper(preOrderPath, preOrderStart + 1 + leftSubTreeSize, preOrderEnd, rootIdx + 1, inOrderEnd, nodeToIndexInOrder);

        return new TreeNode(preOrderPath.get(preOrderStart), left, right);

    }
    
}