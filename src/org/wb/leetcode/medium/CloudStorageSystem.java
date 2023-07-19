package org.wb.leetcode.medium;

import java.util.*;

public class CloudStorageSystem {
    class TreeNode {
        int size;
        boolean isDirectory;
        Map<String, TreeNode> children;

        public TreeNode(){
            children = new HashMap<>();
        }
    }


    TreeNode root;

    public CloudStorageSystem() {
        root = new TreeNode();
    }

    public String[] cloudStorage(String[][] queries) {
        String[] result = new String[queries.length];

        for(int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            String operation = query[0];
            switch (operation) {
                case "ADD_FILE" -> result[i] = addFile(root, query[1], Integer.parseInt(query[2]));
                case "COPY_FILE" -> result[i] = copyFile(root, query[1], query[2]);
                case "GET_FILE_SIZE" -> result[i] = getSize(root, query[1]);
                case "FIND_FILE" -> result[i] = findFile(root, query[1], query[2]);
            }
        }
        return result;
    }

    private String addFile(TreeNode root, String name, int size) {
        List<String> nodeStrs = getNodeStrs(name);
        int n = nodeStrs.size();
        TreeNode node = root;

        for(int j = 0; j < n; j++){
            String currNode = nodeStrs.get(j);
            Map<String, TreeNode> children = node.children;

            if(children.containsKey(currNode)){
                if(j == n - 1){
                    return "false";
                }
            } else {
                TreeNode nextNode = new TreeNode();
                nextNode.isDirectory = true;
                if(j == n - 1) {
                    nextNode.isDirectory = false;
                    nextNode.size = size;
                }
                children.put(currNode, nextNode);
            }
            node = children.get(currNode);
        }

        return "true";
    }

    private String copyFile(TreeNode root, String fromPath, String toPath) {
        TreeNode node = root;

        String fromSize = getSize(root, fromPath);
        String toSize = getSize(root, toPath);


        if("".equals(fromSize) || !"".equals(toSize)){
            return "false";
        }

        List<String> nodeStrs = getNodeStrs(toPath);

        List<String> fromNodeStrs = getNodeStrs(fromPath);
        for(String cuNo: fromNodeStrs){
            node = node.children.get(cuNo);
        }
        int size = node.size;

        node = root;
        for(String currNode: nodeStrs) {
            if(!node.children.containsKey(currNode)){
                TreeNode nextNode = new TreeNode();
                nextNode.isDirectory = false;
                nextNode.size = size;
                node.children.put(currNode, nextNode);
            }
            node = node.children.get(currNode);
        }


        return "true";
    }

    private String findFile(TreeNode root, String prefix, String suffix) {
        List<String> fileResults = new ArrayList<>();
        prefix = prefix.replace("/", "");

        Queue<TreeNode> q = new LinkedList<>();
        Map<String, TreeNode> rootChildren = root.children;
        TreeNode start = null;
        for (String nodeStr : rootChildren.keySet()) {
            if(nodeStr.startsWith(prefix)) {
                start = rootChildren.get(nodeStr);
                break;
            }
        }

        if(start == null){
            return "";
        }

        q.add(start);
        StringBuilder sb = new StringBuilder();
        sb.append("/").append(prefix);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            Map<String, TreeNode> children = node.children;
            for(String nodeStr : children.keySet()) {
                TreeNode nextNode = children.get(nodeStr);

                if(!nextNode.isDirectory) {
                    if (nodeStr.contains(suffix)) {
                        sb.append("/").append(nodeStr)
                            .append("(").append(nextNode.size)
                                .append(")");
                        fileResults.add(sb.toString());
                    }
                } else {
                    sb.append("/").append(nodeStr);
                    q.add(nextNode);
                }
            }
        }

        sb = new StringBuilder();
        for(int k = 0; k < fileResults.size(); k++){
            sb.append(fileResults.get(k));
            if(k != fileResults.size() - 1){
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private List<String> getNodeStrs(String path) {
        String[] nodeStrs = path.split("/");
        List<String> result = new ArrayList<>();

        for(String n: nodeStrs){
            if(!"".equals(n)) {
                result.add(n);
            }
        }

        return result;
    }

    private String getSize(TreeNode root, String path){
        TreeNode node = root;

        for(String currNode: getNodeStrs(path)) {

            if(!node.children.containsKey(currNode)) {
                return "";
            }
            node = node.children.get(currNode);
        }

        return String.valueOf(node.size);
    }

}
