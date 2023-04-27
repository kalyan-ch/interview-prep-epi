package org.wb.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class MinStepsToAnagram {
    public static void main(String[] args) {
        int num = getMinStepsAnagram("leetcode", "practice");
        System.out.println(num);
    }

    private static int getMinStepsAnagram(String s, String t) {
        if(s.equals(t)){
            return 0;
        }
        int result = 0;

        Map<Character, Integer> charMap = new HashMap<>();


        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            charMap.put(c1, charMap.getOrDefault(c1, 0) + 1);
            charMap.put(c2, charMap.getOrDefault(c2, 0) - 1);
        }

        for(char c: charMap.keySet()) {
            if(charMap.get(c) > 0) {
                result += charMap.get(c);
            }
        }

        return result;
    }
}
