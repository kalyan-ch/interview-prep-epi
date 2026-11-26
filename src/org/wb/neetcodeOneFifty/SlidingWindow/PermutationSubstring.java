package org.wb.neetcodeOneFifty.SlidingWindow;


public class PermutationSubstring {
    public static void main(String[] args) {
        System.out.println(checkInclusion("aabc", "lecabaedla"));
    }

    public static boolean checkInclusion (String s1, String s2) {
        if(s2.length() < s1.length()) {
            return false;
        }

        var charCount = new int[26];
        var charCount2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            charCount[s1.charAt(i) - 'a']++;
            charCount2[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if(charCount[i] == charCount2[i]) {
                matches++;
            }
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if(matches == 26) {
                return true;
            }

            var idx = s2.charAt(r) - 'a';
            charCount2[idx]++;
            if(charCount[idx] == charCount2[idx]) {
                matches++;
            } else if (charCount[idx] + 1 == charCount2[idx]) {
                matches--;
            }

            var idx2 = s2.charAt(l) - 'a';
            charCount2[idx2]--;
            if(charCount[idx2] == charCount2[idx2]) {
                matches++;
            } else if (charCount[idx2] - 1 == charCount2[idx2]) {
                matches--;
            }
            l++;
        }

        return matches == 26;
    }

}
