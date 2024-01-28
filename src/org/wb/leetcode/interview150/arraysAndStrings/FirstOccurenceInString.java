package org.wb.leetcode.interview150.arraysAndStrings;

public class FirstOccurenceInString {

    public static void main(String[] args) {
        String[][] tests = {{"shadbutnotsad", "sad"}, {"leetcode", "leeto"}, {"jkdfgdf", "df"}, {"mississippi", "issip"}};

        for(String[] test: tests) {
            System.out.println(strStr(test[0], test[1]));
        }

    }

    public static int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) {
            return -1;
        }

        int n = needle.length(), h = haystack.length();

        for(int i = 0; i < h; i++) {
            if(haystack.charAt(i) != needle.charAt(0)) {
                continue;
            }

            int j = 0, k = i;
            while(j < n && k < h) {
                if(haystack.charAt(k) == needle.charAt(j)) {
                    j++; k++;
                } else {
                    break;
                }
            }

            if(j == n) {
                return i;
            }
        }

        return -1;
    }
}
