package org.wb.neetcodeOneFifty.SlidingWindow;

import java.util.HashSet;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        String[] strs = {"zxyzxyz", "pwwkew"};
        for(String s: strs)
            System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int result = 0, l = 0;
        var charSet = new HashSet<Character>();

        for (int r = 0; r < s.length(); r++) {
            char right = s.charAt(r);
            while (charSet.contains(right)) {
                charSet.remove(s.charAt(l));
                l++;
            }
            charSet.add(right);
            result = Math.max(result, r - l + 1);
        }

        return result;
    }

}
