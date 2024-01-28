package org.wb.leetcode.interview150.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        String[] paths = {"/home/", "/../", "/home//foo/", "/home/../dir/", "/home/./foo/"};

        for(String p: paths) {
            System.out.println(simplifyPath(p));
        }
    }

    public static String simplifyPath(String path) {
        Stack<String> folderStack = new Stack<>();

        String[] folders = path.split("/");

        for(String f: folders) {
            switch (f) {
                case "", "." -> {
                }
                case ".." -> {
                    if (!folderStack.isEmpty()) {
                        folderStack.pop();
                    }
                }
                default -> folderStack.push(f);
            }
        }

        List<String> resList = new ArrayList<>();
        while(!folderStack.isEmpty()) {
            resList.add(folderStack.pop());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for(int i = resList.size() - 1; i >= 0; i--) {
            sb.append(resList.get(i));
            if(i != 0){
                sb.append("/");
            }
        }
        return sb.toString();
    }
}
