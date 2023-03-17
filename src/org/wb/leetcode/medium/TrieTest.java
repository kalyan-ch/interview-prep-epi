package org.wb.leetcode.medium;

public class TrieTest {
    public static void main(String[] args) {
        Trie tr = new Trie();
        tr.insert("apple");
        System.out.println(tr.search("app"));
        tr.insert("app");
        System.out.println(tr.search("app"));
    }
}
