package org.wb.leetcode.LeetCodeAndBlind75;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class MaxVowelsInSubstring {
    public static void main(String[] args) {
        String[] tests = {"leetcode", "abciiidef", "aeiou"};
        int[] len = {3, 3, 2};
        for(var i = 0; i < tests.length; i++){
            System.out.println(maxVowels(tests[i], len[i]));
        }

    }

    private static int maxVowels(String s, int k){
        int curr = 0, maxVow = 0, n = s.length();
        var vowels = new HashSet<Character>(List.of('a', 'e', 'i', 'o', 'u'));

        for(int i = 0; i < k; i++){
            if(vowels.contains(s.charAt(i))){
                curr++;
            }
        }

        maxVow = curr;
        var j = k - 1;

        for(int i = 1; i < n; i++) {
            if(vowels.contains(s.charAt(i-1))){
                curr--;
            }

            j++;

            if(j < n) {
                if(vowels.contains(s.charAt(j))){
                    curr++;
                }
            }

            maxVow = Math.max(curr, maxVow);
        }

        return maxVow;
    }
}
