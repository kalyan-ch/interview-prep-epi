package org.wb.leetcode.LeetCodeAndBlind75;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSeq {
    public static void main(String[] args) {
        int[][] tests = {{0,3,7,2,5,8,4,6,0,1}, {100,4,200,1,3,2}, {7,1,3,1,4,6,5}, {1,2,0,1}};
        for(int[] arr: tests) {
            System.out.println(longestConsecutive(arr));
        }
    }

    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return nums.length;
        }
        Arrays.sort(nums);

        int curr = nums[0], j = 1, result = 1, sum = 1;
        for(j = 1; j < nums.length; j++){
            if(nums[j] == nums[j - 1]){
                continue;
            }

            if(nums[j] == curr + 1){
                sum++; curr++;
                result = Math.max(sum, result);
            } else {
                curr = nums[j];
                sum = 1;
            }
        }

        return result;
    }
}
