package org.wb.leetcode.medium;

import java.util.*;

public class Prob3LongestNonDuplicateChars {

    public static void main(String[] args) {
        String[] ss = {"au", "abcabcbb", "pwwkes"};
        for(String s: ss){
            System.out.println(lengthOfLongestSubstring(s));
        }
    }

    public static int lengthOfLongestSubstring(String s) {
        int result = 0, left = 0, right = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        while(right < s.length()){
            char c = s.charAt(right);
            int dupIdx = charMap.getOrDefault(c, -1);
            charMap.put(c, right);

            if(dupIdx != -1 && dupIdx >= left){
                left = ++dupIdx;
            }

            result = Math.max(result, right - left + 1);

            right++;
        }

        return result;
    }
}
