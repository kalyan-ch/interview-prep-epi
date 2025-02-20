package org.wb.leetcode.LeetCodeAndBlind75;

public class LongestSubArrayOf1s {
    public static void main(String[] args) {
        int[] nums = {0,1,1,1,0,1,1,0,1};

        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        int left = 0, right = 0, zeroes = 0;

        while(right < nums.length && left < nums.length){
            if(nums[right] == 0){
                zeroes++;
            }

            if(zeroes > 1) {
                if(nums[left++] == 0){
                    zeroes--;
                }
            }
            right++;
        }

        return right - left - 1;
    }
}
