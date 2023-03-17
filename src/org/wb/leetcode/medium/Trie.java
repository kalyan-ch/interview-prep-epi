package org.wb.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode('\u0000');
    }

    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!node.children.containsKey(c)){
                TrieNode t = new TrieNode(c);
                node.children.put(c, t);
            }

            node = node.children.get(c);

            if(i == word.length() - 1){
                node.isWord = true;
            }
        }
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!node.children.containsKey(c)){
                return false;
            }
            node = node.children.get(c);
        }

        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        return false;
    }
}
