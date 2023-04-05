package org.wb.Misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WalmartTest {
    /*Given a string s, find the length of the longest substring without repeating characters.



            Example 1:

    Input: s = "abcabcbb"
    Output: 3*/

    public static void main(String[] args) {
        System.out.println(findLongestSubStr("abcabcbb"));
        System.out.println(findLongestSubStr("bbbbb"));
        System.out.println(findLongestSubStr("tmmzuxt"));
        System.out.println(findLongestSubStr(""));

        int[] nums = {-1, 0, 2, 3, 1, -2, -2};
        findTripletsSumToZero(nums);
    }

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static void findTripletsSumToZero(int[] nums){
        Map<Integer, List<Pair>> map = new HashMap<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){

            int j = i + 1 , k = nums.length - 1;
            int sum = nums[j] + nums[k];

            while(j < k){
                if(sum < nums[i]){

                }

            }


        }
    }



    private static int findLongestSubStr(String s){
        int result = 0, i = 0, j = 0;
        int[] charMap = new int[26];

        while(j < s.length()){
            char c = s.charAt(j);
            if(charMap[c - 'a'] > 0){
                result = Math.max(result, j - i);
                charMap[c - 'a'] = 0;
                i++;
            }

            charMap[c - 'a']++;
            j++;
        }

        return result;
    }
}
