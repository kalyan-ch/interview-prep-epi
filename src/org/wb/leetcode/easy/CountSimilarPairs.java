package org.wb.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class CountSimilarPairs {
    public static void main(String[] args) {
        String[][] wordsArr = {{"aba","aabb","abcd","bac","aabc"}, {"aabb","ab","ba"}};
        for (String[] words: wordsArr){
            System.out.println(similarPairs(words));
        }

    }

    private static int similarPairs(String[] words) {
        int count = 0;

        var map = new HashMap<String, List<String>>();

        for(int i = 0; i < words.length; i++){
            var charSet = new HashSet<Character>();
            for(char c: words[i].toCharArray()){
                charSet.add(c);
            }

            //sort characters in charSet and convert to string
            String key = charSet.stream().sorted().map(String::valueOf).collect(Collectors.joining());
            var list = map.getOrDefault(key, new ArrayList<String>());
            list.add(words[i]);
            map.put(key, list);
        }

        for(String key: map.keySet()){
            var list = map.get(key);
            if(list.size() > 1){
                count += list.size() * (list.size() - 1) / 2;
            }
        }

        return count;
    }
}
