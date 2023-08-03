package org.wb.leetcode.medium;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cabcba"));
    }

    public static String longestPalindrome(String s) {
        int[] maxIndices = {0, 0};
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for(int i = 0; i < n - 1; i++){
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxIndices[0] = i;
                maxIndices[1] = i + 1;
            }
        }

        for(int diff = 2; diff < n; diff++) {
            for(int i = 0; i < n - diff; i++) {
                int j = i + diff;
                if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    maxIndices[0] = i;
                    maxIndices[1] = j;
                }
            }
        }

        return s.substring(maxIndices[0], maxIndices[1] + 1);
    }
}
