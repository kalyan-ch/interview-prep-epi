package org.wb.leetcode.medium;

import org.wb.epi.Chap5Arrays.ArraysUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob49GroupAnagrams {
    public static void main(String[] args) {
        String[][] strs = {{"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"}};
        for (String[] words: strs){
            List<List<String>> strList = groupAnagrams(words);
            for(List<String> resultWords: strList){
                ArraysUtils.printStrList(resultWords);
            }
        }

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramList = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String word: strs){
            String key = getHash(word);
            List<String> wordList = anagramList.getOrDefault(key, new ArrayList<String>());
            wordList.add(word);
            anagramList.put(key, wordList);
        }

        for(String k: anagramList.keySet()){
            result.add(anagramList.get(k));
        }
        return result;
    }

    public static String getHash(String word){
        int[] charArr = new int[26];
        for (int i = 0; i < word.length() ; i++) {
            charArr[word.charAt(i) - 'a']++;
        }

        StringBuilder hash = new StringBuilder();
        for(int i= 0; i < 26; i++){
            hash.append("#").append(charArr[i]);
        }
        return hash.toString();
    }
}
