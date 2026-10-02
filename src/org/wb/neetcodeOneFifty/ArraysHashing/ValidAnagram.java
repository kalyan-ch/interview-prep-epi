package org.wb.neetcodeOneFifty.ArraysHashing;

import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";

        System.out.println(validAnagram(s, t));
    }

    private static boolean validAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] countMap = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            countMap[letter - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char letter = t.charAt(i);
            countMap[letter-'a']--;
        }

        for(int i: countMap){
            if(i > 0) {
                return false;
            }
        }

        return true;
    }
}
