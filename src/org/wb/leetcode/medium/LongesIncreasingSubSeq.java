package org.wb.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongesIncreasingSubSeq {
    public static void main(String[] args) {
        int[] nums = {4,10,4,3,8,9};
        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLIS1(nums));
    }

    // using binary search - O(n*log n)
    private static int lengthOfLIS1(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for(int i = 1; i < nums.length; i++){
            if (nums[i] > sub.get(sub.size() - 1)){
                sub.add(nums[i]);
            } else {
                int l = 0, r = sub.size() - 1;
                while(l < r){
                    int m = l + (r - l) / 2;
                    if (sub.get(m) >= nums[i]){
                        r = m;
                    } else {
                       l = m + 1;
                    }
                }

                sub.set(r, nums[i]);
            }
        }

        return sub.size();
    }


    // using dynamic programming -O(n^2)
    public static int lengthOfLIS(int[] nums){
        int result = 0;
        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);

        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
        }

        for(int i: memo){
            result = Math.max(result, i);
        }

        return result;
    }
}
