package org.wb.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    char val;
    Map<Character, TrieNode> children;
    boolean isWord;

    public TrieNode(char val){
        this.val = val;
        this.children = new HashMap<>();
    }
    public TrieNode() {}
}
