package org.wb.leetcode;

import java.util.*;

public class LongestNonDuplicateChars {

    public static void main(String[] args) {
        String s = "au";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, result = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();
        while(end < s.length()){
            char c = s.charAt(end);
            int dupIndx = charMap.getOrDefault(c, -1);
            charMap.put(c, end);
            if(dupIndx != -1){
                if(dupIndx >= start){
                    result = Math.max(result, end - start);
                    start = dupIndx + 1;
                }
            }
            end++;
        }

        return result;
    }
}
