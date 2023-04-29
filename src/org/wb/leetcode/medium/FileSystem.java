package org.wb.leetcode.medium;

import java.util.*;

public class FileSystem {
    Map<String, Integer> fileSystem;

    public FileSystem() {
        fileSystem = new HashMap<>();
    }

    public boolean createPath(String path, int value) {
        if(fileSystem.containsKey(path)){
            return false;
        }

        List<String> ancestors = getParent(path);
        if(ancestors.size() != 0){
            for(String p: ancestors) {
                String key = "/"+p;
                if(!fileSystem.containsKey(key)){
                    return false;
                }
            }
        }

        fileSystem.put(path, value);

        return true;
    }

    public int get(String path) {
        return fileSystem.containsKey(path) ? fileSystem.get(path) : -1;
    }

    private List<String> getParent(String path) {
        String[] tokens = path.split("/");
        List<String> ancestors = new ArrayList<>();

        for(int i = 0; i < tokens.length; i++){
            if(!"".equals(tokens[i]) && i != tokens.length - 1){
                ancestors.add(tokens[i]);
            }
        }

        return ancestors;
    }
}
